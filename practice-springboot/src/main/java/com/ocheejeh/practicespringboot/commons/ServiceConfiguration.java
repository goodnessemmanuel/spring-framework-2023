package com.ocheejeh.practicespringboot.commons;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * This class fields are picked from
 * the app properties file of the
 * active profile been use
 * e.g dev, prod, etc
 */
@Component
@ConfigurationProperties(prefix = "service.account")
public class ServiceConfiguration {
    private String url;
    private String username;
    private String key;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }

}
