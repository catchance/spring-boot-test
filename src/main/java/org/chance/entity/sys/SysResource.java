package org.chance.entity.sys;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wqg on 2016/3/16.
 */
@Entity
@Table(name="sys_resources")
public class SysResource implements Serializable {

    private static final long serialVersionUID = -2237573395189576540L;

    //资源ID
    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String resourceId;
    // 资源类型 URL / METHOD
    private String resourceType;
    //资源名称
    private String resourceName;
    //资源描述
    private String resourceDesc;
    //资源路径
    private String resourcePath;
    //优先级
    private String priority;
    //是否可用
    private Integer enable;
    //是否系统权限
    private Integer issys;
    //模块
    private String moduleId;

    @ManyToMany(mappedBy = "sysResources", cascade = CascadeType.ALL)
    private Set<SysAuthority> sysAuthorities = new HashSet<>(0);

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getIssys() {
        return issys;
    }

    public void setIssys(Integer issys) {
        this.issys = issys;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Set<SysAuthority> getSysAuthorities() {
        return sysAuthorities;
    }

    public void setSysAuthorities(Set<SysAuthority> sysAuthorities) {
        this.sysAuthorities = sysAuthorities;
    }
}
