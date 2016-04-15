package org.chance.entity.sys;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by wqg on 2016/3/16.
 */

@Entity
@Table(name="sys_users")
public class SysUser implements UserDetails,Serializable{
    private static final long serialVersionUID = -4642863777009008952L;
    //用户Id
    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String userId;
    //用户名
    private String username;
    //用户姓名
    private String name;
    //密码
    private String password;
    //创建日期
    private Date dtCreate;
    //最后登录日期
    private Date lastLogin;
    //截止日期
    private Date deadLine;
    //最后登录的IP地址
    private String loginIp;
    //所属机构ID
    private String vQzjgid;
    //所属机构名称
    private String vQzjgmc;
    //地区编号
    private String depId;
    //地区名称
    private String depName;
    //是否可用
    private Boolean enabled;
    //用户是否过期
    private Boolean accountNonExpired;
    //用户是否锁定
    private Boolean accountNonLocked;
    //用户证书是否有效
    private Boolean credentialsNonExpired;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "SysUser")
//    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
//    ,mappedBy = "SysUser",fetch = FetchType.LAZY)

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sys_users_roles",
            joinColumns = @JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private Set<SysRole> sysRoles = new HashSet<SysRole>(0);

//    private Collection<GrantedAuthority> authorities;

    public String getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Date getDtCreate() {
        return dtCreate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public String getvQzjgid() {
        return vQzjgid;
    }

    public String getvQzjgmc() {
        return vQzjgmc;
    }

    public String getDepId() {
        return depId;
    }

    public String getDepName() {
        return depName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public Set<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDtCreate(Date dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public void setvQzjgid(String vQzjgid) {
        this.vQzjgid = vQzjgid;
    }

    public void setvQzjgmc(String vQzjgmc) {
        this.vQzjgmc = vQzjgmc;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setSysRoles(Set<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysRole> userRoles = this.getSysRoles();
        if(userRoles !=null ) {
            for(SysRole role: userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

//    @Override
//    public Collection<GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Collection<GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }
}
