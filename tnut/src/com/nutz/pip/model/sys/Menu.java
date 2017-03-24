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
@Table("tb_menu")
public class Menu implements Serializable {

	@Column
	@Comment("菜单ID")
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
	@Comment("菜单编码")
	@ColDefine(type = ColType.VARCHAR, width = 20)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column
	@Comment("菜单名称")
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
	@Comment("父ID")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long parent_id;

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}

	@Column
	@Comment("请求地址")
	@ColDefine(type = ColType.VARCHAR, width = 200)
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column
	@Comment("菜单图标")
	@ColDefine(type = ColType.VARCHAR, width = 200)
	private String menu_icon;

	public String getMenu_icon() {
		return menu_icon;
	}

	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}

	@Column
	@Comment("是否根层菜单")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	@Default("0")
	private long is_root;

	public long getIs_root() {
		return is_root;
	}

	public void setIs_root(long is_root) {
		this.is_root = is_root;
	}

	@Column
	@Comment("显示序号")
	@ColDefine(type = ColType.FLOAT, width = 10, precision = 0)
	private long order_index;

	public long getOrder_index() {
		return order_index;
	}

	public void setOrder_index(long order_index) {
		this.order_index = order_index;
	}
}
