package com.bitwiser.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", "dkz3de5jg",
                        "api_key", "499934813449888",
                        "api_secret", "LxW_k08t-b9MV1_3yM1UYYIq4Uk"
                )
        );
    }
}