package org.chance.repository.sys;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by wqg on 2016/3/27.
 */
public interface BaseRepository {
    public Session getSession();
    public List<Object[]> queryBySql(String sql);
    public int excuteBySql(String sql);
}
