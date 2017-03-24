package com.nutz.pip.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.nutz.pip.dao.MyTagDao;
import com.nutz.pip.model.cost.DicValue;

@SuppressWarnings("serial")
public class MyTag extends TagSupport {
	
	private String dictCode;//数据字典编码
	private String value;//当前值
	private String elementType;//元素类型	
	private String id;	
	
	private String read;	

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private MyTagDao myTagDao = new MyTagDao();

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = this.pageContext.getOut();
		
		try {
			//out.println("dictCode:"+this.dictCode);
			//out.println("value:"+this.value);
			//out.println("elementType:"+this.elementType);
			System.out.println(this.value+" | "+this.read);
			
			if("SELECT".equals(elementType.toUpperCase())){
				String selectName = "select_"+this.dictCode;
				
				/*if(this.myTagDao == null){
					System.out.println("myTagDao is null");
				}else{
					System.out.println("myTagDao is not null");
				}*/
				
				List<DicValue> list = this.myTagDao.getDictValueByCode(dictCode);
				
				if(list != null && list.size() > 0){
					//System.out.println("list size:"+list.size());
					
					/**
					 * 如果给字段为仅读属性，则显示为文本框，不可编辑，ID为隐藏元素，根据ID值替换对应的显示值，如：F-女；1-已审核等
					 */
					if(this.read != null && ("TRUE".equals(this.read.toUpperCase()) || "Y".equals(this.read.toUpperCase()))){
						String valueName = "";
						
						for(DicValue dic:list){
							String id = dic.getId();
							String value = dic.getValue();
							String remark = dic.getRemark();
							
							if(value.equals(this.value)){
								valueName = remark;
							}						
						}
						
						out.println("<INPUT TYPE=\"TEXT\" NAME=\""+id+"_NAME\" ID=\""+id+"_NAME\" readonly=\"readonly\" value=\""+valueName+"\"> ");
						out.println("<INPUT TYPE=\"HIDDEN\" NAME=\""+id+"\" ID=\""+id+"\" value=\""+value+"\"> ");
					}else{
						/**
						 * 否则则显示为下来选择列表
						 */
						out.println("<SELECT NAME=\""+id+"\" ID=\""+id+"\"> ");
						
						out.println("<option value=\"\">--请选择--</option> ");
						for(DicValue dic:list){
							String id = dic.getId();
							String value = dic.getValue();
							String remark = dic.getRemark();
							
							if(value.equals(this.value)){
								out.println("<option value=\""+value+"\" selected>"+remark+"</option> ");
							}else{
								out.println("<option value=\""+value+"\">"+remark+"</option> ");
							}						
						}
						out.println("</SELECT> ");
					}
					
					/*if("TRUE".equals(this.read.toUpperCase()) || "Y".equals(this.read.toUpperCase())){
						out.println("<SELECT NAME=\""+id+"\" ID=\""+id+"\" readonly=\"readonly\"> ");
					}else{
						out.println("<SELECT NAME=\""+id+"\" ID=\""+id+"\"> ");
					}*/
					
					
					//out.println("<option value=\"\">${msg['display.label.please.choose']}</option> ");
					
				}else{
					/**
					 * 如果查询无数据，则显示为空的选择列表
					 */
					out.println("<SELECT NAME=\""+id+"\" ID=\""+id+"\"> ");
					out.println("<option value=\"\">--请选择--</option> ");
					out.println("</SELECT> ");
				}								
			}
			
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	

}
