package com.gundam.commons.utils;



import com.gundam.commons.entity.BaseCascade;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成Json级联菜单
 * @author kampf
 * @date 2020/4/8 下午3:30
 */
public class JsonTreeUtil<T extends BaseCascade<T>> {

    public List<T> getTree(List<T> dataList, String pid){
        List<T> data = new ArrayList<>();
        for (T cascade : dataList){
            // 获取顶级根节点
            if (pid.equals(String.valueOf(cascade.getParentId()))){
                data.add(addChild(cascade, dataList));
            }
        }
        return data;
    }

    /**
     * 获取子节点
     */
    private T addChild(T cascade, List<T> dataList) {
        List<T> childList = new ArrayList<>();
        for (T child : dataList){
            // 获取根节点
            if (child.getParentId().equals(cascade.getValue())){
                childList.add(child);
                addChild(child, dataList);
            }
        }
        if (childList.size() >= 1){
            // 为每一个父节点增加子树（List形式，没有则为空的list）
            cascade.setChildren(childList);
        }
        return cascade;
    }

}
