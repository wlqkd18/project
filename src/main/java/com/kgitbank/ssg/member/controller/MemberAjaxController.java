package com.kgitbank.ssg.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgitbank.ssg.member.service.MemberService;

@RestController
@RequestMapping("member")

public class MemberAjaxController {

	@Autowired MemberService ms;
	
	@GetMapping("idCheck")
	public String idCheck(@RequestParam String id) {
		if(ms.idCheck(id) == 0)
			return "0";
		else if(ms.idCheck(id) == 1)
			return "1";
		return "2";
	}
	
}
