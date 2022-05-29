package com.kgitbank.ssg.product.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface IProductService {

	public void getProductInfo(String productType, Model model);
	public String productSave(MultipartHttpServletRequest mul);
	public void getProductList(Model model);
	public void productInfo(int productNo, Model model, int num);
	public String productDelete(int productNo, String imageFileName);
	public String productModify(MultipartHttpServletRequest request);
	public boolean setBasket(String productNo, HttpServletRequest request);
}
