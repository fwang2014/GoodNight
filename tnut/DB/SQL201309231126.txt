/*
Created		2013/9/23
Modified		2013/9/23
Project		
Model		
Company		
Author		
Version		
Database		mySQL 5 
*/

















drop table IF EXISTS TB_CLASSROOM;
drop table IF EXISTS TB_CLASS;
drop table IF EXISTS TB_REGISTER;
drop table IF EXISTS TB_CONSULT;
drop table IF EXISTS TB_CUSTOMER;
drop table IF EXISTS TB_PROJECT;
drop table IF EXISTS TB_DIC_VALUE;
drop table IF EXISTS TB_DIC_TYPE;
drop table IF EXISTS TB_USER_ROLE;
drop table IF EXISTS TB_ROLE_MENU;
drop table IF EXISTS TB_LOG;
drop table IF EXISTS TB_MENU;
drop table IF EXISTS TB_ROLE;
drop table IF EXISTS TB_USER;




Create table TB_USER (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '用户编码',
	NAME Varchar(50) COMMENT '用户名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	ACCOUNT_NAME Varchar(50) COMMENT '账户名',
	PASSWORD Varchar(50) COMMENT '密码',
	DEFAULT_ROLE Int COMMENT '默认角色ID',
	NICK_NAME Varchar(50) COMMENT '显示名称',
	LAST_LOGIN_TIME Datetime COMMENT '上次登录时间',
	LOGIN_TIME Datetime COMMENT '本次登录时间',
	LOGIN_TIMES Int COMMENT '登录次数',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '用户表';

Create table TB_ROLE (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '角色编码',
	NAME Varchar(50) COMMENT '角色名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '用户表';

Create table TB_MENU (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '菜单编码',
	NAME Varchar(50) COMMENT '菜单名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	PARENT_ID Int COMMENT '父ID',
	URL Varchar(200) COMMENT '请求地址',
	MENU_ICON Varchar(200) COMMENT '菜单图标',
	IS_ROOT Int DEFAULT 0 COMMENT '是否根层菜单',
	ORDER_INDEX Int COMMENT '显示序号',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '用户表';

Create table TB_LOG (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '日志编码',
	NAME Varchar(50) COMMENT '日志内容',
	TYPE Varchar(20) DEFAULT 0 COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	REQ_IP Varchar(20) COMMENT '请求IP地址',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '系统日志表';

Create table TB_ROLE_MENU (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '角色编码',
	NAME Varchar(50) COMMENT '角色名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	ROLE_ID Int COMMENT '角色ID',
	MENU_ID Int COMMENT '菜单ID',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '角色菜单权限表';

Create table TB_USER_ROLE (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '角色编码',
	NAME Varchar(50) COMMENT '角色名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	USER_ID Int COMMENT '用户ID',
	ROLE_ID Int COMMENT '角色ID',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '用户角色权限表';

Create table TB_DIC_TYPE (
	ID Int NOT NULL,
	CODE Varchar(20) NOT NULL COMMENT '类型编码',
	NAME Varchar(50) NOT NULL COMMENT '类型名称',
	TYPE Varchar(20) DEFAULT 0 COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
	UNIQUE (CODE),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '数据字典类型表';

Create table TB_DIC_VALUE (
	ID Int NOT NULL,
	CODE Varchar(20) NOT NULL COMMENT '值编码',
	NAME Varchar(50) NOT NULL COMMENT '值名称',
	TYPE Varchar(20) DEFAULT 0 COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	TYPE_CODE Char(20) COMMENT '数据字典类型编码',
	UNIQUE (ID),
	UNIQUE (CODE),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '数据字段值表';

Create table TB_PROJECT (
	ID Int NOT NULL,
	CODE Varchar(20) NOT NULL COMMENT '项目编码',
	NAME Varchar(50) NOT NULL COMMENT '项目名称',
	TYPE Varchar(20) DEFAULT 0 COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
	UNIQUE (CODE),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '项目表';

Create table TB_CUSTOMER (
	ID Int NOT NULL,
	CODE Varchar(20) NOT NULL COMMENT '客户编码',
	NAME Varchar(50) NOT NULL COMMENT '客户名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
	UNIQUE (CODE),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '客户表';

Create table TB_CONSULT (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '咨询编码',
	NAME Varchar(50) COMMENT '咨询名称',
	TYPE Varchar(20) DEFAULT 0 COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '客户咨询表';

Create table TB_REGISTER (
	ID Int NOT NULL,
	CODE Varchar(20) NOT NULL COMMENT '注册编码',
	NAME Varchar(50) COMMENT '注册名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
	UNIQUE (CODE),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '客户登记注册表';

Create table TB_CLASS (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '班级编码',
	NAME Varchar(50) COMMENT '班级名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '班级表';

Create table TB_CLASSROOM (
	ID Int NOT NULL,
	CODE Varchar(20) COMMENT '课堂编码',
	NAME Varchar(50) COMMENT '课堂名称',
	TYPE Varchar(20) COMMENT '类型',
	STATUS Int DEFAULT 0 COMMENT '状态',
	CREATE_DATE Date COMMENT '创建日期',
	CREATE_BY Varchar(20) COMMENT '创建人',
	UPDATE_TIME Datetime COMMENT '更新时间',
	UPDATE_BY Varchar(20) COMMENT '更新人',
	REMARK Varchar(500) COMMENT '备注',
	UNIQUE (ID),
 Primary Key (ID)) ENGINE = MyISAM
COMMENT = '课堂表';



























/* Users permissions */






