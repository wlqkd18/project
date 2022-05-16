package com.kgitbank.ssg.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kgitbank.ssg.product.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductComtroller {
	
	@Autowired ProductService ps;
	
	@GetMapping("outer")
	public String outerForm(Model model) {
		ps.getOuterType(model);
		return "product/outerForm";
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
	
}
