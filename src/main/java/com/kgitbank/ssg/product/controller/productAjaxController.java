package com.kgitbank.ssg.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.ssg.product.service.ProductService;

@RestController
@RequestMapping("product")
public class productAjaxController {

	@Autowired
	ProductService ps;
	
	@GetMapping(value = "basket", produces = "application/json; charset=utf-8")
	public String basket(@RequestParam String productNo, @RequestParam String size, HttpServletRequest request) {
		boolean bool = ps.setBasket(productNo, size, request);
		if(bool) {
			return "success";
		}
		return "error";
	}
	
	@GetMapping(value = "basketRemove", produces = "application/json; charset=utf-8")
	public void basketRemove(@RequestParam String productNo, HttpServletRequest request) {
		ps.basketRemove(productNo, request);
	}
	
	
	
}
