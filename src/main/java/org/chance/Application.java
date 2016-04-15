package org.chance;

import org.chance.repository.PersonRepository;
import org.chance.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Created by wqg on 2016/3/12.
 */

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication  //@springBootApplication = 上面三个
//
@ServletComponentScan
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner{

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PersonRepository repository;

    @Autowired
    private SampleService sampleService;

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }
        };
    }

//    @Bean
//    protected ThymeleafViewResolver templateResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setViewNames(new String[]{"/th/*"});
//        viewResolver.setOrder(1);
//        viewResolver.setCharacterEncoding("utf-8");
//
//        //
//        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
//        resolver.setPrefix("classpath:templates/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML5");
//        resolver.setCharacterEncoding("utf-8");
//        //
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(resolver);
//
//        viewResolver.setTemplateEngine(engine);
//        return viewResolver;
//    }

//    @Bean
//    protected InternalResourceViewResolver jspViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/content");
//        resolver.setSuffix(".jsp");
//        resolver.setViewNames("/jsp/*");
//        resolver.setOrder(0);
//        return  resolver;
//    }

    @Bean
    protected ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:config/message_zh_CN");
        return source;
    }

    public void run(String... args) throws Exception {
//        System.err.println(this.repository.findAll());
//        SecurityContextHolder.getContext()
//                .setAuthentication(new UsernamePasswordAuthenticationToken("user","N/A",
//                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
//        try{
//            System.out.println(this.sampleService.secure());
//        }finally {
//            SecurityContextHolder.clearContext();
//        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/access").setViewName("access");
        super.addViewControllers(registry);
    }

    public static void main(String[] args) {
        // Disabling restart
//        System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(Application.class,args);
    }

}
