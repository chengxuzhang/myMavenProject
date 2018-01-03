package com.qing.core.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 实体类模板扩展参数
 * 
 * @author 谢进伟
 * 
 * @createDate 2016年4月16日 下午7:27:39
 */
public class EntityTemplateExtensionBean {
	
	/** 数据库表名 **/
	private String tableName;
	/** 实体类唯一序列 **/
	private String serialVersionUID;
	/** 实体类属性集合 **/
	private List<TableColumnBean> columns;
	/** 外键 **/
	private List<ForeignKeyBean> foreignKeys = new ArrayList<ForeignKeyBean>();
	
	public EntityTemplateExtensionBean (String tableName , List<TableColumnBean> columns , List<ForeignKeyBean> foreignKeys ){
		super();
		this.tableName = tableName;
		this.columns = columns;
		this.foreignKeys.addAll(foreignKeys);
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getSerialVersionUID() {
		this.serialVersionUID = System.nanoTime() + "L";
		return serialVersionUID;
	}
	
	public List<TableColumnBean> getColumns() {
		return columns;
	}
	
	public void setColumns(List<TableColumnBean> columns) {
		this.columns = columns;
	}
	
	public List<ForeignKeyBean> getForeignKeys() {
		return foreignKeys;
	}
	
	public void setForeignKeys(List<ForeignKeyBean> foreignKeys) {
		this.foreignKeys.addAll(foreignKeys);
	}
}
