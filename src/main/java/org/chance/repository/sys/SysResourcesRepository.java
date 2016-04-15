package org.chance.repository.sys;

import org.chance.entity.sys.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wqg on 2016/3/25.
 */
public interface SysResourcesRepository extends JpaRepository<SysResource, String> {



}
