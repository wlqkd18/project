package com.kgitbank.ssg.member.dto;

public class MemberDTO {

	private String id;
	private String pw;
	private String email;
	private String addr;
	private String basket;
	private String basketSize;
	
	public String getSize() {
		return basketSize;
	}
	public void setSize(String size) {
		this.basketSize = size;
	}
	public String getBasket() {
		return basket;
	}
	public void setBasket(String basket) {
		this.basket = basket;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
