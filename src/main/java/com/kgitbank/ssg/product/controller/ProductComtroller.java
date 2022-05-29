package com.kgitbank.ssg.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kgitbank.ssg.product.dto.ProductDTO;
import com.kgitbank.ssg.product.service.ProductFileService;
import com.kgitbank.ssg.product.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductComtroller {
	
	@Autowired ProductService ps;
	
	@GetMapping("productImageForm")
	public String productImageForm(@RequestParam String productType, Model model) {
		ps.getProductInfo(productType, model);
		return "product/productImageForm";
	}
	
	@GetMapping("productBoard")
	public String productBoard() {
		return "product/productBoard";
	}
	
	@PostMapping("productSave")
	public void productSave(MultipartHttpServletRequest mul, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = ps.productSave(mul);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.print(message);
	}
	
	@GetMapping("productManagement")
	public String productManagement(Model model) {
		ps.getProductList(model);
		return "product/productList";
	}
	
	@GetMapping("productInfo")
	public String productInfo(@RequestParam int productNo, Model model) {
		ps.productInfo(productNo, model, 1);
		return "product/productInfo";
	}
	
	@GetMapping("productDelete")
	public void productDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = ps.productDelete(Integer.parseInt(request.getParameter("productNo")), request.getParameter("imageFileName"));
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.print(message);
	}
	
	@GetMapping("imageFileDownload")
	public void imageFileDownload(@RequestParam String imageFileName, HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment; imageFileName=" + imageFileName);
		File file = new File(ProductFileService.IMAGE_REPO + "\\" + imageFileName);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream());

		in.close();
	}
	
	@GetMapping("productForm")
	public String outerForm(@RequestParam int productNo, Model model) {
		ps.productInfo(productNo, model, 1);
		return "product/productForm";
	}
	
	@GetMapping("productModify")
	public String productModify(@RequestParam int productNo, Model model) {
		ps.productInfo(productNo, model, 0);
		return "product/productBoard";
	}
	
	@PostMapping("modifySuccess")
	public void modifySuccess(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = ps.productModify(request);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.print(message);
	}
	
}
