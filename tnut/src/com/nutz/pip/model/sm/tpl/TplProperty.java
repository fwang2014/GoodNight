package com.nutz.pip.model.sm.tpl;

import java.sql.Date;
import java.sql.Timestamp;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("tpl_property")
public class TplProperty implements Pojo {
	@Column
	@Id
	private int property_id;

	@Column
	@Name
	private String code;

	@Column
	private String name;

	@Column
	private int parent_id;

	@Column
	private String value;

	@Column
	private String status;

	@Column
	private Date create_date;

	@Column
	private String create_by;

	@Column
	private Timestamp last_update_time;

	@Column
	private String last_update_by;

	@Column
	private String scope;
	
	@Column
	//@ColDefine(type=ColType.VARCHAR, width=2000)
	private String path;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public String getLast_update_by() {
		return last_update_by;
	}

	public void setLast_update_by(String last_update_by) {
		this.last_update_by = last_update_by;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Timestamp getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Timestamp last_update_time) {
		this.last_update_time = last_update_time;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getProperty_id() {
		return property_id;
	}

	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
