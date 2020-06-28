package com.gundam.commons.base;

import com.gundam.commons.utils.enumerate.RespCode;
import com.gundam.commons.entity.RespResult;
import com.gundam.commons.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author kampf
 * @date 2020/4/9 上午8:59
 */
@Slf4j
@Service
public class BaseServiceImpl<T, Query> implements BaseService<T, Query>{

    private static final String INSERT = "新增";
    private static final String FETCH = "更新";

    @Resource
    BaseMapper<T, Query> baseMapper;


    @Override
    public RespResult insert(HttpServletResponse response, HttpServletRequest request, T t, String message) {
        return storage(response, t, message, INSERT);
    }

    @Override
    public RespResult delete(HttpServletResponse response, HttpServletRequest request, long id, String message) {
        int result = baseMapper.delete(id);
        if (result > 0){
            return RespResult.success(response, null, message + "删除成功");
        }
        return RespResult.error(response, RespCode.CODE_ENUM_FAIL, message + "删除失败，当前" + message + "不可操作");
    }

    @Override
    public RespResult modify(HttpServletResponse response, HttpServletRequest request, T t, String message) {
        return storage(response, t, message, FETCH);
    }

    @Override
    public RespResult query(HttpServletResponse response, HttpServletRequest request, Query queryCondition) {
        int total = baseMapper.queryTotal(queryCondition);
        List<T> userList = baseMapper.query(queryCondition);
        Page data = new Page();
        data.setTotal(total);
        data.setData(userList);
        return RespResult.success(response, data, "查询成功");
    }

    /**
     * 新增修改相似方法合并
     * @param t
     * @param message
     * @param type
     * @return
     */
    private RespResult storage(HttpServletResponse response, T t, String message, String type){
        int result = 0;
        try {
            if(INSERT.equals(type)){
                result = baseMapper.insert(t);
            } else {
                result = baseMapper.modify(t);
            }

            if (result > 0){
                return RespResult.success(response, RespCode.SUCCESS, type + message + "成功");
            }else{
                RespResult respResult;
                switch (type){
                    case INSERT :
                        respResult = RespResult.error(response, RespCode.CODE_ENUM_FAIL, message + type + "失败");
                        break;
                    case FETCH :
                        respResult = RespResult.error(response, RespCode.CODE_ENUM_FAIL, message + type + "失败," + type + "用户不可操作");
                        break;
                    default:
                        respResult = RespResult.error(response, RespCode.CODE_ENUM_FAIL, "");
                }
                return respResult;
            }
        } catch (Exception e){
            log.error(type + "失败,报错信息:[{}]", e.getMessage(), e);
            return RespResult.error(response, RespCode.CODE_ENUM_FAIL, type + "失败无法保存数据库");
        }
    }
}
