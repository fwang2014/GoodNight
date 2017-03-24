package gen.test;

import java.io.Serializable;
import java.sql.Date;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.common.DaoUtil;
import com.nutz.pip.model.cost.CostType;

@SuppressWarnings("serial")
@Table("tb_test_pojo")
public class MyPojo implements Serializable{


	@Column
	@Comment("")
	@ColDefine(type=ColType.VARCHAR,width=50)
	@Name
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.remark = remark;
	}

	@Column
	@Comment("编码")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.remark = remark;
	}

	@Column
	@Comment("成本名称")
	@ColDefine(type=ColType.VARCHAR,width=50)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.remark = remark;
	}

	@Column
	@Comment("成本类型")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.remark = remark;
	}

	@Column
	@Comment("发生日期")
	@ColDefine(type=ColType.DATE)
	private Date happendate;

	public Date getHappendate() {
		return happendate;
	}

	public void setHappendate(Date happendate) {
		this.remark = remark;
	}

	@Column
	@Comment("填报日期")
	@ColDefine(type=ColType.DATE)
	private Date filldate;

	public Date getFilldate() {
		return filldate;
	}

	public void setFilldate(Date filldate) {
		this.remark = remark;
	}

	@Column
	@Comment("填报人")
	@ColDefine(type=ColType.VARCHAR,width=20)
	private String filluser;

	public String getFilluser() {
		return filluser;
	}

	public void setFilluser(String filluser) {
		this.remark = remark;
	}

	@Column
	@Comment("单价")
	@ColDefine(type=ColType.FLOAT,width=10,precision=2)
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.remark = remark;
	}

	@Column
	@Comment("数量")
	@ColDefine(type=ColType.FLOAT,precision=2,width=10)
	private float qty;

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.remark = remark;
	}

	@Column
	@Comment("金额")
	@ColDefine(type=ColType.FLOAT,precision=2,width=10)
	private float amount;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.remark = remark;
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
	@Comment("单位")
	@ColDefine(type=ColType.VARCHAR,width=45)
	@Default("UNIT")
	private String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.remark = remark;
	}
	
	public static void main(String args[]){
		Dao dao = DaoUtil.getDao();
		
		if (!dao.exists(MyPojo.class)) {
			dao.create(MyPojo.class, true);
		}
	}

}
