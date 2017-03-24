package com.nutz.pip.common.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.nutz.pip.dao.MyTagDao;
import com.nutz.pip.model.cost.DicValue;

@SuppressWarnings("serial")
public class SelectTag extends TagSupport {
	
	private String dictCode;//数据字典编码
	private String value;//当前值
	private String elementType ;//元素类型	
	private String id;	
	
	private String read;
	
	private String classStyle;
	private String style;


	public String getClassStyle() {
		return classStyle;
	}

	public void setClassStyle(String classStyle) {
		this.classStyle = classStyle;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

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
			//System.out.println(this.value+" | "+this.read);
			
			//if("SELECT".equals(elementType.toUpperCase())){
				List<DicValue> list = this.myTagDao.getDictValueByCode(dictCode);
				
				if(list != null && list.size() > 0){
					
						/**
						 * 否则则显示为下来选择列表
						 */
						out.println("<SELECT NAME=\""+id+"\" ID=\""+id+"\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
						
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
					
					
				}else{
					/**
					 * 如果查询无数据，则显示为空的选择列表
					 */
					out.println("<SELECT NAME=\""+id+"\" ID=\""+id+"\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
					out.println("<option value=\"\">--请选择--</option> ");
					out.println("</SELECT> ");
				}								
			//}
			
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	

}
