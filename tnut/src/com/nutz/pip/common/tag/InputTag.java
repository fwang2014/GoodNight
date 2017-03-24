package com.nutz.pip.common.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.nutz.pip.dao.MyTagDao;
import com.nutz.pip.model.cost.DicValue;

@SuppressWarnings("serial")
public class InputTag extends TagSupport {
	
	private String dictCode;//数据字典编码
	private String value;//当前值
	//private String elementType ;//元素类型	
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

	/*public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}*/

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = this.pageContext.getOut();
		
		try {

			//System.out.println(this.value+" | "+this.read);
			

				List<DicValue> list = this.myTagDao.getDictValueByCode(dictCode);
				
				if(list != null && list.size() > 0){
						boolean bool = false;
						String name = null;
						for(DicValue dic:list){
							String id = dic.getId();
							String value = dic.getValue();
							String remark = dic.getRemark();
							
							if(value.equals(this.value)){

								name = remark;
								bool = true;
								break;
							}					
						}
						
						if("Y".equals(this.read) || "y".equals(this.read)){
							read = "readonly=\"readonly\"";
						}else{
							read = "";
						}

						if(bool){
							out.println("<input "+read+" value=\""+value+"\" type=\"hidden\" NAME=\""+id+"\" ID=\""+id+"\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
							out.println("<input "+read+" value=\""+name+"\" type=\"text\" NAME=\""+id+"_name\" ID=\""+id+"_name\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
						}else{
							out.println("<input "+read+" value=\"\" type=\"hidden\" NAME=\""+id+"\" ID=\""+id+"\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
							out.println("<input "+read+" value=\"\" type=\"hidden\" NAME=\""+id+"_name\" ID=\""+id+"_name\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
						
						}
					
					
				}else{
					/**
					 * 如果查询无数据，则显示为空的选择列表
					 */
					out.println("<input "+read+" value=\"\" type=\"hidden\" NAME=\""+id+"\" ID=\""+id+"\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
					out.println("<input "+read+" value=\"\" type=\"hidden\" NAME=\""+id+"_name\" ID=\""+id+"_name\" class=\""+this.classStyle+"\" style=\""+this.style+"\"> ");
				
				}								

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	

}
