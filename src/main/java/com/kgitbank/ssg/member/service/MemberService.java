package com.kgitbank.ssg.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kgitbank.ssg.member.dto.MemberDTO;
import com.kgitbank.ssg.mybatis.member.MemberMapper;
import com.kgitbank.ssg.mybatis.product.ProductMapper;

@Service
public class MemberService implements IMemberService{

	@Autowired MemberMapper mapper;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public int idCheck(String id) {
		if(id.length() <= 0)
			return 2;
		return mapper.idCheck(id) == null ? 0 : 1;
	}

	@Override
	public int register(MemberDTO dto) {
		
		dto.setPw(encoder.encode(dto.getPw()));
		try {
			return mapper.register(dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean login(MemberDTO dto) {
		MemberDTO db = mapper.idCheck(dto.getId());
		if(db != null) {
			if(encoder.matches(dto.getPw(), db.getPw())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getMessage(String msg, String url) {
		String message = "<script>alert('"+msg+"');";
		message += "location.href='"+url+"'";
		message += "</script>";
		return message;
	}

	@Override
	public void userInfo(String id, Model model) {
		MemberDTO dto = mapper.idCheck(id);
		String[] addr = dto.getAddr().split(",");
		model.addAttribute("addr", addr);
		model.addAttribute("userInfo", dto);		
		mapper.idCheck(id);
	}

	@Override
	public void modifySuccess(MemberDTO dto) {
		MemberDTO db = mapper.idCheck(dto.getId());
		if(!dto.getPw().equals(db.getPw())) {
			dto.setPw(encoder.encode(dto.getPw()));
		}
		mapper.modify(dto);
	}

	@Override
	public void memberList(Model model, MemberDTO dto) {
		model.addAttribute("memberList", mapper.memberList(dto));
	}

	@Override
	public void memberDelete(String id) {
		mapper.memberDelete(id);
	}
	
	
}
