/**
 * 
 */
package com.nutz.pip.model.sm.tpl;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

/**
 * @author lenovo
 * 
 */
@SuppressWarnings("serial")
@Table("tpl_program")
public class TplProgram implements Pojo {
	@Column
	@Id
	private long program_id;

	@Column
	@Name
	private String code;

	@Column
	private String name;

	@Column
	private String scope;

	@Column
	private String type;

	@Column
	private Date create_date;

	@Column
	private String create_by;

	@Column
	private Date last_update_time;

	@Column
	private String last_update_by;

	@Column
	private String description;

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

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLast_update_by() {
		return last_update_by;
	}

	public void setLast_update_by(String last_update_by) {
		this.last_update_by = last_update_by;
	}

	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getProgram_id() {
		return program_id;
	}

	public void setProgram_id(long program_id) {
		this.program_id = program_id;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
