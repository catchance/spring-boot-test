package org.chance.service;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Created by wqg on 2016/3/14.
 */
public class CitySearchCriteria implements Serializable{

    private static final long serialVersionUID = -7754937956507814586L;

    private String name;

    public CitySearchCriteria() {
    }

    public CitySearchCriteria(String name) {
        Assert.notNull(name,"Name must not be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
