package com.nutz.pip.model.customer;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

import com.nutz.utils.DateConvertUtil;

@SuppressWarnings("serial")
@Table("tb_dothing")
@View("v_tb_dothing")
public class Dothing implements Serializable {

	@Column
	@Comment("客户事务ID")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	@Comment("事务编码")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("事务名称")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	@Comment("类型")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	@Column("type_name")
	@Readonly
	private String type_name;
	

	@Column("status_name")
	@Readonly
	private String status_name;

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
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
	@Comment("创建人")
	@ColDefine(type = ColType.VARCHAR, width = 20)
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
		// return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
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
	@Comment("开始时间")
	private String start_time;

	public String getStart_time() {
		//return DateConvertUtil.convertDate(update_time, "yyyy-MM-dd HH:mm:ss");
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	@Column
	@Comment("结束时间")
	private String end_time;

	public String getEnd_time() {
		//return DateConvertUtil.convertDate(update_time, "yyyy-MM-dd HH:mm:ss");
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@Column
	@Comment("事务类型")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String do_type;

	public String getDo_type() {
		return do_type;
	}

	public void setDo_type(String do_type) {
		this.do_type = do_type;
	}
	
	@Column("do_type_name")
	@Readonly
	private String do_type_name;
	
	@Column("do_status_name")
	@Readonly
	private String do_status_name;
	
	public String getDo_type_name() {
		return do_type_name;
	}

	public void setDo_type_name(String do_type_name) {
		this.do_type_name = do_type_name;
	}

	public String getDo_status_name() {
		return do_status_name;
	}

	public void setDo_status_name(String do_status_name) {
		this.do_status_name = do_status_name;
	}

	@Column
	@Comment("完成状态")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String do_status;

	public String getDo_status() {
		return do_status;
	}

	public void setDo_status(String do_status) {
		this.do_status = do_status;
	}

	@Column
	@Comment("")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String re_persons;

	public String getRe_persons() {
		return re_persons;
	}

	public void setRe_persons(String re_persons) {
		this.re_persons = re_persons;
	}

	@Column
	@Comment("客户ID")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long customer_id;

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	@Column
	@Comment("客户姓名")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String customer_name;

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
}