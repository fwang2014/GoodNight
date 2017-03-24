package com.nutz.pip.model.ittrain;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.utils.DateConvertUtil;

@SuppressWarnings("serial")
@Table("tb_class2")
public class Class2 implements Serializable{


	@Column
	@Comment("")
	@ColDefine(type=ColType.FLOAT,width=10,precision=0)
	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	@Comment("班级编码")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("班级名称")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	@Comment("班级类型")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	@Comment("创建人")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String create_by;

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
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

	@Column
	@Comment("更新人")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String update_by;

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	@Column
	@Comment("其他信息")
	@ColDefine(type=ColType.VARCHAR,width=500)
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column
	@Comment("开班时间")
	@ColDefine(type=ColType.DATE)
	private Date start_date;

	public String getStart_date() {
		//return start_date;
		return DateConvertUtil.convertDate(create_date, "yyyy-MM-dd");
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	@Column
	@Comment("结束时间")
	@ColDefine(type=ColType.DATE)
	private Date end_date;

	public String getEnd_date() {
		//return end_date;
		return DateConvertUtil.convertDate(create_date, "yyyy-MM-dd");
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	@Column
	@Comment("班级人数")
	@ColDefine(type=ColType.FLOAT,width=10,precision=0)
	private long class_member_num;

	public long getClass_member_num() {
		return class_member_num;
	}

	public void setClass_member_num(long class_member_num) {
		this.class_member_num = class_member_num;
	}

	@Column
	@Comment("课程编码")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String cource_code;

	public String getCource_code() {
		return cource_code;
	}

	public void setCource_code(String cource_code) {
		this.cource_code = cource_code;
	}

	@Column
	@Comment("课程名称")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String cource_name;

	public String getCource_name() {
		return cource_name;
	}

	public void setCource_name(String cource_name) {
		this.cource_name = cource_name;
	}
}
