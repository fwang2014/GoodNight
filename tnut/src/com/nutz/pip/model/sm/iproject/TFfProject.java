package com.nutz.pip.model.sm.iproject;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_ff_project")
public class TFfProject implements Pojo {
	@Name
	@Column
	private String id;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private String manager;

	@Column
	private Date psd;

	@Column
	private Date ped;

	@Column
	private Date fsd;

	@Column
	private Date fed;

	@Column
	private String curent_status;

	@Column
	private String status;

	@Column
	private Date cd;

	@Column
	private String cu;

	@Column
	private String luu;

	@Column
	private Date lut;

	@Column
	private String remark;

	public Date getCd() {
		return cd;
	}

	public void setCd(Date cd) {
		this.cd = cd;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCu() {
		return cu;
	}

	public void setCu(String cu) {
		this.cu = cu;
	}

	public String getCurent_status() {
		return curent_status;
	}

	public void setCurent_status(String curent_status) {
		this.curent_status = curent_status;
	}

	public Date getFed() {
		return fed;
	}

	public void setFed(Date fed) {
		this.fed = fed;
	}

	public Date getFsd() {
		return fsd;
	}

	public void setFsd(Date fsd) {
		this.fsd = fsd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLut() {
		return lut;
	}

	public void setLut(Date lut) {
		this.lut = lut;
	}

	public String getLuu() {
		return luu;
	}

	public void setLuu(String luu) {
		this.luu = luu;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPed() {
		return ped;
	}

	public void setPed(Date ped) {
		this.ped = ped;
	}

	public Date getPsd() {
		return psd;
	}

	public void setPsd(Date psd) {
		this.psd = psd;
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

}
