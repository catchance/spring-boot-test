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
@Table(name="sys_roles")
public class SysRole implements Serializable{

    private static final long serialVersionUID = 3952354821010597493L;

    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    //角色ID
    private String roleId;
    //角色名称
    private String roleName;
    //角色说明
    private String roleDesc;
    //是否可用
    private Integer enable;
    //是否系统权限
    private Integer issys;
    //模块
    private String moduleId;

    @ManyToMany(mappedBy = "sysRoles", cascade = CascadeType.ALL)
    private Set<SysUser> sysUsers = new HashSet<SysUser>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="sys_roles_authorities",
            joinColumns = @JoinColumn(name="roleId"),
            inverseJoinColumns = @JoinColumn(name="authorityId")
    )
    private Set<SysAuthority> sysAuthorities = new HashSet<>(0);

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public Integer getEnable() {
        return enable;
    }

    public Integer getIssys() {
        return issys;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public void setIssys(Integer issys) {
        this.issys = issys;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }

    public SysRole() {
    }

}
