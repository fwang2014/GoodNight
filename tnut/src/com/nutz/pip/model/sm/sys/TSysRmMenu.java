package com.nutz.pip.model.sm.sys;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_rm_menu")
public class TSysRmMenu implements Pojo {
	@Name
	@Column
	private String rmm_id;
	@Column
	private String rm_id;
	@Column
	private String menu_id;
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getRm_id() {
		return rm_id;
	}
	public void setRm_id(String rm_id) {
		this.rm_id = rm_id;
	}
	public String getRmm_id() {
		return rmm_id;
	}
	public void setRmm_id(String rmm_id) {
		this.rmm_id = rmm_id;
	}
}