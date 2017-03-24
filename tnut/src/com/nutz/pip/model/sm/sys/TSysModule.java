package com.nutz.pip.model.sm.sys;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_module")
public class TSysModule implements Pojo {
	@Column
	private String module_id;
	@Column
	private String module_code;
	@Column
	private String module_name;
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
	public String getModule_code() {
		return module_code;
	}
	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}
	public String getModule_id() {
		return module_id;
	}
	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
