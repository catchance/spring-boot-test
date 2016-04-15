package org.chance.config;

import org.chance.utils.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import javax.xml.ws.WebServiceException;


/**
 * Created by wqg on 2016/3/17.
 */

//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class MultiHttpSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired @Qualifier("dataSource")
    protected DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception {

        //In Memory Authentication
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");

        //JDBC Authentication
        auth.jdbcAuthentication()
                .dataSource(dataSource)
//                .withDefaultSchema()
                .groupAuthoritiesByUsername(groupAuthoritiesByUsername())
                .usersByUsernameQuery(getUserQuery())
                .authoritiesByUsernameQuery(getAuthoritiesQuery())
                .passwordEncoder(new StandardPasswordEncoder());

        //设置userDetailsService
//      auth.userDetailsService().passwordEncoder(new StandardPasswordEncoder());

        //LDAP Authentication
//        auth
//                .ldapAuthentication()
//                .userDnPatterns("uid={0},ou=people")
//                .groupSearchBase("ou=groups");

    }


//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        protected void configure(HttpSecurity http) throws Exception {
////            http
////                    .antMatcher("/api/**")
////                    .authorizeRequests()
////                    .anyRequest().hasRole("ADMIN")
////                    .and()
////                    .httpBasic();
//        }
//    }
//
//    @Configuration
//    @Order(2)
//    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
////            http
////                    .authorizeRequests()
////                    .anyRequest().authenticated()
////                    .and()
////                    .formLogin();
//        }
//    }
//
//    @Configuration
//    @Order(3)
//    public static class MyWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置不过滤的资源（静态资源及登录相关）
//        web.ignoring().antMatchers("/webjars/**", "/css/**", "/less/**","/img/**","/js/**");
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //添加过滤器

        //允许所有用户访问 / 和 /home
        http.authorizeRequests().antMatchers("/", "/home").permitAll()
                //其他地址的访问均需要验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是/login
                .loginPage("/login").permitAll()
                //登录成功后可以使用loginSuccessHandler() 存储用户信息，可选
                .successHandler(loginSuccessHandler())
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //退出后的默认网址是/home
                .logoutSuccessUrl("/home").permitAll()
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/access?error")
                .and()
                        //登录后记住用户，下次自动登录
                        //数据库中必须存在名称persistent_logins
                .rememberMe().key("9D119EE5A2B7DAF6B4DC1EF871D0AC3C")
                .tokenValiditySeconds(1209600)
                //指定记住登录信息所使用到的数据源
                .tokenRepository(tokenRepository())
        //        .rememberMeServices()
        ;
        super.configure(http);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
        /*设置创建初始化 persistent_logins*/
//        j.setCreateTableOnStartup(true);
        j.setDataSource(dataSource);
        return j;
    }

    private String getUserQuery() {
        return "select username as username, password as password, enabled as enabled "
                +"from sys_users "
                +"where username = ? ";
    }

    private String groupAuthoritiesByUsername(){
        return "select r.role_id, r.role_name, a.authority_mark " +
        "from sys_roles r, sys_users_roles ur, sys_roles_authorities ra, sys_authorities a, sys_users u " +
        "where r.role_id = ur.role_id " +
        "and u.user_id = ur.user_id " +
        "and ra.role_id = r.role_id " +
        "and ra.authority_id = a.authority_id " +
        "and u.name = ? ";
    }

    private String getAuthoritiesQuery() {
        return "SELECT * FROM SYS_AUTHORITIES WHERE AUTHORITY_ID IN( "+
                "SELECT DISTINCT AUTHORITY_ID FROM SYS_ROLES_AUTHORITIES  S1 "+
                "JOIN SYS_USERS_ROLES S2 ON S1.ROLE_ID = S2.ROLE_ID "+
                "JOIN SYS_USERS S3 ON S3.USER_ID = S2.USER_ID AND S3.USERNAME=?)";
    }

}