package com.nutz.pip.model.sm.sys;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_operate_log")
public class TSysOperateLog implements Pojo {
	@Name
	@Column
	private String id;
	@Column
	private String project_name;
	@Column
	private String action_name;
	@Column
	private Date cd;
	@Column
	private String cu;
	@Column
	private String type;
	@Column
	private String lut;
	@Column
	private String request_id;
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLut() {
		return lut;
	}
	public void setLut(String lut) {
		this.lut = lut;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
