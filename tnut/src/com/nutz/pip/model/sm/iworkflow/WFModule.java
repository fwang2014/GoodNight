package com.nutz.pip.model.sm.iworkflow;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

/**
 * 
 * @author Administrator
 * @see 工作流模板对象
 */
@SuppressWarnings("serial")
@Table("T_WF_MODULE")
public class WFModule implements Pojo {
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
	private boolean isDoc;

	@Column
	private boolean isTransfer;

	@Column
	private String status;

	@Column
	private String createUser;

	@Column
	private Date createDate;

	@Column
	private String remark;

	@Column
	private int formId;

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDoc() {
		return isDoc;
	}

	public void setDoc(boolean isDoc) {
		this.isDoc = isDoc;
	}

	public boolean isTransfer() {
		return isTransfer;
	}

	public void setTransfer(boolean isTransfer) {
		this.isTransfer = isTransfer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
