package com.rkjha.microservice.phpropertyaccessservice;

import com.rkjha.microservice.phpropertyaccessservice.beans.PropertyAccessBeans;
import com.rkjha.microservice.phpropertyaccessservice.beans.PropertyAccessValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 06/06/21
 *
 * @author rkjha
 * @project ph-property-access-service
 */
@RestController
@RequestMapping(name = "/access")
public class PropertyAccessController {
    @Autowired
    private PropertyAccessBeans propertyAccessBeans;

    @GetMapping("accessPropertyFile")
    public PropertyAccessValue accessPropertyFile(){
        return new PropertyAccessValue(propertyAccessBeans.getName(),propertyAccessBeans.getDescription());
    }
}
