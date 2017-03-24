package com.nutz.pip.model.sm.sys;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_role")
public class TSysRole implements Pojo {
	@Column
	private String role_id;

	@Column
	private String role_code;

	@Column
	private String role_name;

	@Column
	private Date cd;

	@Column
	private String cu;

	@Column
	private String luu;

	@Column
	private String lut;

	@Column
	private String remark;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
}
