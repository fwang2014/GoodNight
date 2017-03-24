/**
 * 
 */
package com.nutz.pip.model.sm.iworkflow;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

/**
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
@Table("T_WF_MODULE_DETAIL")
public class WFModuleDetail implements Pojo {
	@Id
	@Column
	private int id;

	@Column
	private int moduleId;

	@Column
	private int ind;

	@Column
	private String name;

	@Column
	private String approveUser;

	@Column
	private int ok;

	@Column
	private int fail;

	@Column
	private int delayTime;

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getApproveUser() {
		return approveUser;
	}

	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}

	public int getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(int delayTime) {
		this.delayTime = delayTime;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInd() {
		return ind;
	}

	public void setInd(int ind) {
		this.ind = ind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

}
