package com.kgitbank.ssg.product.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kgitbank.ssg.mybatis.product.ProductMapper;
import com.kgitbank.ssg.product.dto.ProductDTO;

@Service
public class ProductService implements IProductService {

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
}
