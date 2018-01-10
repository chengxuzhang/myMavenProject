package com.yrt.controllers

import com.yrt.entity.AdminUser
import com.yrt.services.LoginService
import com.yrt.utils.Const
import grails.rest.*
import grails.converters.*
import com.yrt.utils.JsonResponse

import javax.servlet.http.HttpServletRequest
//import org.codehaus.groovy.grails.web.util.WebUtils
import org.springframework.web.context.request.RequestContextHolder

import javax.servlet.http.HttpSession


class LoginController {
	static responseFormats = ['json', 'xml']
    LoginService loginService

    def index() { }

    def login(){

        JsonResponse jsonResp = new JsonResponse()
        try {
            println(RequestContextHolder.currentRequestAttributes().getSessionId())
            jsonResp.data = loginService.login(params, jsonResp, session)
            jsonResp.resCode = Const.CODE_STATUS_SUCCESS
            jsonResp.resMsg = "欢迎登录！"
        }catch (Exception e){
            jsonResp.resCode = Const.CODE_STATUS_ERROR
            jsonResp.resMsg = Const.codeMsg[Const.CODE_STATUS_ERROR]
        }
        render(jsonResp as JSON)
    }

}
