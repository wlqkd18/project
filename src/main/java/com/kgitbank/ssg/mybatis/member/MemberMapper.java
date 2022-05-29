package com.kgitbank.ssg.mybatis.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kgitbank.ssg.member.dto.MemberDTO;

public interface MemberMapper {

	public MemberDTO idCheck(String id);
	public int register(MemberDTO dto);
	public MemberDTO login(MemberDTO dto);
	public void modify(MemberDTO dto);
	public List<MemberDTO> memberList(MemberDTO dto);
	public void memberDelete(String id);
	public String getBasket(String id);
	public int setBasket(@Param(value = "id") String id, @Param(value = "str") String str);

}
