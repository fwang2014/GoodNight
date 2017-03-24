package com.nutz.pip.model.data;

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
@Table("tb_dataimport_pic")
public class DataimportPic implements Serializable {

	@Column
	@Comment("数据导入ID")
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
	@Comment("导入图片编码")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("导入图片名称")
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
	@Comment("数据导入部分ID")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long import_part_id;

	public long getImport_part_id() {
		return import_part_id;
	}

	public void setImport_part_id(long import_part_id) {
		this.import_part_id = import_part_id;
	}

	@Column
	@Comment("图片名称")
	private String pic_name;

	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	@Column
	@Comment("图片类型")
	private String pic_type;

	public String getPic_type() {
		return pic_type;
	}

	public void setPic_type(String pic_type) {
		this.pic_type = pic_type;
	}

	@Column
	@Comment("图片大小")
	private String pic_size;

	public String getPic_size() {
		return pic_size;
	}

	public void setPic_size(String pic_size) {
		this.pic_size = pic_size;
	}

	@Column
	@Comment("图片临时路径")
	private String pic_tem_path;

	public String getPic_tem_path() {
		return pic_tem_path;
	}

	public void setPic_tem_path(String pic_tem_path) {
		this.pic_tem_path = pic_tem_path;
	}

	@Column
	@Comment("图片保存路径")
	private String pic_save_path;

	public String getPic_save_path() {
		return pic_save_path;
	}

	public void setPic_save_path(String pic_save_path) {
		this.pic_save_path = pic_save_path;
	}
}
