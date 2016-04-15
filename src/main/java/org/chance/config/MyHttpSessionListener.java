package org.chance.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by wqg on 2016/3/23.
 */
public class MyHttpSessionListener implements HttpSessionListener{

    Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("Session 被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.debug("ServletContex初始化");
    }
}
