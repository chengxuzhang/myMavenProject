package com.qing.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.qing.core.exception.AjaxResponseException;

/**
 * @description Ajax请求响应
 *
 * @author 谢进伟
 *
 * @createDate 2016-1-29 上午9:44:48
 */
public class AjaxJsonResponse {

    /** 响应文本信息 **/
    protected String resMsg = "请求成功";
    /** 响应码 -1 其他错误,200成功，300 参数错误，500 服务器端异常，默认为成功状态码200 **/
    protected int resCode = 200;
    /** 响应的业务数据 **/
    protected Object data;
    /** 业务数据分页模式下的当前页码 **/
    protected Integer pageNo;
    /** 业务数据分页模式下每页显示的记录数 **/
    protected Integer pageSize;
    /** 扩展参数 **/
    protected Map<String , Object> extendParams;
    /** 是否为分页模式 **/
    @JsonIgnore
    protected boolean isPaging;
    /** 数据处理器 **/
    protected static ObjectMapper mapper = new ObjectMapper();

    public AjaxJsonResponse (){
        super();
        mapper.clearProblemHandlers();
    }

    /**
     * @param resMsg
     *            响应文本信息
     */
    public AjaxJsonResponse (String resMsg ){
        this();
        this.resMsg = resMsg;
    }

    /**
     * @param resMsg
     *            响应文本信息
     * @param resCode
     *            响应码
     */
    public AjaxJsonResponse (String resMsg , int resCode ){
        this(resMsg);
        this.resCode = resCode;
    }

    /**
     * @param data
     *            响应的业务数据 <span
     *            style="color:red">该参数只接受以下类型数据结构：<br>
     *            List&lt;T&gt;、
     *            List&lt;Map&lt;String,
     *            Object&gt;&gt;、Map&lt;String,Object&gt;</span>
     */
    public AjaxJsonResponse (Object data ){
        this.data = data;
        checkDataType();
    }

    /**
     * @param resMsg
     *            响应文本信息
     * @param resCode
     *            响应码
     * @param data
     *            响应的业务数据 <span
     *            style="color:red">该参数只接受以下类型数据结构：<br>
     *            List&lt;T&gt;、
     *            List&lt;Map&lt;String,
     *            Object&gt;&gt;、Map&lt;String,Object&gt;</span>
     */
    public AjaxJsonResponse (String resMsg , int resCode , Object data ){
        this(resMsg , resCode);
        this.data = data;
        checkDataType();
    }

    /**
     * @param resMsg
     *            响应文本信息
     * @param resCode
     *            响应码
     * @param data
     *            响应的业务数据 <span
     *            style="color:red">该参数只接受以下类型数据结构：<br>
     *            List&lt;T&gt;、
     *            List&lt;Map&lt;String,
     *            Object&gt;&gt;、Map&lt;String,Object&gt;</span>
     * @param pageNo
     *            业务数据分页模式下的当前页码
     * @param pageSize
     *            业务数据分页模式下每页显示的记录数
     */
    public AjaxJsonResponse (String resMsg , int resCode , Object data , Integer pageNo , Integer pageSize ){
        this(resMsg , resCode , data);
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * @param resMsg
     *            响应文本信息
     * @param resCode
     *            响应码
     * @param data
     *            响应的业务数据 <span
     *            style="color:red">该参数只接受以下类型数据结构：<br>
     *            List&lt;T&gt;、
     *            List&lt;Map&lt;String,
     *            Object&gt;&gt;、Map&lt;String,Object&gt;</span>
     * @param pageNo
     *            业务数据分页模式下的当前页码
     * @param pageSize
     *            业务数据分页模式下每页显示的记录数
     * @param isPaging
     *            是否分页
     */
    public AjaxJsonResponse (String resMsg , int resCode , Object data , Integer pageNo , Integer pageSize , boolean isPaging ){
        this(resMsg , resCode , data , pageNo , pageSize);
        this.isPaging = isPaging;
    }

    /**
     * @param resMsg
     *            响应文本信息
     * @param resCode
     *            响应码
     * @param data
     *            响应的业务数据 <span
     *            style="color:red">该参数只接受以下类型数据结构：<br>
     *            List&lt;T&gt;、
     *            List&lt;Map&lt;String,
     *            Object&gt;&gt;、Map&lt;String,Object&gt;</span>
     * @param pageNo
     *            业务数据分页模式下的当前页码
     * @param pageSize
     *            业务数据分页模式下每页显示的记录数
     * @param extendParams
     *            扩展参数
     */
    public AjaxJsonResponse (String resMsg , int resCode , Object data , Integer pageNo , Integer pageSize , Map<String , Object> extendParams ){
        this(resMsg , resCode , data , pageNo , pageSize);
        this.extendParams = extendParams;
    }

    /**
     * @param resMsg
     *            响应文本信息
     * @param resCode
     *            响应码
     * @param data
     *            响应的业务数据 <span
     *            style="color:red">该参数只接受以下类型数据结构：<br>
     *            List&lt;T&gt;、
     *            List&lt;Map&lt;String,
     *            Object&gt;&gt;、Map&lt;String,Object&gt;</span>
     * @param pageNo
     *            业务数据分页模式下的当前页码
     * @param pageSize
     *            业务数据分页模式下每页显示的记录数
     * @param extendParams
     *            扩展参数
     * @param isPaging
     *            是否分页
     */
    public AjaxJsonResponse (String resMsg , int resCode , Object data , Integer pageNo , Integer pageSize , Map<String , Object> extendParams , boolean isPaging ){
        this(resMsg , resCode , data , pageNo , pageSize , isPaging);
        this.extendParams = extendParams;
    }

    /**
     * 批量添加额外参数
     *
     * @param extendParams
     *            参数
     */
    public void addExtendParam(Map<String , Object> extendParams) {
        if(this.extendParams == null) {
            this.extendParams = new HashMap<String , Object>();
        }
        this.extendParams.putAll(extendParams);
    }

    /**
     * 添加额外参数
     *
     * @param key
     *            参数Key
     * @param value
     *            参数值
     */
    public void addExtendParam(String key , String value) {
        if(this.extendParams == null) {
            this.extendParams = new HashMap<String , Object>();
        }
        this.extendParams.put(key , value);
    }

    /**
     * 响应ajax请求
     *
     * @param isIncludeData
     *            是否包含业务数据
     * @return
     */
    public String jsonResponse(boolean isIncludeData) {
        checkPagingParam();
        String resultJsonStr = "{resMsg:\"服务器端异常\",resCode:500}";// 默认响应json串
        try {
            Set<String> properties = new HashSet<String>();
            properties.add("resMsg");
            properties.add("resCode");
            if(isIncludeData) {
                properties.add("data");
            }
            if(this.extendParams != null && this.extendParams.size() > 0) {
                properties.add("extendParams");
            }
            if(this.isPaging) {// 分页模式
                properties.add("pageNo");
                properties.add("pageSize");
            }
            mapper.setFilterProvider(new SimpleFilterProvider().addFilter("ajaxResponseFileter" , SimpleBeanPropertyFilter.filterOutAllExcept(properties)));
            mapper.addMixIn(this.getClass() , AjaxResponseFilterMixIn.class);
            resultJsonStr = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultJsonStr;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPaging() {
        return isPaging;
    }

    public void setPaging(boolean isPaging) {
        this.isPaging = isPaging;
    }

    public Map<String , Object> getExtendParams() {
        return extendParams;
    }

    /**
     * 分页模式下检查页码和每页显示的记录数
     */
    protected void checkPagingParam() {
        if(this.isPaging) {
            if(this.pageNo == null) {
                this.pageNo = 1;
                if(data instanceof List) {
                    List<?> list = (List<?>)data;
                    this.pageSize = list.size();
                }
                if(data instanceof Map) {
                    this.pageSize = ((Map<? , ?>)data).size();
                }
            }
        }
    }

    /**
     * 检查data参数类型
     *
     * @return
     */
    protected boolean checkDataType() {
        if(this.data == null) {
            this.data = new ArrayList<Object>();
            return true;
        }
        boolean type = (this.data instanceof List) || (this.data instanceof Map);
        if(!type) {
            try {
                this.data = new ArrayList<Object>();
                throw new AjaxResponseException("业务员数据参数[data]类型错误!");
            } catch (AjaxResponseException e) {
                e.printStackTrace();
            }
        }
        return type;
    }

    /**
     * @description 响应过滤器
     *
     * @author 谢进伟
     *
     * @createDate 2016-1-29 下午2:58:45
     */
    @JsonFilter(value = "ajaxResponseFileter")
    private static interface AjaxResponseFilterMixIn {
        // 此处不指定任何过滤字段，在使用时动态指定
    }
}
