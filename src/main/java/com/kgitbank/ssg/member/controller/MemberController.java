package com.kgitbank.ssg.member.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgitbank.ssg.member.dto.MemberDTO;
import com.kgitbank.ssg.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired MemberService ms;
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("registerSuccess")
	public String registerSuccess(MemberDTO dto) {
		
		
		if(ms.register(dto) == 1) {
			return "redirect:/";
		}
		return "redirect:register";
	}
	
	@PostMapping("login")
	public String login(HttpServletRequest request, HttpSession session) {
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));

		
		if(ms.login(dto)) {
			session.setAttribute("loginUser", request.getParameter("id"));
		}
		return "redirect:/"; 
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("userInfo")
	public String userInfo(@RequestParam String id, Model model) {
		
		ms.userInfo(id, model);
		return "member/userInfo";
	}
	
	@GetMapping("memberModify")
	public String memberModify(@RequestParam String id, Model model) {
		ms.userInfo(id, model);
		return "member/modifyForm";
	}
	
	@PostMapping("modifySuccess")
	public String modifySuccess(MemberDTO dto) {
		ms.modifySuccess(dto);
		return "redirect:/member/userInfo?id="+dto.getId();
	}
	
	@GetMapping("managementForm")
	public String managementForm(Model model) {
		return "member/managementForm";
	}
	
	@GetMapping("memberManage")
	public String memberManage(Model model, MemberDTO dto) {
		ms.memberList(model, dto);
		return "member/memberManageForm";
	}

	@GetMapping("memberDelete")
	public String memberDelete(@RequestParam String id, HttpSession session) {
		ms.memberDelete(id);
		return "redirect:memberManage";
	}
	
}
