/**
 * 
 */
package com.nutz.pip.model.sm.db;

import java.sql.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Table("T_MY_TABLE")
public class MyTables  implements Pojo{
	
	@Id
	@Column
	private int id;
	
	@Column
	private String tableName;
	
	@Column
	private String tableRemark;
	
	@Column
	private Date createDate;
	

	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
