package com.nutz.pip.model.sm.sys;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_userrole")
public class TSysUserrole implements Pojo {
	@Column
	private String user_id;

	@Column
	private String role_id;

	@Column
	@Name
	private String ur_id;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getUr_id() {
		return ur_id;
	}

	public void setUr_id(String ur_id) {
		this.ur_id = ur_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
