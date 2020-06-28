package com.gundam.commons.utils.enumerate;

/**
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
public enum RespCode {

    /** 配置返回值*/
    SUCCESS(true, 10000, 200,  "请求成功"),
    LOGOUT(true, 10001, 202, "用户已注销此次登录"),
    LOGIN(true, 10002, 200, "登录成功"),
    API(true, 10003, 200, "调用Api成功"),
    REMOTE_SUCCESS(true, 10004, 200, "远程调用成功"),
    SEND_SUCCESS(true, 10005, 200, "数据传输成功"),

    ACCESS_ERROR(false, 20000, 401, "权限不足"),
    FORBIDDEN(false, 20001, 401, "禁止访问"),
    METHOD_NOT_ALLOWD(false, 20002, 405, "不支持该请求方式"),
    CONFLICT(false, 20003, 409, "出现冲突"),
    LOGIN_ERROR(false, 20005, 403, "登录失败，用户名或密码错误"),
    REMOTE_ERROR(false, 20006, 403, "远程调用失败"),
    REPEAT_ERROR(false, 20007, 403, "重复操作"),
    SEND_ERROR(false, 20008, 404, "数据传输失败"),
    OUTOFQUEUE(false, 20009, 408, "超出等待队列"),
    TIMEOUT(false, 20010, 408, "请求超时，请稍后重试"),
    CODE_HYSTRIX(false, 20011, 500, "服务繁忙或者服务端发生异常，请稍后再试"),
    REMOTE_CONNECT_FAIL(false, 20013, 404, "远程连接失败"),
    CODE_ENUM_FAIL(false, 20014, 502, "请求失败"),
    EXCEPTION(false, 20015, 500, "请求处理异常，请稍后再试"),
    REJECT(false, 20016, 502,"服务器拒绝请求"),
    SERVICE_NO_ENABLE(false, 20018, 500, "服务不可用"),
    TOKEN_NO_USE(false, 20019, 401,"登录Token过期"),
    USER_NO_LOGIN(false, 20020, 401,"用户未登录或登录信息失效"),
    ILLEGAL_TOKEN(false, 20021, 403, "非法token"),
    MISS_TOKEN(false, 20022, 401, "缺失token"),
    MISS_PARAM(false, 20023, 510, "缺少必要参数"),
    API_FORBIDDEN(false, 20024, 401, "API请求拒绝访问"),
    NO_PERMISSION(false, 20025, 403, "无权限访问"),
    ;

    private boolean flag;
    private Integer code;
    private Integer httpCode;
    private String msg;

    RespCode(boolean flag, Integer code, Integer httpCode, String msg) {
        this.flag = flag;
        this.code = code;
        this.httpCode = httpCode;
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
