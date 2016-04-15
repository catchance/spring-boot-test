package org.chance.utils;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;

import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * Created by wqg on 2016/3/16.
 */
public class UUID22Generator implements IdentifierGenerator, Configurable{

    private String sign; //user00000001中 user
    private String classname; // 实体类中类名字
    private String pk;  //主键名字
    private String idLength;  // user00000001中的长度

    @Override
    public void configure(Type type, Properties params, Dialect dialect) throws MappingException {
        this.sign = params.getProperty("sign");
        this.classname = params.getProperty("classname");
        this.pk = params.getProperty("pk");
        this.idLength = params.getProperty("idLength");
    }

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        return UUIDUtils.base58Uuid();
    }

}
