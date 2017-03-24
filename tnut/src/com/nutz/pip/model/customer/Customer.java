package com.nutz.pip.model.customer;

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
@Table("tb_customer")
public class Customer implements Serializable {

	@Column
	@Comment("")
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
	@Comment("客户编码")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("客户名称")
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
	@Comment("性别")
	@ColDefine(type = ColType.VARCHAR, width = 2)
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
	private Date birthday_date;

	public String getBirthday_date() {
		return DateConvertUtil.convertDate(create_date, "yyyy-MM-dd");
		// return birthday_date;
	}

	public void setBirthday_date(Date birthday_date) {
		this.birthday_date = birthday_date;
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
	@Comment("教育程度")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String edu_level;

	public String getEdu_level() {
		return edu_level;
	}

	public void setEdu_level(String edu_level) {
		this.edu_level = edu_level;
	}

	@Column
	@Comment("工作状态")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String work_status;

	public String getWork_status() {
		return work_status;
	}

	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}

	@Column
	@Comment("手机")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column
	@Comment("电话")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String tel;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column
	@Comment("家庭电话")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column
	@Comment("家庭住址")
	@ColDefine(type = ColType.VARCHAR, width = 200)
	private String house;

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	@Column
	@Comment("邮箱")
	@ColDefine(type = ColType.VARCHAR, width = 200)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	@Comment("QQ")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String qq;

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column
	@Comment("MSN")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String msn;

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	@Column
	@Comment("阿里旺旺")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String aliww;

	public String getAliww() {
		return aliww;
	}

	public void setAliww(String aliww) {
		this.aliww = aliww;
	}

	@Column
	@Comment("网址")
	@ColDefine(type = ColType.VARCHAR, width = 200)
	private String website;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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
	@Comment("银行卡号")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String bank_card;

	public String getBank_card() {
		return bank_card;
	}

	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}

	@Column
	@Comment("职务")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String duties;

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	@Column
	@Comment("称谓")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
