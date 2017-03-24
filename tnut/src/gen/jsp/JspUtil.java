package gen.jsp;

import gen.test.Test;

import java.io.PrintStream;
import java.util.List;

import org.nutz.lang.Lang;

public class JspUtil {
	
	/**
	 * @deprecated
	 * @param table
	 */
	private void outDataList(String table){
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,false);
		
		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		
		ps.println("----------------------------this is data "+table+" table list start------------------------------");
		
		ps.println();
		
		ps.println("<form action=\"<%=path %>/"+table+"/list?\" method=\"post\"  id=\"listForm\" name=\"listForm\">");
		
		ps.println("<table class=\"table table-bordered\">");
		ps.println("\t<thead>");
		ps.println("\t\t<tr>");
		
		ps.println("\t\t<th><input type=\"checkbox\" name=\"all\"/></th>");
		
		for(String[] strs:list){
			String name= strs[0];
			//String type = strs[1];
			
			if(Lang.contains(Test.columnFilters, name)){
				continue;
			}

			ps.println("\t\t<th>${msg['label."+table+"."+name+"']}</th>");
		}
		
		ps.println("\t\t</tr>");
		
		ps.println("\t</thead>");
		ps.println("<tbody>");
		
		ps.println();
		
		ps.println("<c:forEach items=\"${list}\" var=\"tag\" varStatus=\"id\">");
		ps.println("\t<tr class=\"tr_data\">");
		ps.println("\t\t");
		
		ps.println("\t\t<td nowrap><input type=\"checkbox\" name=\"ids\" value=\"${tag.id}\"/></td>");
		
		for(String[] strs:list){
			String name= strs[0];
			//String type = strs[1];
			
			if(Lang.contains(Test.columnFilters, name)){
				continue;
			}

			ps.println("\t\t\t<td nowrap>${tag."+name.toLowerCase()+"}</td>");
			//ps.println("\t\t\t${id."+name+"}");
			//ps.println("\t\t\t</td>");
		}
		
		ps.println("\t\t");
		ps.println("\t</tr>");
		ps.println("</c:forEach>");		
		
		ps.println();
		
		ps.println("</tbody>");
		ps.println("</table>");
		
		ps.println("</form>");
		
		ps.println();
		
		ps.println("----------------------------this is data table list end------------------------------");
		ps.println();
	}
	
	/**
	 * @deprecated
	 * @param table
	 */
	private void outDataAdd(String table){
		//List<String[]> list = Test.getTableColumns(table);
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,false);
		
		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		
		ps.println("----------------------------this is data "+table+" table add start------------------------------");
		ps.println();
		ps.println("<form action=\"<%=path %>/"+table+"/save?\" method=\"post\">");
		
		ps.println("\t<table class=\"table table-bordered\">");
		
		int i = 0;
		int size = list.size();
		for(String[] strs:list){
			
			String name= strs[0];
			
			int v = i%4;
			
			if(v==0){
				if(i==0){
					ps.println("\t\t<tr><td>${msg['label."+table+"."+name+"']}</td>");
				}else{
					ps.println("\t\t<tr><td>${msg['label."+table+"."+name+"']}</td>");
				}
				
			}else if (v==1){
				ps.println("\t\t\t<td>");
				ps.println("\t\t\t\t<INPUT TYPE=\"TEXT\" NAME=\""+table+"."+name+"\" value=\"${"+table+"."+name.toLowerCase()+" }\"/>");
				ps.println("\t\t\t</td>");
			}else if(v==2){
				ps.println("\t\t\t<td>${msg['label."+table+"."+name+"']}</td>");
			}else if(v==3){
				ps.println("\t\t\t<td>");
				ps.println("\t\t\t\t<INPUT TYPE=\"TEXT\" NAME=\""+table+"."+name+"\" value=\"${"+table+"."+name.toLowerCase()+" }\"/>");
				ps.println("\t\t\t</td>");
				ps.println("\t\t</tr>");
			}

			i++;
			if(i==size){
				ps.println("\t\t</tr>");
			}
		}
		
		ps.println("\t<tr>");
		ps.println("\t<tr>");
		
		ps.println("\t\t<td colspan=\"4\" align=\"center\">");
		ps.println("\t\t\t<input type=\"button\" name=\"btn_save\" class=\"btn\" value=\"保存\"> ");
		ps.println("\t\t</td>");
		
		ps.println("\t</table>");
		
		ps.println("</form>");
		ps.println();
		ps.println("----------------------------this is data "+table+" table add end------------------------------");
		ps.println();
	}
	
	/**
	 * 输出表字段的查询列表代码
	 * @param list
	 * @param table
	 */
	public void outDataList(List<String[]> list,String table){
		//List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA);
		
		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		
		ps.println("----------------------------this is data "+table+" table list start------------------------------");
		
		/*String table_cn = null;
		if(list != null && list.size()>0){
			String str[] = list.get(0);
			table_cn = str[11];
		}*/
		
		ps.println("<ul class=\"breadcrumb\">");
		ps.println("<li><a href=\"<%=path%>/welcome?\" class=\"label label-info\">Home</a>");
		ps.println("<span class=\"divider\">/</span></li>");
		ps.println("<li><a href=\"<%=path%>/"+table+"/list?\" class=\"label label-info\">${msg['display.label.nav.sys']}</a>");
		ps.println("<span class=\"divider\">/</span></li>");
		ps.println("<li class=\"active\">${msg['label."+table+".TABLE_CN']}${msg['display.label.list']}</li>");
		ps.println("</ul>");
		ps.println("</div>");
		ps.println();
		ps.println("<div class=\"bs-docs-example\" style=\"margin-top: 2px;\">");
		ps.println("<div class=\"navbar\">");
		ps.println("<div class=\"navbar-inner\">");
		ps.println("<ul class=\"nav\">");
		ps.println("<li class=\"active\"><a href=\"<%=path%>/"+table+"/list?\">${msg['label."+table+".TABLE_CN']}${msg['display.label.list']}</a></li>");
		ps.println("<li><a href=\"<%=path%>/"+table+"/add?\">${msg['label."+table+".TABLE_CN']}${msg['display.label.add']}</a></li>");
		ps.println("</ul>");
		ps.println("</div>");
		ps.println("</div>");
		ps.println("</div>");
		
		ps.println();
		
		ps.println("<form action=\"<%=path %>/"+table+"/list?\" method=\"post\"  id=\"listForm\" name=\"listForm\">");
		
		ps.println("<table class=\"table table-bordered\">");
		ps.println("\t<thead>");
		ps.println("\t\t<tr>");
		
		ps.println("\t\t<th><input type=\"checkbox\" name=\"all\" onclick=\"selectAll('ids')\"/></th>");
		ps.println("\t\t<th>#</th>");
		
		for(String[] strs:list){
			String name= strs[0];
			//String type = strs[1];
			
			if(Lang.contains(Test.columnFilters, name.toUpperCase())){
				continue;
			}

			ps.println("\t\t<th>${msg['label."+table+"."+name.toUpperCase()+"']}</th>");
		}
		ps.println("\t\t<th>${msg['label.OPERATION']}</th>");
		
		ps.println("\t\t</tr>");
		
		ps.println("\t</thead>");
		ps.println("<tbody>");
		
		ps.println();
		
		ps.println("<c:forEach items=\"${page.list}\" var=\"tag\" varStatus=\"id\">");
		ps.println("\t<tr class=\"tr_data\">");
		//ps.println("\t\t<td nowrap>");
		
		//ps.println("\t\t<td nowrap><input type=\"checkbox\" name=\"ids\" value=\"${tag.id}\"/></td>");
		//ps.println("\t\t<td nowrap><input type=\"checkbox\" name=\"ids\" value=\"${tag.id}\"/></td>");
		
		ps.println("<td nowrap>");
		ps.println("<c:if test=\"${tag.status =='0' || tag.status=='2'}\">");
		ps.println("<input type=\"checkbox\" name=\"ids\" value=\"${tag.id}\"/>");
		ps.println("</c:if>");
		ps.println("</td>");
		
		ps.println("<td nowrap>${id.count}</td>");
		
		int i = 0;
		for(String[] strs:list){
			String name= strs[0];
			//String type = strs[1];
			
			if(Lang.contains(Test.columnFilters, name.toUpperCase())){
				continue;
			}
			
			if(i ==1){
				if(Lang.contains(strs, "remark") || Lang.contains(strs, "REMARK")){
					ps.println("\t\t\t<td nowrap title=\"${tag.remark}\"><a href=\"<%=path %>/"+table+"/view?id=${tag.id}\">${tag."+name.toLowerCase()+"}</a></td>");
				}else{
					ps.println("\t\t\t<td nowrap title=\"${tag.remark}\"><a href=\"<%=path %>/"+table+"/view?id=${tag.id}\">${tag."+name.toLowerCase()+"}</a></td>");
				}
				
			}else{
				
				if("status".equals(name) || "STATUS".equals(name)){
					ps.println("\t\t\t\t<td nowrap>");
					ps.println("\t\t\t\t<c:if test=\"${tag.status =='0'}\">");
					ps.println("\t\t\t\t\t<span class=\"label\">${msg['status.default']}</span>");
					ps.println("\t\t\t\t</c:if>");
					ps.println("\t\t\t\t<c:if test=\"${tag.status =='1'}\">");
					ps.println("\t\t\t\t\t<span class=\"label label-success\">${msg['status.checked']}</span>");
					ps.println("\t\t\t\t</c:if>");
					ps.println("\t\t\t\t<c:if test=\"${tag.status =='2'}\">");
					ps.println("\t\t\t\t\t<span class=\"label label-important\">${msg['status.edited']}</span>");
					ps.println("\t\t\t\t</c:if>");
					ps.println("\t\t\t\t<c:if test=\"${tag.status =='-1'}\">");
					ps.println("\t\t\t\t\t<span class=\"label label-warning\">${msg['status.deleted']}</span>");
					ps.println("\t\t\t\t</c:if>");
					ps.println("\t\t\t\t</td>");
				}else{
					ps.println("\t\t\t<td nowrap>${tag."+name.toLowerCase()+"}</td>");
				}
						
			}
			
			//ps.println("\t\t\t${id."+name+"}");
			//ps.println("\t\t\t</td>");
			
			//<td nowrap><a href="<%=path %>/SmUser/view?id=${tag.id}">${tag.username}</a></td>
			i++;
		}
		
		ps.println("\t\t<td nowrap><a href=\"<%=path %>/"+table+"/view?id=${tag.id}\"/>${msg['label.OPERATION.VIEW']}</a>");		
		
		ps.println("<c:if test=\"${tag.status =='0' || tag.status=='2'}\">");
		ps.println("\t\t<span class=\"divider\">|</span>");
		ps.println("\t\t<a href=\"<%=path%>/"+table+"/edit?id=${tag.id}\" /><i class=\"icon-edit\"></i></a>");
		ps.println("</c:if>");
		
		ps.println("\t</td>");
		
		ps.println("\t</tr>");
		ps.println("</c:forEach>");	
		
		ps.println("<tr class=\"tr_data\">");
		ps.println("<td colspan=\""+(i+3)+"\" align=\"center\">");
		ps.println("<jsp:include page=\"/include/pagination.jsp\" flush=\"true\" />");
		ps.println("</td>");
		ps.println("</tr>");
		
		ps.println();
		
		ps.println("</tbody>");
		ps.println("</table>");
		
		ps.println("</form>");
		
		ps.println();
		
		ps.println("----------------------------this is data table list end------------------------------");
		ps.println();
	}
	
	/**
	 * 输出表字段的增加页面代码
	 * @param list
	 * @param table
	 */
	public void outDataAdd(List<String[]> list,String table){
		//List<String[]> list = Test.getTableColumns(table);
		//List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA);
		
		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		
		ps.println("----------------------------this is data "+table+" table add start------------------------------");
		ps.println();
		ps.println("<form action=\"<%=path %>/"+table+"/save?\" method=\"post\"  id=\"addForm\" name=\"addForm\" onsubmit=\"return valForm(this);\">");
		ps.println("<INPUT TYPE=\"hidden\" NAME=\""+table+".id\" value=\"${"+table+".id }\"/>");
		ps.println("<INPUT TYPE=\"hidden\" NAME=\"TOKEN\" value=\"${TOKEN }\"/>");
		ps.println("<table class=\"table table-bordered\">");
		
		int i = 0;
		int size = list.size();
		
		int isOdd = size%2;
		
		for(String[] strs:list){
			
			String name= strs[0].toLowerCase();
			String name2 = name.toUpperCase();
			
			String maxLength = strs[6];
			String dataType = strs[1];
			String nullable = strs[3];
			
			//boolean isNumber = false;
			String numberStr = null;
			if("int".equals(dataType)){
				//isNumber = true;
				numberStr = "onblur=\"valNumber(this)\"";
				//(isNumber?"onblur=\"valNumber(this)\"":"")
			}else{
				numberStr = "";
			}
			
			//boolean isNullable = false;
			String nullStr =  null;
			if("NO".equals(nullable)){
				//isNullable = true;
				nullStr = "valNullable=\"N\" valMsg=\"Input Something here,please\"";
				//(isNullable?"valNullable=\"Y\"":"")
			}else{
				nullStr = "";
			}
			
			//如果该字段为必填项，则标签后显示红色星号*
			String startStr = "";
			if(nullStr != null && nullStr.length() > 0){
				startStr = "<font color=\"red\">*</font></td>";
			}
			
			//String maxLenStr =  null;
			if(maxLength == null || "null".equals(maxLength)){
				maxLength = "";
			}else{
				maxLength = "maxLength=\""+maxLength+"\"";
			}
			
			
			if(Lang.contains(Test.columnFiltersAdd, name.toUpperCase())){
				continue;
			}
			
			int v = i%2;
			
			if(v==0){		
				
				/**
				 * 如果字段后缀为"date",该字段输入为日期组件选择方式  
				 */
				if(name.endsWith("date") || name.endsWith("Date")){
					ps.println("\t<tr>");
					ps.println("\t\t<td>${msg['label."+table+"."+name2+"']}"+startStr+"</td>");
					ps.println("\t\t<td>");
					
					ps.println("\t\t<div class=\"control-group\">");
					ps.println("\t\t\t<div class=\"controls input-append date form_date\" data-date=\"2013-10-06\" data-date-format=\"yyyy-mm-dd\" data-link-field=\"dtp_input1\">");
					ps.println("\t\t\t<input size=\"16\" type=\"text\"  NAME=\""+table+"."+name+"\" ID=\""+table+"."+name+"\" ");
					ps.println("\t\t\tvalue=\"${"+table+"."+name+"}\" readonly=\"readonly\">");
					ps.println("\t\t\t<span class=\"add-on\"><i class=\"icon-remove\"></i></span>");
					ps.println("\t\t\t<span class=\"add-on\"><i class=\"icon-th\"></i></span>");
					ps.println("\t\t\t</div>");
					ps.println("\t\t\t<input type=\"hidden\" id=\"dtp_input1\" value=\"\" />");
					ps.println("\t\t</div>");
					
					ps.println("\t\t</td>");
					
				}else{
					
					if("remark".equals(name) || "REMARK".equals(name)){
						ps.println("\t<tr>");
						ps.println("\t\t<td>${msg['label."+table+"."+name2+"']}"+startStr+"</td>");
						ps.println("\t\t<td  colspan=\"3\">");
						ps.println("\t\t<textarea rows=\"3\" cols=\"50\" NAME=\""+table+".remark\" ID=\""+table+".remark\" style=\"width:85%\">${"+table+".remark }</textarea>");
						ps.println("\t\t</td>");
					}else{
						ps.println("\t<tr>");
						ps.println("\t\t<td>${msg['label."+table+"."+name2+"']}"+startStr+"</td>");
						ps.println("\t\t<td><INPUT TYPE=\"TEXT\" NAME=\""+table+"."+name+"\" ID=\""+table+"."+name+"\" value=\"${"+table+"."+name+" }\" "+(maxLength)+"  "+(numberStr)+" "+(nullStr)+"/></td>");
					}
				}
			}else if (v==1){
				
				if(name.endsWith("date") || name.endsWith("Date")){
					ps.println("\t\t<td>${msg['label."+table+"."+name2+"']}"+startStr+"</td>");
					ps.println("\t\t<td>");
					
					//ps.println("\t\t\t\t<INPUT TYPE=\"TEXT\" NAME=\""+table+"."+name+"\" ID=\""+table+"."+name+"\" value=\"${"+table+"."+name+" }\"/>");
					ps.println("\t\t<div class=\"control-group\">");
					ps.println("\t\t\t<div class=\"controls input-append date form_date\" data-date=\"2013-10-06\" data-date-format=\"yyyy-mm-dd\" data-link-field=\"dtp_input1\">");
					ps.println("\t\t\t<input size=\"16\" type=\"text\"  NAME=\""+table+"."+name+"\" ID=\""+table+"."+name+"\" ");
					ps.println("\t\t\tvalue=\"${"+table+"."+name+"}\" readonly=\"readonly\">");
					ps.println("\t\t\t<span class=\"add-on\"><i class=\"icon-remove\"></i></span>");
					ps.println("\t\t\t<span class=\"add-on\"><i class=\"icon-th\"></i></span>");
					ps.println("\t\t\t</div>");
					ps.println("\t\t\t<input type=\"hidden\" id=\"dtp_input1\" value=\"\" />");
					ps.println("\t\t</div>");
					
					
					ps.println("\t\t</td>");
					ps.println("\t</tr>");
				}else{				
					if("remark".equals(name) || "REMARK".equals(name)){
						ps.println("\t</tr><tr>");
						ps.println("\t\t<td >${msg['label."+table+"."+name2+"']}"+startStr+"</td>");
						ps.println("\t\t<td colspan=\"3\">");
						ps.println("\t\t<textarea rows=\"3\" cols=\"50\" NAME=\""+table+".remark\" ID=\""+table+".remark\" style=\"width:85%\">${"+table+".remark }</textarea>");
						ps.println("\t\t</td>");
					}else{
						ps.println("\t\t<td>${msg['label."+table+"."+name2+"']}"+startStr+"</td>");
						ps.println("\t\t<td>");
						
						ps.println("\t\t\t\t<INPUT TYPE=\"TEXT\" NAME=\""+table+"."+name+"\" ID=\""+table+"."+name+"\" value=\"${"+table+"."+name+" }\"  "+(maxLength)+"  "+(numberStr)+" "+(nullStr)+"/>");
																
						ps.println("\t\t</td>");
						ps.println("\t</tr>");
					}
				}
				
				
			}

			i++;
		}
		
		ps.println("\t<tr>");
		//ps.println("\t<tr>");
		
		ps.println("\t\t<td colspan=\"4\" align=\"center\">");
		ps.println("\t\t\t<input type=\"submit\" name=\"btn_save\" class=\"btn btn-info\" value=\"${msg['operate.save']}\"> ");
		ps.println("\t\t\t<input type=\"reset\" name=\"btn_reset\" class=\"btn btn-info\" value=\"${msg['operate.reset']}\"> ");
		ps.println("\t\t\t<input	type=\"button\" name=\"btn_back\" class=\"btn btn-info\" value=\"${msg['operate.cancel']}\" onclick=\"window.location='<%=path %>/"+table+"/list?'\">");
		ps.println("\t\t</td>");
		ps.println("\t</tr>");
		
		ps.println("</table>");
		
		ps.println("</form>");
		ps.println();
		ps.println("----------------------------this is data "+table+" table add end------------------------------");
		ps.println();
	}
	
	/**
	 * 输出表字段的查看页面代码
	 * @param list
	 * @param table
	 */
	public void outDataView(List<String[]> list,String table){
		//List<String[]> list = Test.getTableColumns(table);
		//List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA);
		
		PrintStream ps = Test.getOut();
		
		table = Test.getClassNameByTable(table);
		
		ps.println("----------------------------this is data "+table+" table view start------------------------------");
		ps.println();
		ps.println("<form action=\"<%=path %>/"+table+"/list?\" method=\"post\"  id=\"viewForm\" name=\"viewForm\">");
		ps.println("<INPUT TYPE=\"hidden\" NAME=\""+table+".id\" value=\"${"+table+".id }\"/>");
		ps.println("<table class=\"table table-bordered\">");
		
		int i = 0;
		int size = list.size();
		
		int isOdd = size%2;
		
		for(String[] strs:list){
			
			String name= strs[0].toLowerCase();
			String name2 = name.toUpperCase();

			if( i == 0){
				ps.println("\t<tr>");
				ps.println("\t\t<td width=\"25%\">${msg['label."+table+"."+name2+"']}</td>");
				ps.println("\t\t<td colspan=\"3\"}>${"+table+"."+name+" }</td>");
				ps.println("\t</tr>");
			}else{
				ps.println("\t<tr>");
				ps.println("\t\t<td>${msg['label."+table+"."+name2+"']}</td>");
				ps.println("\t\t<td colspan=\"3\"}>${"+table+"."+name+" }</td>");
				ps.println("\t</tr>");
			}

			i++;
		}
		
		ps.println("\t<tr>");
		
		ps.println("\t\t<td colspan=\"4\" align=\"center\">");
		ps.println("\t\t\t<input type=\"submit\" name=\"btn_save\" class=\"btn btn-info\" value=\"${msg['operate.back']}\"> ");
		ps.println("\t\t</td>");
		ps.println("\t</tr>");
		
		ps.println("</table>");
		
		ps.println("</form>");
		ps.println();
		ps.println("----------------------------this is data "+table+" table view end------------------------------");
		ps.println();
	}
	
	public static void main(String args[]){
		/*String table = "tb_cost_type";
		JspUtil jsp = new JspUtil();
		jsp.outDataList(table);
		jsp.outDataAdd(table);*/
		
		String table ="t_sm_user";
		table ="tb_consult";
		List<String[]> list = Test.getTableColumnsAll(table, Test.SCHEMA,true);
		
		if(list == null || list.size()==0){
			System.out.println("list data is null");
			return;
		}
		
		JspUtil jsp = new JspUtil();
		jsp.outDataAdd(list, table);
		//jsp.outDataView(list, table);
		//jsp.outDataList(list, table);
	}

}
