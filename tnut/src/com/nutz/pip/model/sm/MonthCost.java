package com.nutz.pip.model.sm;

import java.math.BigDecimal;
import java.sql.Date;

public class MonthCost implements Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date happendate;

	private BigDecimal amtsum;

	private int batch;

	private int myweek;

	private String type;

	public BigDecimal getAmtsum() {
		return amtsum;
	}

	public void setAmtsum(BigDecimal amtsum) {
		this.amtsum = amtsum;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public Date getHappendate() {
		return happendate;
	}

	public void setHappendate(Date happendate) {
		this.happendate = happendate;
	}

	public int getMyweek() {
		return myweek;
	}

	public void setMyweek(int myweek) {
		this.myweek = myweek;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
