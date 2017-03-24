package com.nutz.pip.model.sm.fm;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@SuppressWarnings("serial")
@Table("t_fm_withdraw")
public class Withdraw implements Pojo {

	@Name
	@Column
	private String id;

	@Column
	private String code;

	@Column
	private String name;

	@Column("draw_user")
	private String drawUser;

	@Column("draw_date")
	private Date rawDate;

	@Column
	private float amt;

	@Column("bank_name")
	private String bankName;

	@Column("bank_card")
	private String bankCard;

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

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public String getDrawUser() {
		return drawUser;
	}

	public void setDrawUser(String drawUser) {
		this.drawUser = drawUser;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRawDate() {
		return rawDate;
	}

	public void setRawDate(Date rawDate) {
		this.rawDate = rawDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
