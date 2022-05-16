package com.kgitbank.ssg.product.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface IProductService {

	public void getOuterType(Model model);
	public String productSave(MultipartHttpServletRequest mul);
	
}
