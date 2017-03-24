package com.nutz.pip.model.cost;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

import com.nutz.utils.DateConvertUtil;

@SuppressWarnings("serial")
@Table("tb_cost_fill")
@View("v_tb_cost_fill")
public class CostFill2 implements Serializable {
	
	@Column("type_name")
	@Readonly
	private String type_name;

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	@Column("unit_name")
	@Readonly
	private String unit_name;

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	@Column
	@Comment("ID")
	@ColDefine(type = ColType.VARCHAR, width = 50)
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
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("名称")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	@Comment("起始值")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String start_value;

	public String getStart_value() {
		return start_value;
	}

	public void setStart_value(String start_value) {
		this.start_value = start_value;
	}

	@Column
	@Comment("结束值")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String end_value;

	public String getEnd_value() {
		return end_value;
	}

	public void setEnd_value(String end_value) {
		this.end_value = end_value;
	}

	@Column
	@Comment("值类型")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long value_type;

	public long getValue_type() {
		return value_type;
	}

	public void setValue_type(long value_type) {
		this.value_type = value_type;
	}

	@Column
	@Comment("单价")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 2)
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column
	@Comment("数量")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 2)
	private float qty;

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	@Column
	@Comment("金额")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 2)
	private float amt;

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	@Column
	@Comment("单位")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column
	@Comment("数据类型")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	@Default("0")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	@Comment("数据状态")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
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
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String create_by;

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	@Column
	@Comment("创建日期")
	@ColDefine(type = ColType.DATE)
	private Date create_date;

	public String getCreate_date() {
		return DateConvertUtil.convertDate(create_date, "yyyy-MM-dd");
		// return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Column
	@Comment("更新人")
	@ColDefine(type = ColType.VARCHAR, width = 20)
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
		// return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Column
	@Comment("备注")
	@ColDefine(type = ColType.VARCHAR, width = 500)
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column
	@Comment("填报时间")
	private Date fill_date;

	public String getFill_date() {
		return DateConvertUtil.convertDate(fill_date, "yyyy-MM-dd");
		// return fill_date;
	}

	public void setFill_date(Date fill_date) {
		this.fill_date = fill_date;
	}
}
