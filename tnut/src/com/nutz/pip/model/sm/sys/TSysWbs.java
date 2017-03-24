package com.nutz.pip.model.sm.sys;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_sys_wbs")
public class TSysWbs implements Pojo {
	@Name
	@Column
	private String id;

	@Column
	private String parentid;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private Date planstartdate;

	@Column
	private Date planenddate;

	@Column
	private Date factstartdate;

	@Column
	private Date factenddate;

	@Column
	private String dutyuser;

	@Column
	private String dutyorg;

	@Column
	private String pre_wbs_id;

	@Column
	private String type;

	@Column
	private String status;

	@Column
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDutyorg() {
		return dutyorg;
	}

	public void setDutyorg(String dutyorg) {
		this.dutyorg = dutyorg;
	}

	public String getDutyuser() {
		return dutyuser;
	}

	public void setDutyuser(String dutyuser) {
		this.dutyuser = dutyuser;
	}

	public Date getFactenddate() {
		return factenddate;
	}

	public void setFactenddate(Date factenddate) {
		this.factenddate = factenddate;
	}

	public Date getFactstartdate() {
		return factstartdate;
	}

	public void setFactstartdate(Date factstartdate) {
		this.factstartdate = factstartdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Date getPlanenddate() {
		return planenddate;
	}

	public void setPlanenddate(Date planenddate) {
		this.planenddate = planenddate;
	}

	public Date getPlanstartdate() {
		return planstartdate;
	}

	public void setPlanstartdate(Date planstartdate) {
		this.planstartdate = planstartdate;
	}

	public String getPre_wbs_id() {
		return pre_wbs_id;
	}

	public void setPre_wbs_id(String pre_wbs_id) {
		this.pre_wbs_id = pre_wbs_id;
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
