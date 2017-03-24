package com.nutz.pip.model.sm.ff;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@Table("t_ff_monthrent_detail")
public class TFfMonthrentDetail implements Pojo{
	@Name
	@Column
	private String id;

	@Column
	private String config_id;

	@Column
	private String rent_id;

	@Column
	private String name;

	@Column
	private float price;

	@Column
	private float qty;

	@Column
	private float amount;

	@Column
	private String unit;

	@Column
	private float startqty;

	@Column
	private float endqty;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getConfig_id() {
		return config_id;
	}

	public void setConfig_id(String config_id) {
		this.config_id = config_id;
	}

	public float getEndqty() {
		return endqty;
	}

	public void setEndqty(float endqty) {
		this.endqty = endqty;
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

	public String getRent_id() {
		return rent_id;
	}

	public void setRent_id(String rent_id) {
		this.rent_id = rent_id;
	}

	public float getStartqty() {
		return startqty;
	}

	public void setStartqty(float startqty) {
		this.startqty = startqty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}