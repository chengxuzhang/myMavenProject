package com.qing.core.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 分页模型
 * 
 * @author 谢进伟
 * 
 * @createDate 2016-1-31 下午2:55:49
 */
public class PageBean {
	
	/** 当前页码 **/
	private int pageNo = 1;
	/** 上一页页码 **/
	private int prevPageNo;
	/** 下一页页码 **/
	private int nextPageNo;
	/** 是否是第一页 **/
	private boolean isFirstPageNo;
	/** 是否是最后一页 **/
	private boolean isLastPageNo;
	/** 每一页显示的记录数 **/
	private int pageSize = 10;
	/** 总记录数 **/
	private int sumCount;
	/** 总页码数 **/
	private int totalPage;
	/** 数据集 **/
	private List<?> list;
	/** 除列表数据以外的数据容器 **/
	private Map<String , Object> extendData;
	
	public PageBean (){
		super();
	}
	
	/**
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每一页显示的记录数
	 * @param sumCount
	 *            总记录数
	 * @param list
	 *            数据集
	 */
	public PageBean (int pageNo , int pageSize , int sumCount , List<?> list ){
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.sumCount = sumCount;
		this.list = list;
		this.setTotalPage((int)Math.ceil((sumCount * 1D) / pageSize));
	}
	
	/**
	 * @return 获取当前页
	 */
	public int getPageNo() {
		return pageNo;
	}
	
	/**
	 * 设置当前页
	 * 
	 * @param currentpage
	 *            页码
	 */
	public void setPageNo(int currentpage) {
		this.pageNo = currentpage;
	}
	
	/**
	 * 获取记录总数
	 * 
	 * @return
	 */
	public int getSumCount() {
		return sumCount;
	}
	
	/**
	 * 设置总记录数
	 * 
	 * @param results
	 *            总记录数
	 */
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
	
	/**
	 * 获取每一页显示的记录数
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置每一页显示的记录数
	 * 
	 * @param pageSize
	 *            每一页显示的记录数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 获取总页码
	 * 
	 * @return
	 */
	public int getTotalPage() {
		if(this.totalPage == 0) {
			this.setTotalPage((int)Math.ceil((sumCount * 1D) / pageSize));
		}
		return totalPage;
	}
	
	/**
	 * 设置总页码数
	 * 
	 * @param totalPage
	 *            总页码数
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * 获取数据集
	 * 
	 * @return
	 */
	public <E> List<?> getList() {
		if(this.list == null) {
			this.setList(new ArrayList<E>());
		}
		return list;
	}
	
	/**
	 * 设置数据集
	 * 
	 * @param list
	 *            数据集
	 */
	public void setList(List<?> list) {
		this.list = list;
	}
	
	/**
	 * 上一页
	 * 
	 * @return
	 */
	public int getPrevPageNo() {
		this.prevPageNo = (pageNo - 1 < 1) ? 1 : pageNo - 1;
		return this.prevPageNo;
	}
	
	/**
	 * 下一页
	 * 
	 * @return
	 */
	public int getNextPageNo() {
		this.nextPageNo = (pageNo + 1 > totalPage) ? totalPage : pageNo + 1;
		return this.nextPageNo;
	}
	
	/**
	 * 是否是第一页
	 * 
	 * @return
	 */
	public boolean isFirstPageNo() {
		this.isFirstPageNo = (pageNo == 1) ? true : false;
		return this.isFirstPageNo;
	}
	
	/**
	 * 是否是最后一页
	 * 
	 * @return
	 */
	public boolean isLastPageNo() {
		this.isLastPageNo = (pageNo == totalPage) ? true : false;
		return this.isLastPageNo;
	}
	
	/**
	 * @return 获取 列表额外 值
	 */
	public Map<String , Object> getExtendData() {
		return extendData;
	}
	
	/**
	 * @param 设置参数
	 *            列表额外的值为otherData
	 */
	public void setExtendData(Map<String , Object> extendData) {
		initExtendDataMap();
		this.extendData.putAll(extendData);
	}
	
	/**
	 * 添加扩展数据
	 * 
	 * @param key
	 *            参数Key
	 * @param value
	 *            参数值
	 */
	public void addExtendData(String key , Object value) {
		initExtendDataMap();
		this.extendData.put(key , value);
	}
	
	/**
	 * 获取扩展参数
	 * 
	 * @param key
	 *            参数Key
	 * @return
	 */
	public Object getExtendData(String key) {
		initExtendDataMap();
		return this.extendData.get(key);
	}
	
	/**
	 * 初始化扩展参数容器
	 */
	private void initExtendDataMap() {
		if(this.extendData == null) {
			this.extendData = new HashMap<String , Object>();
		}
	}
	
	public String getPagingBar(String searchForm) {
		StringBuffer pagingBar = new StringBuffer();
		int beginPageNo = 0;
		int endPageNo = 0;
		int totalPage = this.getTotalPage();
		int pageNo = this.getPageNo();
		int pageSize = this.getPageSize();
		int currentpage = pageNo;
		if(totalPage <= 5 || (totalPage > 5 && currentpage <= totalPage - 4)) {
			if(totalPage <= 5) {
				beginPageNo = 1;
				endPageNo = totalPage;
			} else {
				if(currentpage > 1) {
					beginPageNo = currentpage - 1;
					endPageNo = beginPageNo + 4;
				} else {
					beginPageNo = 1;
					endPageNo = 5;
				}
			}
		} else {
			beginPageNo = totalPage - 4;
			endPageNo = totalPage;
		}
		pagingBar.append("<div class=\"pagingBar\" targetform=\""+searchForm+"\">");
		pagingBar.append("<span class=\"pagingininfo\">共"+sumCount+"条记录 第 <span><input type=\"number\" name=\"targetPageNo\" value=\"" + currentpage + "\"> /" + totalPage + " 页 显示记录数：<input type=\"number\" name=\"targetPageSize\" value=\"" +( pageSize > sumCount ? sumCount : pageSize) + "\">行 <a class='btn btn-xs searchBtn' onclick=\"jump(this,'" + searchForm + "'," + pageSize + "," + currentpage + "," + totalPage + "," + sumCount + ")\"><i class='fa  fa-mail-forward'></i>跳转</a><span class=\"loadingImg\"><img src=\"assets/img/loading_little.jpg\"/></span></span></span>");
		pagingBar.append("<ul class=\"pagination\">");
		if(currentpage > 1) {
			pagingBar.append("<li title='首页'><a href=\"javascript:goPage('" + searchForm + "',1," + pageSize + ")\"><i class=\"fa  fa-step-backward\"></i></a></li>");
			pagingBar.append("<li title='上一页'><a href=\"javascript:goPage('" + searchForm + "'," + (pageNo - 1) + "," + pageSize + ")\"><i class=\"fa fa-backward\"></i></a></li>");
		} else {
			pagingBar.append("<li title='首页' class=\"disabled\"><a href=\"javascript:\"><i class=\"fa fa-step-backward\"></i></a></li>");
			pagingBar.append("<li title='上一页' class=\"disabled\"><a href=\"javascript:\"><i class=\"fa fa-backward\"></i></a></li>");
		}
		for(int i = beginPageNo ; i <= endPageNo ; i++) {
			if(pageNo == i) {
				pagingBar.append("<li title='第" + i + "页' class=\"active\"><a href=\"javascript:void(0)\">" + i + " <span class=\"sr-only\">(current)</span></a></li>");
			} else {
				pagingBar.append("<li title='第" + i + "页'><a href=\"javascript:goPage('" + searchForm + "'," + i + "," + pageSize + ")\">" + i + "</a></li>");
			}
		}
		if(pageNo < totalPage) {
			pagingBar.append("<li title='下一页'><a href=\"javascript:goPage('" + searchForm + "'," + (pageNo + 1) + "," + pageSize + ")\"><i class=\"fa fa-forward\"></i></a></li>");
			pagingBar.append("<li title='最后一页'><a href=\"javascript:goPage('" + searchForm + "'," + totalPage + "," + pageSize + ")\"><i class=\"fa fa-step-forward\"></i></a></li>");
		} else {
			pagingBar.append("<li title='下一页' class=\"disabled\"><a href=\"javascript:\"><i class=\"fa fa-forward\"></i></a></li>");
			pagingBar.append("<li title='最后一页' class=\"disabled\"><a href=\"javascript:\"><i class=\"fa fa-step-forward\"></i></a></li>");
		}
		pagingBar.append("</ul>");
		pagingBar.append("</div>");
		return pagingBar.toString();
	}
}
