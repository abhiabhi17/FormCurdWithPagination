package com.example.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserEntity {
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private Long phno;
	private String country;
	private String activesw;
	
	
	
	public UserEntity() {
		super();
	}
	
	
	public UserEntity(String username, String email, Long phno, String country,
			String activesw) {
		super();
		
		this.username = username;
	
		this.email = email;
		this.phno = phno;
		this.country = country;
		this.activesw = activesw;
	}


	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getActivesw() {
		return activesw;
	}
	public void setActiveSw(String activesw) {
		this.activesw = activesw;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phno=" + phno + ", country=" + country + ", activesw=" + activesw + "]";
	}
	


	
	

}
