package org.chance.entity.sys;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wqg on 2016/3/16.
 */
@Entity
@Table(name="sys_persistent_logins")
public class SysPersistentLogins implements Serializable {
    //spring remember me 持久化
    private String username;

    @Id
    @GenericGenerator(name="generator" , strategy="org.chance.utils.UUID22Generator")
    @GeneratedValue(generator = "generator")
    private String series;  //主键
    private String token;
    private Date lastUsed;

}
