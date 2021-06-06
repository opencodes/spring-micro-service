package com.rkjha.microservice.phpropertyaccessservice.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on 06/06/21
 *
 * @author rkjha
 * @project ph-property-access-service
 */
@Component
@ConfigurationProperties(prefix = "property-file")
public class PropertyAccessBeans {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
