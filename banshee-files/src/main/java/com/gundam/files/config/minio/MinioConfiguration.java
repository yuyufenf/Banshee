package com.gundam.files.config.minio;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author kampf
 * @date 2020/4/10 上午9:11
 */
@Configuration
public class MinioConfiguration {
    @Resource
    private Minio minio;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(minio.getUrl(), minio.getAccessKey(), minio.getSecretKey());
    }
}
