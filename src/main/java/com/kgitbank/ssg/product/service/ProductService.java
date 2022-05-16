package com.kgitbank.ssg.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kgitbank.ssg.mybatis.product.ProductMapper;
import com.kgitbank.ssg.product.dto.ProductDTO;

@Service
public class ProductService implements IProductService{

	@Autowired ProductMapper mapper;
	@Autowired ProductFileService pfs;

	@Override
	public void getOuterType(Model model) {
		model.addAttribute("outer", mapper.getOuterType());
	}

	@Override
	public String productSave(MultipartHttpServletRequest mul) {
		
		ProductDTO dto = new ProductDTO();
		dto.setProductName(mul.getParameter("productName"));
		dto.setProductPrice(Integer.parseInt(mul.getParameter("productPrice")));
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
}
