package com.qing.core.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description freemarker 基本参数模型
 * 
 * @author 谢进伟
 * 
 * @createDate 2016-1-31 下午5:51:18
 */
public class BaseTemplateBean {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ah:mm:ss");
	
	/** 模块名称 **/
	protected String modulesName;
	/** 实体名称 **/
	protected String entityName;
	/** 业务描述名称 **/
	protected String businessDescription;
	/** 作者名称 **/
	protected String author;
	/** 当前时间 **/
	protected String nowDate;
	
	public BaseTemplateBean (String modulesName , String entityName , String businessDescription , String author ){
		super();
		this.modulesName = modulesName;
		this.entityName = entityName;
		this.businessDescription = businessDescription;
		this.author = author;
		this.nowDate = sdf.format(new Date());
	}
	
	public SimpleDateFormat getSdf() {
		return sdf;
	}
	
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	
	public String getModulesName() {
		return modulesName;
	}
	
	public void setModulesName(String modulesName) {
		this.modulesName = modulesName;
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public String getBusinessDescription() {
		return businessDescription;
	}
	
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getNowDate() {
		return nowDate;
	}
	
	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}
	
}
