package com.qing.platform.controller;

import com.qing.core.utils.AjaxJsonResponse;
import com.qing.platform.entity.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/12/29.
 */
@Controller
@RequestMapping(value="document")
public class DocumentController {

    @RequestMapping(value="index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index.html");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value="mycode")
    public AjaxJsonResponse mycode(){
        Document document = new Document();
        document.setTitle("不知道啊");
        AjaxJsonResponse ajaxJsonResponse = new AjaxJsonResponse();
        try{
            System.out.println("hello");
            ajaxJsonResponse.setResCode(200);
            ajaxJsonResponse.setResMsg("你好啊");
            System.out.println("执行了赋值");
        }catch (Exception e){
            ajaxJsonResponse.setResCode(500);
            ajaxJsonResponse.setResMsg("你不好");
        }
        return ajaxJsonResponse;
    }
}
