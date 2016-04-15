package org.chance.service.sys;

import org.chance.entity.sys.SysAuthority;
import org.chance.entity.sys.SysUser;
import org.chance.repository.sys.BaseRepository;
import org.chance.repository.sys.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wqg on 2016/3/17.
 */

@Service("sysUserService")
@CacheConfig(cacheNames = "userCache")
public class SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private BaseRepository baseRepository;


    @PersistenceContext
    private EntityManager entityManager;



    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    public SysUser create(SysUser user) {
        return sysUserRepository.save(user);
    }

    public SysUser findUserById(String id) {
        return sysUserRepository.findOne(id);
    }

    public SysUser login(String username, String password) {
        return sysUserRepository.findByUsernameAndPassword(username,password);
    }

    public SysUser update(SysUser user) {
        return sysUserRepository.save(user);
    }

    public void deleteUser(String id) {
        sysUserRepository.delete(id);
    }

    @Cacheable
    public SysUser findUserByUsername(String username){
        return sysUserRepository.findByUsername(username);
    }

    /**
     * 根据用户名获取到用户的权限并封装成GrantedAuthority集合
     * @param username
     */
    public Collection<GrantedAuthority> loadUserAuthorities(String username){
        List<SysAuthority> list = this.getSysAuthoritiesByUsername(username);
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        for (SysAuthority authority : list) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthorityMark());
            auths.add(grantedAuthority);
        }
        return auths;
    }

    /**
     * 先根据用户名获取到SysAuthorities集合
     * @param username
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<SysAuthority> getSysAuthoritiesByUsername(String username){
        String sql = "SELECT * FROM SYS_AUTHORITIES WHERE AUTHORITY_ID IN( "+
                "SELECT DISTINCT AUTHORITY_ID FROM SYS_ROLES_AUTHORITIES  S1 "+
                "JOIN SYS_USERS_ROLES S2 ON S1.ROLE_ID = S2.ROLE_ID "+
                "JOIN SYS_USERS S3 ON S3.USER_ID = S2.USER_ID AND S3.USERNAME=?1)";

        Query query = this.entityManager.createNativeQuery(sql, SysAuthority.class);
        List<SysAuthority> list = query.getResultList();
        return list;
    }
}
