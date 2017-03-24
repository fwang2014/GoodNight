package com.nutz.pip.model.sm.sys;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_menu")
public class TSysMenu implements Pojo {
	@Column
	private String menu_id;
	@Column
	private String menu_code;
	@Column
	private String menu_name;
	@Column
	private String menu_parent_id;
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
	@Column
	private String remark;
	@Column
	private String url;
	@Column
	private String is_default;
	@Column
	private String module_id;
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
	public String getIs_default() {
		return is_default;
	}
	public void setIs_default(String is_default) {
		this.is_default = is_default;
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
	public String getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_parent_id() {
		return menu_parent_id;
	}
	public void setMenu_parent_id(String menu_parent_id) {
		this.menu_parent_id = menu_parent_id;
	}
	public String getModule_id() {
		return module_id;
	}
	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
