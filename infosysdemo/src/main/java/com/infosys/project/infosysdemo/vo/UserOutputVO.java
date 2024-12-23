package com.infosys.project.infosysdemo.vo;

import java.io.Serializable;

public class UserOutputVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String roles;
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public UserOutputVO(Long id, String userName, String roles, String message) {
		super();
		this.id = id;
		this.userName = userName;
		this.roles = roles;
		this.message = message;
	}

	public UserOutputVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
