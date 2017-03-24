package com.nutz.pip.model.cost;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.utils.DateConvertUtil;

@SuppressWarnings("serial")
@Table("t_sm_cost")
public class SmCost implements Serializable{


	@Column
	@Comment("成本ID")
	@ColDefine(type=ColType.VARCHAR,width=50)
	@Name
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column
	@Comment("编码")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("成本名称")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	@Comment("成本类型")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	@Comment("发生日期")
	@ColDefine(type=ColType.DATE)
	private Date happendate;

	public String getHappendate() {
		return DateConvertUtil.convertDate(happendate, "yyyy-MM-dd");
		//return happendate;
	}

	public void setHappendate(Date happendate) {
		this.happendate = happendate;
	}

	@Column
	@Comment("填报日期")
	@ColDefine(type=ColType.DATE)
	private Date filldate;

	public String getFilldate() {
		return DateConvertUtil.convertDate(filldate, "yyyy-MM-dd");
		//return filldate;
	}

	public void setFilldate(Date filldate) {
		this.filldate = filldate;
	}

	@Column
	@Comment("填报人")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String filluser;

	public String getFilluser() {
		return filluser;
	}

	public void setFilluser(String filluser) {
		this.filluser = filluser;
	}

	@Column
	@Comment("单价")
	@ColDefine(type=ColType.FLOAT,width=10,precision=2)
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column
	@Comment("数量")
	@ColDefine(type=ColType.FLOAT,width=10,precision=2)
	private float qty;

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	@Column
	@Comment("金额")
	@ColDefine(type=ColType.FLOAT,width=10,precision=2)
	private float amount;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column
	@Comment("备注")
	@ColDefine(type=ColType.VARCHAR,width=500)
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column
	@Comment("单位")
	@ColDefine(type=ColType.VARCHAR,width=45)
	@Default("UNIT")
	private String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column
	@Comment("状态")
	@ColDefine(type=ColType.FLOAT,width=10,precision=0)
	@Default("0")
	private long status;

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Column
	@Comment("创建人")
	@ColDefine(type=ColType.VARCHAR,width=45)
	private String create_by;

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	@Column
	@Comment("创建日期")
	@ColDefine(type=ColType.DATE)
	private Date create_date;

	public String getCreate_date() {
		return DateConvertUtil.convertDate(create_date, "yyyy-MM-dd");
		//return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Column
	@Comment("更新人")
	@ColDefine(type=ColType.VARCHAR,width=45)
	private String update_by;

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	@Column
	@Comment("更新时间")
	private Date update_time;

	public String getUpdate_time() {
		return DateConvertUtil.convertDate(update_time, "yyyy-MM-dd HH:mm:ss");
		//return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}