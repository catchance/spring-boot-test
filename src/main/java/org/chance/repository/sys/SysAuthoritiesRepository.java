package org.chance.repository.sys;

import org.chance.entity.sys.SysAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wqg on 2016/3/25.
 */
public interface SysAuthoritiesRepository extends JpaRepository<SysAuthority,String>{

//    @Query( "select a from sysAuthorities a where a.authorityId in ( " +
//            "select distinct a.authorityId form sysRolesAuthoritites s1 " +
//            "join sysUsersRoles s2 on s1.roleId = s2. roleId " +
//            "join sysUsers s3 on s3.userId = s2.userId and s3.username=? ) ")
//    List<SysAuthority>  getSysAuthoritiesByUsername(String username);

}
