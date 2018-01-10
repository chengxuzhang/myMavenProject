package com.yrt.entity

class AdminUser {
    String id // 主键
    String userName // 用户名
    String userPassword // 密码
    String realName // 真实名称
    String email // 邮箱
    String wechat // 微信
    String qq // QQ
    String phoneNumber // 手机号
    String festnetznummer // 座机号
    String headPortrait // 头像
    Boolean isCanDelete // 是否可删除
    Date createTime // 创建时间
    Date lastUpdateTime // 最后修改时间
    String createUser // 创建人
    Boolean isForbidden // 是否禁用
    Integer isOnline // 是否在线
    String onlineSessionId // 在线时的sessionId
    Integer version // 版本
    Boolean isDelete // 是否删除（0：否，1：是）

    static constraints = {
    }

    static mapping = {
        table "sys_admin_user"
        id column:'id', sqlType: 'String(32)', generator:'uuid'
    }
}
