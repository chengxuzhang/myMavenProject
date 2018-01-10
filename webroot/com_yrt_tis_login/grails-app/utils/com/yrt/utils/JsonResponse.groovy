package com.yrt.utils

import com.fasterxml.jackson.databind.ObjectMapper
import java.text.SimpleDateFormat

/**
 * Created by srun(LuoXS) on 2017/10/20.
 */
class JsonResponse {
    /** 响应文本信息 **/
    protected String resMsg = "请求成功"
    /** 响应码 -1 其他错误,200成功，300 参数错误，301 对象保存失败，500 服务器端异常，默认为成功状态码200 **/
    protected int resCode = 200
    /** 响应的业务数据 **/
    protected Object data
    /** 数据处理器 **/
    protected static ObjectMapper mapper = new ObjectMapper()


    JsonResponse(){
        super()
        mapper.clearProblemHandlers()
    }

    JsonResponse(Object data){
        super()
        this.data = data
        mapper.clearProblemHandlers()
    }

    JsonResponse(int code, String msg){
        super()
        this.resCode = code
        this.resMsg = msg
        mapper.clearProblemHandlers()
    }

    String getResMsg() {
        return resMsg
    }

    void setResMsg(String resMsg) {
        this.resMsg = resMsg
    }

    int getResCode() {
        return resCode
    }

    void setResCode(int resCode) {
        this.resCode = resCode
    }

    Object getData() {
        return data
    }

    void setData(Object data) {
        this.data = data
    }

    String toJSONStr(){
        String resultJsonStr = "{resMsg:\"服务器端异常\",resCode:500}"// 默认响应json串
        try{
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))// 设置日期类型格式化形式
            resultJsonStr = mapper.writeValueAsString(this)
        }catch(Exception e){
            e.printStackTrace()
        }
        return resultJsonStr
    }
}
