package org.chance.controller;

import org.chance.entity.User;
import org.chance.entity.sys.SysRole;
import org.chance.entity.sys.SysUser;
import org.chance.entity.sys.SysUserRole;
import org.chance.repository.sys.SysRoleRepository;
import org.chance.repository.sys.SysUserRepository;
import org.chance.repository.sys.SysUsersRolesRepository;
import org.chance.utils.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wqg on 2016/3/12.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private SysRoleRepository sysRoleRepository;
    @Autowired
    private SysUsersRolesRepository sysUsersRolesRepository;

    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }

    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        return user;
    }

    //添加记录
    @RequestMapping("/add")
    public void add(){

        SysUser sysUser=new SysUser();
        sysUser.setName("gc");
        sysUser.setUsername("gc");
        sysUser.setPassword(EncryptUtils.encrypt("gc"));
        sysUser.setEnabled(true);

        SysRole sysRole = new SysRole();
        sysRole.setRoleName("ADMIN");
        sysRole.setRoleDesc("Admin");
        sysRole.setEnable(1);

        SysUserRole sysUsersRoles= new SysUserRole();
        sysUser = sysUserRepository.save(sysUser);
        sysRole = sysRoleRepository.save(sysRole);

        sysUsersRoles.setRoleId(sysRole.getRoleId());
        sysUsersRoles.setUserId(sysUser.getUserId());
        sysUsersRolesRepository.save(sysUsersRoles);

    }

}
