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
@Table("tb_register")
public class Register implements Serializable {

	@Column
	@Comment("咨询ID")
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
	@Comment("咨询编码")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("咨询名称")
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
	@Default("1")
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
	@Comment("其他信息")
	@ColDefine(type = ColType.VARCHAR, width = 500)
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column
	@Comment("咨询日期")
	@ColDefine(type = ColType.DATE)
	private Date consult_date;

	public String getConsult_date() {
		return DateConvertUtil.convertDate(create_date, "yyyy-MM-dd");
		// return consult_date;
	}

	public void setConsult_date(Date consult_date) {
		this.consult_date = consult_date;
	}

	@Column
	@Comment("登记号")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String record_no;

	public String getRecord_no() {
		return record_no;
	}

	public void setRecord_no(String record_no) {
		this.record_no = record_no;
	}

	@Column
	@Comment("学号")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String study_no;

	public String getStudy_no() {
		return study_no;
	}

	public void setStudy_no(String study_no) {
		this.study_no = study_no;
	}

	@Column
	@Comment("学员姓名")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String study_name;

	public String getStudy_name() {
		return study_name;
	}

	public void setStudy_name(String study_name) {
		this.study_name = study_name;
	}

	@Column
	@Comment("性别")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column
	@Comment("出生日期")
	@ColDefine(type = ColType.DATE)
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column
	@Comment("年龄")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long age;

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	@Column
	@Comment("身份证号")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String id_no;

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	@Column
	@Comment("联系电话")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String tel;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column
	@Comment("省")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String city_province;

	public String getCity_province() {
		return city_province;
	}

	public void setCity_province(String city_province) {
		this.city_province = city_province;
	}

	@Column
	@Comment("市")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String city_city;

	public String getCity_city() {
		return city_city;
	}

	public void setCity_city(String city_city) {
		this.city_city = city_city;
	}

	@Column
	@Comment("区")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String city_coutry;

	public String getCity_coutry() {
		return city_coutry;
	}

	public void setCity_coutry(String city_coutry) {
		this.city_coutry = city_coutry;
	}

	@Column
	@Comment("详细地址")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String city_detail;

	public String getCity_detail() {
		return city_detail;
	}

	public void setCity_detail(String city_detail) {
		this.city_detail = city_detail;
	}

	@Column
	@Comment("QQ号")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String qq;

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column
	@Comment("邮箱")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	@Comment("其他联系方式")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String other_mode;

	public String getOther_mode() {
		return other_mode;
	}

	public void setOther_mode(String other_mode) {
		this.other_mode = other_mode;
	}

	@Column
	@Comment("家长电话")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String family_tel;

	public String getFamily_tel() {
		return family_tel;
	}

	public void setFamily_tel(String family_tel) {
		this.family_tel = family_tel;
	}

	@Column
	@Comment("学历")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String study_level;

	public String getStudy_level() {
		return study_level;
	}

	public void setStudy_level(String study_level) {
		this.study_level = study_level;
	}

	@Column
	@Comment("其他学历")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String study_level_other;

	public String getStudy_level_other() {
		return study_level_other;
	}

	public void setStudy_level_other(String study_level_other) {
		this.study_level_other = study_level_other;
	}

	@Column
	@Comment("登记日期")
	@ColDefine(type = ColType.DATE)
	private Date record_date;

	public String getRecord_date() {
		return DateConvertUtil.convertDate(create_date, "yyyy-MM-dd");
		// return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

	@Column
	@Comment("登记人")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String record_by;

	public String getRecord_by() {
		return record_by;
	}

	public void setRecord_by(String record_by) {
		this.record_by = record_by;
	}

	@Column
	@Comment("课程编码")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String course_code;

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	@Column
	@Comment("课程名称")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String course_name;

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Column
	@Comment("课程路线")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String course_route;

	public String getCourse_route() {
		return course_route;
	}

	public void setCourse_route(String course_route) {
		this.course_route = course_route;
	}

	@Column
	@Comment("其他课程路线")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String course_rout_other;

	public String getCourse_rout_other() {
		return course_rout_other;
	}

	public void setCourse_rout_other(String course_rout_other) {
		this.course_rout_other = course_rout_other;
	}

	@Column
	@Comment("学习目标")
	@ColDefine(type = ColType.VARCHAR, width = 200)
	private String study_goal;

	public String getStudy_goal() {
		return study_goal;
	}

	public void setStudy_goal(String study_goal) {
		this.study_goal = study_goal;
	}

	@Column
	@Comment("图片关联ID")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String pic_id;

	public String getPic_id() {
		return pic_id;
	}

	public void setPic_id(String pic_id) {
		this.pic_id = pic_id;
	}
}
