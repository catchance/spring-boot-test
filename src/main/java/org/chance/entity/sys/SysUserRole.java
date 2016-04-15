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
@Table(name = "sys_users_roles")
public class SysUserRole implements Serializable {

    //用户角色表Id
    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String id;
    //角色Id
    private String roleId;
    //用户Id
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
