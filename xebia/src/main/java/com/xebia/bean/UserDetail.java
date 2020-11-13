package com.xebia.bean;

import java.util.Date;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserDetail {

	private Integer userId;
	private String userName;
	private String role;
	private Date createdDate;

	public UserDetail setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public UserDetail setUserName(String userName) {
		this.userName = userName;
		return this;
	}


	public UserDetail setRole(String role) {
		this.role = role;
		return this;
	}

	public UserDetail setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	

}
