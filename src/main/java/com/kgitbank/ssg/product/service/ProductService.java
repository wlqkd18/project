package com.kgitbank.ssg.product.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kgitbank.ssg.mybatis.member.MemberMapper;
import com.kgitbank.ssg.mybatis.product.ProductMapper;
import com.kgitbank.ssg.product.dto.ProductDTO;

@Service
public class ProductService implements IProductService {

	@Autowired MemberMapper memberMapper;
	@Autowired ProductMapper mapper;
	@Autowired ProductFileService pfs;

	@Override
	public void getProductInfo(String productType, Model model) {
		DecimalFormat df = new DecimalFormat("###,###");
		List<ProductDTO> dto = mapper.getProduct(productType);

		for(ProductDTO p : dto) {
			p.setProductPrice(df.format(p.getProductPrice()));
		}
		model.addAttribute("productInfo", dto);
		
	}

	@Override
	public String productSave(MultipartHttpServletRequest mul) {
		
		ProductDTO dto = new ProductDTO();
		dto.setProductName(mul.getParameter("productName"));
		dto.setProductPrice(mul.getParameter("productPrice"));
		dto.setProductType(mul.getParameter("productType"));
		MultipartFile file = mul.getFile("imageFileName");
		dto.setOriginFileName(file.getOriginalFilename());
		
		if(file.getSize() != 0) {
			dto.setImageFileName(pfs.saveFile(file));
		}else {
			dto.setImageFileName("nan");
		}
		int result = mapper.productSave(dto);
		String msg, url;
		if(result == 1) {
			msg = "상품등록완료";
			url = "/ssg/member/managementForm";
		}else {
			msg = "문제가 발생했습니다.";
			url = "/ssg/product/productBoard";
		}

		return pfs.getMessage(msg, url);
	}

	@Override
	public void getProductList(Model model) {
		model.addAttribute("productList", mapper.getProductList());
		
	}

	@Override
	public void productInfo(int productNo, Model model, int num) {
		
		if(num == 1) {
			DecimalFormat df = new DecimalFormat("###,###");
			ProductDTO dto = mapper.getProductInfo(productNo);		
			dto.setProductPrice(df.format(dto.getProductPrice()));
			model.addAttribute("productInfo", dto);
		}else {
			model.addAttribute("productInfo", mapper.getProductInfo(productNo));
		}
	}

	@Override
	public String productDelete(int productNo, String imageFileName) {
		
		int result = mapper.productDelete(productNo);
		pfs.imageFileDelete(imageFileName);
		String msg, url;
		
		if(result == 1) {
			msg = "상품이 삭제되었습니다."; 
			url = "/ssg/product/productManagement";
		}else {
			msg = "문제가 발생했습니다.";
			url = "/ssg/product/productInfo?productNo=" + productNo;
		}
		return pfs.getMessage(msg, url);
	}

	@Override
	public String productModify(MultipartHttpServletRequest request) {
		
		ProductDTO dto = new ProductDTO();

		String fileName = request.getParameter("originFileName");
		
		dto.setProductName(request.getParameter("productName"));
		dto.setProductPrice(request.getParameter("productPrice"));
		dto.setProductType(request.getParameter("productType"));
		dto.setProductNo(Integer.parseInt(request.getParameter("productNo")));
		MultipartFile file = request.getFile("imageFileName");

		if(file.getSize() != 0) {
			pfs.imageFileDelete(fileName);
			dto.setImageFileName(pfs.saveFile(file));
		}else {
			dto.setImageFileName(request.getParameter("originFileName"));
		}

		int result = mapper.productModify(dto);
		String msg, url;
	
		if(result == 1) {
			msg = "수정되었습니다.";
			url = "/ssg/product/productInfo?productNo=" + request.getParameter("productNo");
		}else {
			msg = "오류가 발생하여 수정에 실패하였습니다.";
			url = "/ssg/product/productModify?productNo=" + request.getParameter("productNo");
		}
		
		return pfs.getMessage(msg, url);
	}

	@Override
	public boolean setBasket(String productNo, String size, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		int length = memberMapper.getBasket(id).split(",").length;
		String[] basket = new String[length];
		String[] basketSize = new String[length];
		String str = null;
		String sizeStr = null;
		
		if(memberMapper.getBasket(id).equals("nan")) {
			str = 0 + "," + productNo;
			sizeStr = 0 + "," + size;
		}else {
			for (int i = 0; i < length; i++) {
				basket[i] = memberMapper.getBasket(id).split(",")[i];
				basketSize[i] = memberMapper.getBasketSize(id).split(",")[i];
			}
			if(!Arrays.asList(basket).contains(productNo)) {
				str = String.join(",", basket);
				sizeStr = String.join(",", basketSize);
				str += "," + productNo;
				sizeStr += "," + size;
			}else {
				return false;
			}
		}
		int result = memberMapper.setBasket(id, str, sizeStr);
		if(result == 1) {
			return true;
		}
		return false;
		
	}

	@Override
	public void getBasketList(String id, Model model) {
		
		try {
			HashMap<String, String> map = new HashMap<String, String>();
			int length = memberMapper.getBasket(id).split(",").length;
			int priceSum = 0;
			ArrayList<Integer> no = new ArrayList<>();
			String[] basketNo = new String[length];
			String[] basketSize = new String[length];
			
			for(int i = 0; i < length; i++) {
				basketNo[i] = memberMapper.getBasket(id).split(",")[i];
				basketSize[i] = memberMapper.getBasketSize(id).split(",")[i];
			}
			for(int i = 1; i < length; i++) {
				map.put(basketNo[i], basketSize[i]);
				no.add(Integer.parseInt(basketNo[i]));
			}
			
			DecimalFormat df = new DecimalFormat("###,###");
			ArrayList<ProductDTO> dto = mapper.getProductBasket(no);
			for(int i = 0; i < dto.size(); i++) {
				int price = Integer.parseInt(String.valueOf(dto.get(i).getProductPrice()));
				priceSum += price;
				dto.get(i).setProductPrice(df.format(price));
			}
			model.addAttribute("productInfo", dto);
			model.addAttribute("sum", df.format(priceSum));
			model.addAttribute("no", map.keySet());
			model.addAttribute("size", map.values());	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void basketRemove(String productNo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginUser");
		ArrayList<String> basketNo = new ArrayList<>();
		ArrayList<String> basketSize = new ArrayList<>();
		int length = memberMapper.getBasket(id).split(",").length;
		for(int i = 0; i < length; i++) {
			String no = memberMapper.getBasket(id).split(",")[i];
			String size = memberMapper.getBasketSize(id).split(",")[i];
			basketNo.add(no);
			basketSize.add(size);
		}
		int index = basketNo.indexOf(productNo);
		basketNo.remove(index);
		basketSize.remove(index);
		String str = String.join(",", basketNo);
		String sizeStr = String.join(",", basketSize);
		System.out.println(str);
		System.out.println(sizeStr);
		int result = memberMapper.setBasket(id, str, sizeStr);
	}
	
}
