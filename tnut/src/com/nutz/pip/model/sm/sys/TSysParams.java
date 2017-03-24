package com.nutz.pip.model.sm.sys;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_params")
public class TSysParams implements Pojo {
	@Name
	@Column
	private String id;

	@Column
	private String sys_key;

	@Column
	private String sys_value;

	@Column
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSys_key() {
		return sys_key;
	}

	public void setSys_key(String sys_key) {
		this.sys_key = sys_key;
	}

	public String getSys_value() {
		return sys_value;
	}

	public void setSys_value(String sys_value) {
		this.sys_value = sys_value;
	}
}
