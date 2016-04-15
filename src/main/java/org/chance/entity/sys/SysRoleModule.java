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

//控制角色对模块的访问权，主要用于生成菜单
@Entity
@Table(name="sys_roles_modules")
public class SysRoleModule implements Serializable {

    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String id;

    private String moduleId;
    private String roleId;

}
