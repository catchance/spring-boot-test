package org.chance.entity.sys;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wqg on 2016/3/16.
 */

@Entity
@Table(name="sys_modules")
public class SysModule implements Serializable {
    // 模块id
    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String moduleId;
    //模块名称
    private String moduleName;
    //模块说明
    private String moduleDesc;
    //模块类型
    private String moduleType;
    //模块上级
    private String parent;
    //模块地址
    private String moduleUrl;
    // 模块级别 is 1
    private Integer iLevel;
    // 最下级
    private Integer leaf;
    // 应用名称
    private String application;
    // 控制器名称
    private String controller;
    // 是否可用
    private Integer enable;
    // 优先级
    private Integer priority;

}
