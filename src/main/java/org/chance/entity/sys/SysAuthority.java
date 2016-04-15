package org.chance.entity.sys;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wqg on 2016/3/16.
 */

@Entity
@Table(name="sys_authorities")
public class SysAuthority implements Serializable{

    private static final long serialVersionUID = 1636673514396494786L;

    //权限Id
    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String authorityId;
    //权限标志
    private String authorityMark;
    //权限名称
    private String authorityName;
    //权限说明
    private String authorityDesc;
    //权限信息
    private String message;
    //是否可用
    private Integer enable;
    //是否系统权限
    private Integer issys;
    //模块Id
    private String moduleId;

    @ManyToMany(mappedBy = "sysAuthorities", cascade = CascadeType.ALL)
    private Set<SysRole> sysRoles = new HashSet<SysRole>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="sys_authorities_resources",
            joinColumns = @JoinColumn(name="authorityId"),
            inverseJoinColumns = @JoinColumn(name="resourceId")
    )
    private Set<SysResource> sysResources = new HashSet<>(0);

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityMark() {
        return authorityMark;
    }

    public void setAuthorityMark(String authorityMark) {
        this.authorityMark = authorityMark;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public Set<SysResource> getSysResources() {
        return sysResources;
    }

    public void setSysResources(Set<SysResource> sysResources) {
        this.sysResources = sysResources;
    }
}
