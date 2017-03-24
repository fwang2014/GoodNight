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
@Table("tpl_permission")
public class TplPermission implements Pojo {
	@Column
	@Id
	private long permission_id;

	@Column
	@Name
	private long catelog_id;

	@Column
	private long role_id;

	@Column
	private Date create_date;

	@Column
	private String create_by;

	@Column
	private Date last_update_time;

	@Column
	private String last_update_by;

	@Column
	private String scope;

	public long getCatelog_id() {
		return catelog_id;
	}

	public void setCatelog_id(long catelog_id) {
		this.catelog_id = catelog_id;
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

	public long getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(long permission_id) {
		this.permission_id = permission_id;
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
}
