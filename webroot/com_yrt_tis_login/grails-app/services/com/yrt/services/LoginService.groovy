package com.yrt.services

import com.yrt.entity.AdminUser
import com.yrt.utils.Const
import com.yrt.utils.JsonResponse
import grails.gorm.transactions.Transactional
import org.apache.commons.lang.StringUtils
import org.hibernate.criterion.DetachedCriteria
import org.hibernate.criterion.Restrictions
import org.springframework.web.context.request.RequestContextHolder

@Transactional
class LoginService extends BaseService{

    AdminUserService adminUserService

    def login(params, jsonResp, session) throws Exception{
        String loginName = params["userName"]
        String password = params["password"]
        if(StringUtils.isBlank(loginName)) {
            jsonResp.setResCode(Const.CODE_STATUS_ERROR_X)
            jsonResp.setResMsg("请输入登录名!")
            return null
        } else if(StringUtils.isBlank(password)) {
            jsonResp.setResCode(Const.CODE_STATUS_ERROR_X)
            jsonResp.setResMsg("请输入登录密码!")
            return null
        } else {
            def users = AdminUser.findAllByUserName(loginName)
            if(users != null && !users.isEmpty()) {
                AdminUser loginUser = users.get(0)
                loginUser.getHeadPortrait()
                if(loginUser.getIsForbidden()) {
                    jsonResp.setResCode(Const.CODE_STATUS_RIBBON)
                    jsonResp.setResMsg("您已被禁用,请联系管理员!")
                    return null
                } else {
                    AdminUser tempUser = new AdminUser()
                    String loginUserId = loginUser.getId()
                    tempUser.setId(loginUserId)
                    tempUser.setCreateTime(loginUser.getCreateTime())
                    tempUser.setUserPassword(password)
                    String encryptPassword = encryptPassword(tempUser)
                    if(!loginUser.getUserPassword().equals(encryptPassword)) {
                        jsonResp.setResCode(Const.CODE_STATUS_ERROR_X)
                        jsonResp.setResMsg("登录密码错误!")
                        return null
                    } else {// 登录成功
                        // 修改用户状态为在线状态
                        this.adminUserService.onLine(loginUser,RequestContextHolder.currentRequestAttributes().getSessionId())
                        // 缓存登录对象信息
                        super.cacheLoginUsr(loginUser,session)
                        return null
                    }
                }
            } else {
                jsonResp.setResCode(Const.CODE_STATUS_ERROR_X)
                jsonResp.setResMsg("用户名或密码错误!")
                return null
            }
        }
    }
}
