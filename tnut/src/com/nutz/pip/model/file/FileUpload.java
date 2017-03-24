package com.nutz.pip.model.file;

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
@Table("tb_file_upload")
public class FileUpload implements Serializable{


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
	@Comment("上载编码")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("上载名称")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	@Comment("类型")
	@ColDefine(type=ColType.VARCHAR,width=20)
	@Default("0")
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
	@Comment("文件类型")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String file_type;

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	@Column
	@Comment("文件大小")
	@ColDefine(type=ColType.FLOAT,width=18,precision=2)
	private String file_size;

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	@Column
	@Comment("文件原始名")
	@ColDefine(type=ColType.VARCHAR,width=200)
	private String file_old_name;

	public String getFile_old_name() {
		return file_old_name;
	}

	public void setFile_old_name(String file_old_name) {
		this.file_old_name = file_old_name;
	}

	@Column
	@Comment("文件上载名")
	@ColDefine(type=ColType.VARCHAR,width=200)
	private String file_new_name;

	public String getFile_new_name() {
		return file_new_name;
	}

	public void setFile_new_name(String file_new_name) {
		this.file_new_name = file_new_name;
	}

	@Column
	@Comment("存储路径")
	@ColDefine(type=ColType.VARCHAR,width=200)
	private String save_path;

	public String getSave_path() {
		return save_path;
	}

	public void setSave_path(String save_path) {
		this.save_path = save_path;
	}

	@Column
	@Comment("临时存储路径")
	@ColDefine(type=ColType.VARCHAR,width=200)
	private String save_tem_path;

	public String getSave_tem_path() {
		return save_tem_path;
	}

	public void setSave_tem_path(String save_tem_path) {
		this.save_tem_path = save_tem_path;
	}

	@Column
	@Comment("业务引用ID")
	@ColDefine(type=ColType.FLOAT,width=10,precision=0)
	private long ref_id;

	public long getRef_id() {
		return ref_id;
	}

	public void setRef_id(long ref_id) {
		this.ref_id = ref_id;
	}

	@Column
	@Comment("业务类型")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String ref_type;

	public String getRef_type() {
		return ref_type;
	}

	public void setRef_type(String ref_type) {
		this.ref_type = ref_type;
	}
}
