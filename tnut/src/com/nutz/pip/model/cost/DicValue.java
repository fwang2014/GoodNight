package com.nutz.pip.model.cost;

import java.io.Serializable;
import java.sql.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@SuppressWarnings("serial")
@Table("tb_dic_value")
public class DicValue implements Serializable{


	@Column
	@Comment("ID")
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
	@Comment("数据字典类型ID")
	@ColDefine(type=ColType.VARCHAR,width=50,precision=0)
	private String type_id;

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	@Column
	@Comment("数据类型")
	@ColDefine(type=ColType.FLOAT,width=10,precision=0)
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
	@ColDefine(type=ColType.FLOAT,width=10,precision=0)
	@Default("0")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column
	@Comment("创建人")
	@ColDefine(type=ColType.VARCHAR,width=50)
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

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Column
	@Comment("更新人")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String update_by;

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	@Column
	@Comment("更新时间")
	private String update_time;

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
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
	@Comment("值")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
