package com.yrt.utils

/**
 * Created by srun(LuoXS) on 2017/10/23.
 */
class Const {
    /** 缓存session对象字段 **/
    def static final SESSION_LOGINUSER_OBJ = "loginUser"
    /** 缓存用户ID **/
    def static final SESSION_LOGINUSER_OBJ_ID = "loginUserId"

    /** 缓存前缀 */
    def static final SESSIONCACHEPREFIX = "session:"
    def static final USERHANDLEPERMISSIONCACHEPREFIX = "userHandlePermission:"

    /** 错误码 **/
    def static final CODE_STATUS_SUCCESS = 200
    def static final CODE_STATUS_ERROR = 500
    def static final CODE_STATUS_RIBBON = -1
    def static final CODE_STATUS_ERROR_X = 400
    def static final CODE_STATUS_NOTFOUND = 404

    def static Map codeMsg = [
            "200":"操作成功！",
            "500":"服务器错误！"
    ]
}
