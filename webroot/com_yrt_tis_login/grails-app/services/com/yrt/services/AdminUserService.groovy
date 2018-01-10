package com.yrt.services

import com.yrt.entity.AdminUser
import grails.gorm.transactions.Transactional
import groovy.sql.Sql
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

@Transactional
class AdminUserService extends BaseService{
    Sql sqlEX

    /** 在线用户操作权限分配缓存 **/
    Cache onlineUserPermissionAllotEhcache;

    def serviceMethod() {

    }

    def onLine(AdminUser entity, String sessionId) {
        cacheUserPermissionAllot(entity);
        // 修改用户为在线状态
        entity.setIsOnline(1);
        entity.setOnlineSessionId(sessionId);
        entity.save(flush:true)
    }

    /**
     * 缓存权限分配信息
     *
     * @param entity
     *            登录用户对象
     */
    def cacheUserPermissionAllot(AdminUser entity) {
        if(onlineUserPermissionAllotEhcache == null) {
            return;
        }
        String loginUserId = entity.getId();
        String sql = "SELECT hp.*, mp.name menuName, mp.handlePermissionIdentifier FROM sys_handle_permissions hp" +
                " JOIN sys_menu_permissions mp on hp.menuId = mp.id and mp.isDelete = 0 and mp.isForbidden = 0" +
                " WHERE hp.isDelete = 0 AND hp.isForbidden = 0" +
                " AND hp.id IN (SELECT handleId FROM sys_user_role_privilege WHERE handleId IS NOT NULL" +
                " AND ( userId = '${loginUserId}' OR roleId IN ( SELECT t.roleId FROM sys_admin_user_join_sys_role t WHERE t.isDelete = 0 AND adminUserId ='${loginUserId}')))";
        def list = sqlEX.rows(sql)

        // Element userPermissionAllot = new Element(loginUserId + HandlePermissionsInitializer.getCacheUserPermissionAllotSuffix() , list);
        Element userPermissionAllot = new Element(loginUserId + "UserPermissionAllot" , list);
        onlineUserPermissionAllotEhcache.put(userPermissionAllot);// 缓存私有权限分配
    }
}
