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
 * @see 工作流参数表
 * 
 */
@SuppressWarnings("serial")
@Table("T_WF_PARAMS")
public class WFParams implements Pojo {
	@Id
	@Column
	private int id;

	@Name
	@Column
	private String key;

	@Column
	private String value;

	@Column
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
