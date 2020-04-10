package com.gundam.files.config.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author kampf
 * @date 2020/4/10 上午9:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class Minio implements Serializable {

    private static final long serialVersionUID = -5941954119433585718L;

    private String url;

    private String accessKey;

    private String secretKey;
}
