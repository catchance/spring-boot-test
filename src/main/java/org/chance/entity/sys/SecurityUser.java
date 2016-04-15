package org.chance.entity.sys;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by wqg on 2016/3/21.
 */
public class SecurityUser extends SysUser implements UserDetails{

    private static final long serialVersionUID = -4731191740389880197L;

    public SecurityUser(SysUser sysUser) {
        if(sysUser != null) {
            this.setUserId(sysUser.getUserId());
            this.setName(sysUser.getName());
            this.setPassword(sysUser.getPassword());
            this.setSysRoles(sysUser.getSysRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysRole> userRoles = this.getSysRoles();
        if(userRoles !=null ) {
            for(SysRole role: userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }


}
