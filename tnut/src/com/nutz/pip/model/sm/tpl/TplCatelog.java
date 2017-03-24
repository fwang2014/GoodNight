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
@Table("tpl_catelog")
public class TplCatelog implements Pojo {
	@Column
	@Id
	private long catelog_id;

	@Column
	@Name
	private String code;

	@Column
	private String name;

	@Column
	private String status;

	@Column
	private String url;

	@Column
	private String description;

	@Column
	private String scope;

	@Column
	private Date create_date;

	@Column
	private String create_by;

	@Column
	private Date last_update_time;

	@Column
	private String last_update_by;

	@Column
	private long order_by;

	@Column
	private long parent_id;

	public long getCatelog_id() {
		return catelog_id;
	}

	public void setCatelog_id(long catelog_id) {
		this.catelog_id = catelog_id;
	}

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

	public long getOrder_by() {
		return order_by;
	}

	public void setOrder_by(long order_by) {
		this.order_by = order_by;
	}

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
