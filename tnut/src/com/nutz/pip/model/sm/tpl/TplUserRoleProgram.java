/**
 * 
 */
package com.nutz.pip.model.sm.tpl;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

/**
 * @author lenovo
 * 
 */
@SuppressWarnings("serial")
@Table("tpl_user_role_program")
public class TplUserRoleProgram implements Pojo {
	@Column
	private long urp_id;

	@Column
	private long user_id;

	@Column
	private long role_id;

	@Column
	private long program_id;

	@Column
	private Date start_date;

	@Column
	private Date end_date;

	@Column
	private Date create_date;

	@Column
	private String creaet_by;

	@Column
	private Date last_update_time;

	@Column
	private String last_update_by;

	@Column
	private String scope;

	public String getCreaet_by() {
		return creaet_by;
	}

	public void setCreaet_by(String creaet_by) {
		this.creaet_by = creaet_by;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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

	public long getProgram_id() {
		return program_id;
	}

	public void setProgram_id(long program_id) {
		this.program_id = program_id;
	}

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public long getUrp_id() {
		return urp_id;
	}

	public void setUrp_id(long urp_id) {
		this.urp_id = urp_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
}
