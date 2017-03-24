package com.nutz.pip.model.sm.fm;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@Table("t_fm_income")
@SuppressWarnings("serial")
public class Income implements Pojo {
	@Name
	@Column
	private String id;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private float amt;

	@Column("income_user")
	private String incomeUser;

	@Column("income_date")
	private Date incomeDate;

	@Column
	private String bank;

	@Column
	private String type;

	@Column
	private String cu;

	@Column
	private Date cd;

	@Column
	private String luu;

	@Column
	private Date lut;

	@Column
	private String remark;

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}

	public String getIncomeUser() {
		return incomeUser;
	}

	public void setIncomeUser(String incomeUser) {
		this.incomeUser = incomeUser;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
