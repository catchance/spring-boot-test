package org.chance.repository.sys;

import org.chance.entity.sys.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wqg on 2016/3/20.
 */
public interface SysUsersRolesRepository extends JpaRepository<SysUserRole, String> {
}
