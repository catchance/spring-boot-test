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
@Table(name="sys_authorities_resources")
public class SysAuthorityResource implements Serializable {

    //权限资源Id
    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String id;

    //资源Id
    private String resourceId;
    // 权限Id
    private String authorityId;


}
