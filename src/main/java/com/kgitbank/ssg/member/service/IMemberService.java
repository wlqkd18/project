package com.kgitbank.ssg.member.service;

import java.util.List;

import org.springframework.ui.Model;

import com.kgitbank.ssg.member.dto.MemberDTO;

public interface IMemberService {

	public int idCheck(String id);
	public int register(MemberDTO dto);
	public boolean login(MemberDTO dto);
	public String getMessage(String msg, String url);
	public void userInfo(String id, Model model);
	public void modifySuccess(MemberDTO dto);
	public void memberList(Model model, MemberDTO dto);
	public void memberDelete(String id);
	
}
