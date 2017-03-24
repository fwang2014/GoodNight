package com.nutz.pip.model.sm.sys;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_user")
public class TSysUser implements Pojo {
	@Column
	private String user_id;
	@Column
	private String user_code;
	@Column
	private String user_name;
	@Column
	private String account_name;
	@Column
	private String password;
	@Column
	private String type;
	@Column
	private String status;
	@Column
	private Date cd;
	@Column
	private String cu;
	@Column
	private String luu;
	@Column
	private String lut;
	
	private String rand;

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public Date getCd() {
		return cd;
	}

	public void setCd(Date cd) {
		this.cd = cd;
	}

	public String getCu() {
		return cu;
	}

	public void setCu(String cu) {
		this.cu = cu;
	}

	public String getLut() {
		return lut;
	}

	public void setLut(String lut) {
		this.lut = lut;
	}

	public String getLuu() {
		return luu;
	}

	public void setLuu(String luu) {
		this.luu = luu;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
