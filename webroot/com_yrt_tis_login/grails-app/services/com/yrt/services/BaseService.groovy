package com.yrt.services

import com.yrt.entity.AdminUser
import com.yrt.utils.Const
import com.yrt.utils.SHA1Util
import com.yrt.utils.redisClient
import grails.gorm.transactions.Transactional
import org.springframework.web.context.request.RequestContextHolder

import javax.servlet.http.HttpSession

@Transactional
class BaseService {

    def encryptPassword(AdminUser entity){
        StringBuffer encryptStr = new StringBuffer();
        // 加密组合：用户id、明文密码、创建时间
        return SHA1Util.sha1(encryptStr.append(entity.getId()).append(entity.getUserPassword()).append(entity.getCreateTime()).toString());
    }

    /**
     * 缓存登录对象信息
     *
     * @param loginUser
     * 登录用户对象
     *
     */
    def cacheLoginUsr(AdminUser loginUser, HttpSession session) {
        if(loginUser != null) {
            println("开始试图设置session")
            session.setAttribute(Const.SESSION_LOGINUSER_OBJ, loginUser)
            session.setAttribute(Const.SESSION_LOGINUSER_OBJ_ID, loginUser.getId())
            println("设置成功")
        }
    }
}
