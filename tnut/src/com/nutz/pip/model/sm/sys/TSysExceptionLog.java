package com.nutz.pip.model.sm.sys;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_exception_log")
public class TSysExceptionLog implements Pojo {
	@Name
	@Column
	private String id;

	@Column
	private String catch_time;

	@Column
	private String exception;

	@Column
	private String ex_cause;

	@Column
	private String ex_class;

	@Column
	private String ex_method;

	@Column
	private String ex_type;

	public String getCatch_time() {
		return catch_time;
	}

	public void setCatch_time(String catch_time) {
		this.catch_time = catch_time;
	}

	public String getEx_cause() {
		return ex_cause;
	}

	public void setEx_cause(String ex_cause) {
		this.ex_cause = ex_cause;
	}

	public String getEx_class() {
		return ex_class;
	}

	public void setEx_class(String ex_class) {
		this.ex_class = ex_class;
	}

	public String getEx_method() {
		return ex_method;
	}

	public void setEx_method(String ex_method) {
		this.ex_method = ex_method;
	}

	public String getEx_type() {
		return ex_type;
	}

	public void setEx_type(String ex_type) {
		this.ex_type = ex_type;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}