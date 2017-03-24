package com.nutz.pip.model;

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
@Table("t_sm_user")
public class SmUser implements Serializable{


	@Column
	@Comment("")
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
	@Comment("编码")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("用户名称")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column
	@Comment("昵称")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column
	@Comment("密码")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	@Comment("用户类型")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	@Comment("用户状态")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column
	@Comment("创建日期")
	@ColDefine(type=ColType.DATE)
	private Date createdate;

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Column
	@Comment("创建用户")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String createuser;

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	@Column
	@Comment("最后更新时间")
	@Default("now()")
	private String lastupdatetime;

	public String getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	@Column
	@Comment("最后更新用户")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String lastupdateuser;

	public String getLastupdateuser() {
		return lastupdateuser;
	}

	public void setLastupdateuser(String lastupdateuser) {
		this.lastupdateuser = lastupdateuser;
	}
}
