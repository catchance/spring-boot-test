package org.chance.repository.sys;

import org.chance.entity.sys.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by wqg on 2016/3/17.
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String> {

    SysUser findByUsernameAndPassword(String username, String password);

    @Query("select u from SysUser u where u.username =?1 and u.password=?2")
    SysUser login(String username, String password);

    @Query("select u from SysUser u where u.username =?1 ")
    SysUser findByUsername(String username);

    public Collection<GrantedAuthority> loadUserAuthorities(String username);


}
