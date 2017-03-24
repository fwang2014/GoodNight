package com.nutz.pip.model.sys;

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
@Table("tb_user")
public class User2 implements Serializable {

	@Column
	@Comment("用户ID")
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
	@Comment("用户编码")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("用户名称")
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
	@Comment("账户名")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String account_name;

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	@Column
	@Comment("密码")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	@Comment("默认角色ID")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long default_role;

	public long getDefault_role() {
		return default_role;
	}

	public void setDefault_role(long default_role) {
		this.default_role = default_role;
	}

	@Column
	@Comment("显示名称")
	@ColDefine(type = ColType.VARCHAR, width = 50)
	private String nick_name;

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	@Column
	@Comment("上次登录时间")
	private Date last_login_time;

	public String getLast_login_time() {
		return DateConvertUtil.convertDate(update_time, "yyyy-MM-dd HH:mm:ss");
		// return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	@Column
	@Comment("本次登录时间")
	private Date login_time;

	public String getLogin_time() {
		return DateConvertUtil.convertDate(update_time, "yyyy-MM-dd HH:mm:ss");
		// return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	@Column
	@Comment("登录次数")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long login_times;

	public long getLogin_times() {
		return login_times;
	}

	public void setLogin_times(long login_times) {
		this.login_times = login_times;
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
}
