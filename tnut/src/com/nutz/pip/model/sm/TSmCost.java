/**
 * 
 */
package com.nutz.pip.model.sm;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
@Table("t_sm_cost")
public class TSmCost implements Pojo {
	/*
	 * create table `sm`.`t_sm_cost`( `ID` varchar(50) PRIMARY KEY not null,
	 * `CODE` varchar(50), `NAME` varchar(50), `TYPE` varchar(50), `HAPPENDATE`
	 * date, `FILLDATE` date, `FILLUSER` varchar(50), `UNIT` varchar(20),
	 * `PRICE` float, `QTY` int(11), `AMOUNT` float, `REMARK` varchar(500))
	 */
	@Column
	@Name
	//@Prev(@SQL("select cast(sysdate() as char(45))"))
	private String id;

	@Column
	private String code;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	private Date happendate;

	@Column
	private Date filldate;

	@Column
	private String filluser;

	@Column
	private String unit;

	@Column
	private float price;

	@Column
	private float qty;

	@Column
	private float amount;

	@Column
	private String remark;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getFilldate() {
		return filldate;
	}

	public void setFilldate(Date filldate) {
		this.filldate = filldate;
	}

	public String getFilluser() {
		return filluser;
	}

	public void setFilluser(String filluser) {
		this.filluser = filluser;
	}

	public Date getHappendate() {
		return happendate;
	}

	public void setHappendate(Date happendate) {
		this.happendate = happendate;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
