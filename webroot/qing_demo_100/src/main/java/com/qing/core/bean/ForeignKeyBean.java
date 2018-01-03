package com.qing.core.bean;

import com.qing.core.utils.StringUtils;

/**
 * @description 外键信息模型
 *
 * @author 谢进伟
 *
 * @createDate 2016年2月15日 上午11:59:38
 */
public class ForeignKeyBean {
	
	/** 外键名称 **/
	private String foreignKeyName;
	/** 外键引用表表名 **/
	private String referenceTableName;
	/** 外键引用表外键列 **/
	private String referenceColumnName;
	/** 外键引用表引用列 **/
	private String foreignKeyColumnName;
	/** 外键引用表外键列注释 **/
	private String remarks;
	/** 外键引用表备注 **/
	private String referenceTableRemarks;
	
	/**
	 * @param foreignKeyName
	 *            外键名称
	 * @param referenceTableName
	 *            外键引用表表名
	 * @param referenceColumnName
	 *            外键引用表外键列
	 * @param foreignKeyColumnName
	 *            外键引用表引用列
	 * @param remarks
	 *            外键引用表外键列注释
	 */
	public ForeignKeyBean (String foreignKeyName , String referenceTableName , String referenceColumnName , String foreignKeyColumnName , String remarks ){
		super();
		this.foreignKeyName = foreignKeyName;
		this.referenceTableName = referenceTableName;
		this.referenceColumnName = referenceColumnName;
		this.foreignKeyColumnName = foreignKeyColumnName;
		this.remarks = remarks;
	}
	
	public String getForeignKeyName() {
		return foreignKeyName;
	}
	
	public void setForeignKeyName(String foreignKeyName) {
		this.foreignKeyName = foreignKeyName;
	}
	
	public String getReferenceTableName() {
		return referenceTableName;
	}
	
	public void setReferenceTableName(String referenceTableName) {
		this.referenceTableName = referenceTableName;
	}
	
	public String getReferenceColumnName() {
		return referenceColumnName;
	}
	
	public void setReferenceColumnName(String referenceColumnName) {
		this.referenceColumnName = referenceColumnName;
	}
	
	public String getForeignKeyColumnName() {
		return foreignKeyColumnName;
	}
	
	public void setForeignKeyColumnName(String foreignKeyColumnName) {
		this.foreignKeyColumnName = foreignKeyColumnName;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getStandardReferenceTableMappingName() {
		return StringUtils.converToJavaVariable(this.referenceTableName , false);
	}
	
	public String getReferenceTableRemarks() {
		return referenceTableRemarks;
	}
	
	public void setReferenceTableRemarks(String referenceTableRemarks) {
		this.referenceTableRemarks = referenceTableRemarks;
	}
	
	public String getStandardReferenceColumnNameMappingName() {
		String converToJavaVariable = StringUtils.converToJavaVariable(this.referenceColumnName , true);
		if(converToJavaVariable.endsWith("Id")) {
			if(converToJavaVariable.equals("pId")) {
				return "parent";
			} else {
				return StringUtils.substringBeforeLast(converToJavaVariable , "Id");
			}
		} else {
			return converToJavaVariable + "Entity";
		}
	}
}