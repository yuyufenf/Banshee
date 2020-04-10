package com.gundam.files.controller;

import com.gundam.commons.entity.RespCode;
import com.gundam.commons.entity.RespResult;
import com.gundam.files.entity.File;
import com.gundam.files.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kampf
 * @date 2020/4/10 下午1:28
 */
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public RespResult upload(@RequestParam(name = "file") MultipartFile file,
                             @RequestParam(name = "bucketName") String bucketName,
                             @RequestParam(name = "region") String region) {
        if (StringUtils.isEmpty(bucketName) || StringUtils.isEmpty(region)){
            return new RespResult(RespCode.MISS_PARAM);
        }
        if (file == null || file.getSize() == 0) {
            return new RespResult(RespCode.CODE_ENUM_FAIL, "上传了一个空文件");
        }
        return fileService.upload(file, bucketName, region);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "文件删除")
    public RespResult deleteFile(@RequestBody File file) {
        return fileService.delete(file);
    }

    @GetMapping("/download")
    @ApiOperation(value = "文件下载")
    public void download(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(name = "bucketName") String bucketName,
                         @RequestParam(name = "fileName") String fileName) {
        fileService.download(request, response, fileName, bucketName);
    }

    @PostMapping("/bucket")
    @ApiOperation(value = "创建存储节点")
    public RespResult makeBucket(@RequestParam(name = "bucketName") String bucketName){
        return fileService.makeBucket(bucketName);
    }

    @DeleteMapping("/bucket/{bucketName}")
    @ApiOperation(value = "删除存储节点")
    public RespResult removeBucket(@PathVariable(name = "bucketName") String bucketName){
        return fileService.removeBucket(bucketName);
    }

    @GetMapping("/bucket")
    @ApiOperation(value = "获取所有的存储节点")
    public RespResult listBuckets(){
        return fileService.listBuckets();
    }

    @GetMapping("/bucket/{bucketName}")
    @ApiOperation(value = "获取指定存储节点存储策略")
    public RespResult getBucketNameOfPolicy(@PathVariable(name = "bucketName") String bucketName){
        return fileService.getBucketNameOfPolicy(bucketName);
    }
}
