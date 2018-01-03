package com.qing.core.bean;


/**
 * @description 数据库表基础属性模型
 * 
 * @author 谢进伟
 * 
 * @createDate 2016-1-31 下午9:52:10
 */
public class TableBean {
	
	/** 所属方案 **/
	private String schema;
	private String cata;
	/** 表名 **/
	private String name;
	/** 所在数据库名称 **/
	private String catalog;
	/** 表备注 **/
	private String remarks;
	
	public TableBean (){
		super();
	}
	
	public TableBean (String schema , String cata , String name , String catalog , String remarks ){
		super();
		this.schema = schema;
		this.cata = cata;
		this.name = name;
		this.catalog = catalog;
		this.remarks = remarks;
	}
	
	/**
	 * @return the schema
	 */
	public String getSchema() {
		return schema;
	}
	
	/**
	 * @param schema
	 *            the schema to set
	 */
	public void setSchema(String schema) {
		this.schema = schema;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the catalog
	 */
	public String getCatalog() {
		return catalog;
	}
	
	/**
	 * @param catalog
	 *            the catalog to set
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	
	/**
	 * @return the cata
	 */
	public String getCata() {
		return cata;
	}
	
	/**
	 * @param cata
	 *            the cata to set
	 */
	public void setCata(String cata) {
		this.cata = cata;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
