package com.gundam.files.service;

import com.gundam.commons.entity.RespResult;
import com.gundam.files.entity.File;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kampf
 * @date 2020/4/10 下午1:29
 */
public interface FileService {

    /**
     * 上传文件
     * @param file       文件信息
     * @param bucketName 文件存储桶名称
     * @param fileType   文件类型
     * @return RespResult
     */
    RespResult upload(MultipartFile file, String bucketName, String fileType);

    /**
     * 删除文件
     *
     * @param file 删除条件参数
     * @return RespResult
     */
    RespResult delete(File file);

    /**
     * 下载文件
     *  @param request  请求对象
     * @param response 响应对象
     * @param bucketName 桶名称
     * @param fileName 文件名称
     */
    void download(HttpServletRequest request, HttpServletResponse response, String bucketName, String fileName);

    /**
     * 创建存储节点
     * @param bucketName 存储节点
     * @return 数据
     */
    RespResult makeBucket(String bucketName);

    /**
     * 删除存储节点
     * @param bucketName 存储节点
     * @return 数据
     */
    RespResult removeBucket(String bucketName);

    /**
     * 获取全部存储节点
     * @return 数据
     */
    RespResult listBuckets();

    /**
     * 获取存储节点的存储策略
     * @param bucketName 存储节点
     * @return 数据
     */
    RespResult getBucketNameOfPolicy(String bucketName);
}
