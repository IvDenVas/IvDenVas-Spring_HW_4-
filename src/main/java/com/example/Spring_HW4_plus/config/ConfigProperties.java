package com.example.Spring_HW4_plus.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "myconf")
public class ConfigProperties {
    private String sqlFindAll;
    private String sqlAdd;
    private String sqlDelete;
    private String sqlUpdate;
}
