package org.chance.service.sys;

import org.chance.entity.sys.SecurityUser;
import org.chance.entity.sys.SysUser;
import org.chance.repository.sys.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wqg on 2016/3/21.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /* 通过用户名称获取用户 */
        SysUser sysUser = sysUserService.findUserByUsername(username);

        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

        if(sysUser == null) {
            sysUser = this.sysUserService.findUserByUsername(username);
            if(sysUser == null )
                throw new UsernameNotFoundException("UserName"+username + " not found");
            auths = this.sysUserRepository.loadUserAuthorities( username );
//            sysUser.setAuthorities(auths);
        }
        return new SecurityUser(sysUser);
    }

}
