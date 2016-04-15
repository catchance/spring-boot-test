package org.chance.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by wqg on 2016/3/23.
 */

@WebListener
public class MyServletContextListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("ServletContex初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("ServletContex销毁");
    }
}
