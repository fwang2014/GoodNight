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
@Table("t_sm_statterm")
public class SmStatterm implements Serializable {

	@Column
	@Comment("统计期间ID")
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
	@ColDefine(type = ColType.VARCHAR, width = 50)
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
	@Comment("数据类型")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	@Comment("开始日期")
	@ColDefine(type = ColType.DATE)
	private Date startdate;

	public String getStartdate() {
		return DateConvertUtil.convertDate(startdate, "yyyy-MM-dd");
		// return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Column
	@Comment("结束日期")
	@ColDefine(type = ColType.DATE)
	private Date enddate;

	public String getEnddate() {
		return DateConvertUtil.convertDate(enddate, "yyyy-MM-dd");
		// return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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
	@Comment("状态")
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
	@ColDefine(type = ColType.VARCHAR, width = 45)
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
	@ColDefine(type = ColType.VARCHAR, width = 45)
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
}
