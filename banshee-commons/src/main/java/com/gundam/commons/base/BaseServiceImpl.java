package com.gundam.commons.base;

import com.gundam.commons.entity.RespCode;
import com.gundam.commons.entity.RespResult;
import com.gundam.commons.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * 树结构查询
     * @return
     */
    @Override
    public RespResult queryCascade() {
        List<Cascade> cascade = baseMapper.queryCascade();
        List<Cascade> data = CascadeUtil.getCascade(cascade, "0");
        return new RespResult(RespCode.SUCCESS,data);
    }

    @Override
    public RespResult insert(T t, String message) {
        return storage(t, message, INSERT);
    }

    @Override
    public RespResult delete(long id, String message) {
        int result = baseMapper.delete(id);
        if (result > 0){
            return new RespResult(RespCode.SUCCESS, message + "删除成功");
        }
        return new RespResult(RespCode.CODE_ENUM_FAIL, message + "删除失败，当前" + message + "不可操作");
    }

    @Override
    public RespResult modify(T t, String message) {
        return storage(t, message, FETCH);
    }

    @Override
    public RespResult query(Query queryCondition) {
        int total = baseMapper.queryTotal(queryCondition);
        List<T> userList = baseMapper.query(queryCondition);
        PageUtil data = new PageUtil();
        data.setTotal(total);
        data.setData(userList);
        return new RespResult(RespCode.SUCCESS, data);
    }

    /**
     * 新增修改相似方法合并
     * @param t
     * @param message
     * @param type
     * @return
     */
    private RespResult storage(T t, String message, String type){
        int result = 0;
        try {
            if(INSERT.equals(type)){
                result = baseMapper.insert(t);
            } else {
                result = baseMapper.modify(t);
            }

            if (result > 0){
                return new RespResult(RespCode.SUCCESS, type + message + "成功");
            }else{
                RespResult respResult;
                switch (type){
                    case INSERT :
                        respResult = new RespResult(RespCode.CODE_ENUM_FAIL, message + type + "失败");
                        break;
                    case FETCH :
                        respResult = new RespResult(RespCode.CODE_ENUM_FAIL, message + type + "失败," + type + "用户不可操作");
                        break;
                    default:
                        respResult = new RespResult(RespCode.CODE_ENUM_FAIL);
                }
                return respResult;
            }
        } catch (Exception e){
            log.error(type + "失败,报错信息:[{}]", e.getMessage(), e);
            return new RespResult(RespCode.CODE_ENUM_FAIL, type + "失败无法保存数据库");
        }
    }
}
