/**
 * 
 */
package com.nutz.pip.model.sm.iworkflow;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

/**
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
@Table("T_WF_FORM_DETAIL")
public class WFFormDetail implements Pojo {
	@Id
	@Column
	private int id;

	@Name
	@Column
	private String code;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	private String key;

	@Column
	private int index;

	@Column
	private boolean isNumber;

	@Column
	private boolean isDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isDate() {
		return isDate;
	}

	public void setDate(boolean isDate) {
		this.isDate = isDate;
	}

	public boolean isNumber() {
		return isNumber;
	}

	public void setNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
