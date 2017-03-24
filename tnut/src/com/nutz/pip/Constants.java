package com.nutz.pip;

public class Constants {
	public static final String KEY_LOGIN_USER = "USER";

	public static final String VALUE_ENCRYTP_METHOD = "MD5";
	
	public static final String PATH_UPLOAD_FILE = "/upload/files/";
	
	public static final String TYPE_SYSTEM_CONSTANTS = "SystemConstants";	
	public static final String TYPE_APPLICATION_CONSTANTS = "ApplicationConstants";
	public static final String TYPE_DEMO = "Demo";
	public static final String TYPE_Project_Constants = "ProjectConstants";
	
	public static final String KEY_REQUEST_POJO = "POJO";
	
	/**
	 * 操作符号
	 */
	public static final String OP_LIKE = "like";
	public static final String OP_EQUAL = "=";
	
	public static final String SIGN_PERCENT = "%";
	public static final String SIGN_DATE_DIVID = "-";
	
	/**
	 * sql排序字符
	 */
	public static final String SQL_ORDERBY_DESC = "desc";
	public static final String SQL_ORDERBY_ASC = "asc";
	
	public static final int INT_PAGE_CURRENTPAGE_DEFAULT = 1;
	public static final int INT_PAGE_PAGESIZE_DEFAULT = 10;
	public static final int INT_PAGE_PAGESIZE_SEARCH = 100;
	
	/**
	 * 资源文件的目录名称
	 */
	public static final String LANG_FOLDER = "msg";
	
	/**
	 * 数据源文件
	 */
	public static final String PATH_SYS_DATASOURCE_FILE = "/ioc/datasource.json";
	
	/**
	 * 数据字典类型
	 */
	public static final String DIC_VALUE_TYPE_RENT = "TYPE_RENT";
	public static final String DIC_VALUE_TYPE_UNIT = "COST_UNIT";
	
	/*
	 * 数据状态值
	 */
	public static final int VALUE_DEFAULT_STATUS = 0;//默认待审核
	public static final int VALUE_DEL_STATUS = -1;//软删除
	public static final int VALUE_CHECKED_STATUS = 1;//已审核
	public static final int VALUE_EDITED_STATUS = 2;//编辑过
	
	//重复提交关键字
	public static final String KEY_REPEAT_SUBMIT = "TOKEN";
	
	//系统动态BEAN或资源是否加载标示
	public static final String FLAG_SYS_BEANS_LOAD = "N";	
	public static final String FLAG_SYS_RES_LOAD = "N";
	
	public static final String VALUE_DEFAULT_TYPE = "0";//默认类型
	public static final String VALUE_DEFAULT_CREATE_BY = "-1";//默认类型
	
	public static final String PASSWORD_DEFAULT_VALUE = "111";//默认类型
	
}
