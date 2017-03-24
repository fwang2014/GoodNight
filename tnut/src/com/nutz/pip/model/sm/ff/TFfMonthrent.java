package com.nutz.pip.model.sm.ff;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

@Table("t_ff_monthrent")
public class TFfMonthrent implements Pojo{
	@Name
	@Column
	private String id;

	@Column
	private Date rent_date;

	@Column
	private String name;

	@Column
	private String house_lord;

	@Column
	private String house_rent;

	@Column
	private String house_place;

	@Column
	private Date start_date;

	@Column
	private Date end_date;

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getHouse_lord() {
		return house_lord;
	}

	public void setHouse_lord(String house_lord) {
		this.house_lord = house_lord;
	}

	public String getHouse_place() {
		return house_place;
	}

	public void setHouse_place(String house_place) {
		this.house_place = house_place;
	}

	public String getHouse_rent() {
		return house_rent;
	}

	public void setHouse_rent(String house_rent) {
		this.house_rent = house_rent;
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

	public Date getRent_date() {
		return rent_date;
	}

	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
}
