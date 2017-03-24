/**
 * 
 */
package com.nutz.pip.model.sm.iworkflow;

import java.sql.Timestamp;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.nutz.pip.model.sm.Pojo;

/**
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
@Table("T_WF_TASK_APPROVE")
public class WFTaskApprove implements Pojo {
	@Id
	@Column
	private int id;

	@Column
	private int task_id;

	@Column
	private String handle;
	
	@Column
	private Timestamp create_time;
	
	@Column
	private String comments;
	
	@Column
	private String items;
	
	@Column
	private String result;
	
	@Column
	private String transfer_to;

	@Column
	private boolean isDoc;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDoc() {
		return isDoc;
	}

	public void setDoc(boolean isDoc) {
		this.isDoc = isDoc;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTransfer_to() {
		return transfer_to;
	}

	public void setTransfer_to(String transfer_to) {
		this.transfer_to = transfer_to;
	}
	

}
