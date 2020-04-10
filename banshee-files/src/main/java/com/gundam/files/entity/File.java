package com.gundam.files.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kampf
 * @date 2020/4/10 下午1:33
 */
@Data
@ApiModel(description = "文件操作实体类")
public class File {

    @ApiModelProperty(value = "文件名称", position = 1)
    private String fileName;

    @ApiModelProperty(value = "储存节点(储存桶名称)", position = 2)
    private String bucketName;

    @ApiModelProperty(value = "储存区域(桶内区域名称)", position = 3)
    private String region;
}
