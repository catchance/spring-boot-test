package org.chance.repository.sys;

import org.chance.entity.sys.SysAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wqg on 2016/3/18.
 */
public class SysUserRepositoryImpl{

//    @PersistenceContext
//    private EntityManager entityManager;

    /**/
    public Collection<GrantedAuthority> loadUserAuthorities(String username) {
        List<SysAuthority> list = this.getSysAuthoritiesByUsername(username);
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        for(SysAuthority authority: list ){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthorityMark());
            auths.add(grantedAuthority);
        }
        return auths;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    private List<SysAuthority> getSysAuthoritiesByUsername(String username) {
        String sql = "select * from sys_authorities where authority_id in ( " +
                "select distinct authority_id form sys_roles_authoritites s1 " +
                "join sys_users_roles s2 on s1.role_id = s2. role_id " +
                "join sys_users s3 on s3.user_id = s2.user_id and s3.username=?1)";
//        Query query = this.entityManager.createNamedQuery(sql, SysAuthority.class);
//        query.setParameter(1, username);
//        List<SysAuthority> list = query.getResultList();
//        return list;
        return null;
    }

}
