package com.nutz.pip.model.sm.ff;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@Table("t_ff_rent_config_detail")
public class TFfRentConfigDetail implements Pojo{
	@Name
	@Column
	private String id;

	@Column
	private String head_id;

	@Column
	private float price;

	@Column
	private float qty;

	@Column
	private float startqty;

	@Column
	private float endqty;

	@Column
	private String unit;

	public float getEndqty() {
		return endqty;
	}

	public void setEndqty(float endqty) {
		this.endqty = endqty;
	}

	public String getHead_id() {
		return head_id;
	}

	public void setHead_id(String head_id) {
		this.head_id = head_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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