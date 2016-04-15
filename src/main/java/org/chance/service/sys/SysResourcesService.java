package org.chance.service.sys;

import org.chance.repository.sys.BaseRepository;
import org.chance.repository.sys.SysResourcesRepository;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by wqg on 2016/3/27.
 */
public class SysResourcesService {

    @Autowired
    private BaseRepository baseRepository;

    public List<Map<String, String>> getURLResourceMapping() {
        String sql = "SELECT S3.RESOURCE_PATH,S2.AUTHORITY_MARK FROM SYS_AUTHORITIES_RESOURCES S1 "+
                "JOIN SYS_AUTHORITIES S2 ON S1.AUTHORITY_ID = S2.AUTHORITY_ID "+
                "JOIN SYS_RESOURCES S3 ON S1.RESOURCE_ID = S3.RESOURCE_ID S3.RESOURCE_TYPE='URL' ORDER BY S3.PRIORITY DESC";
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        List<Object[]> query = this.baseRepository.queryBySql(sql);
        Iterator<Object[]> it=query.iterator();
        while (it.hasNext()){
            Object[] o = it.next();
            Map<String,String> map = new HashMap<String,String>();
            map.put("resourcePath", (String)o[0]);
            map.put("authorityMark", (String)o[1]);
            list.add(map);
        }
        return list;
    }

    public List<Map<String, String>> getMethodResourceMapping() {
        String sql = "SELECT S3.RESOURCE_PATH,S2.AUTHORITY_MARK FROM SYS_AUTHORITIES_RESOURCES S1 "+
                "JOIN SYS_AUTHORITIES S2 ON S1.AUTHORITY_ID = S2.AUTHORITY_ID "+
                "JOIN SYS_RESOURCES S3 ON S1.RESOURCE_ID = S3.RESOURCE_ID AND S3.RESOURCE_TYPE='METHOD' ORDER BY S3.PRIORITY DESC";
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        List<Object[]> query = this.baseRepository.queryBySql(sql);
        Iterator<Object[]> it=query.iterator();
        while(it.hasNext()){
            Object[] o = it.next();
            Map<String,String> map = new HashMap<String,String>();
            map.put("resourcePath", (String)o[0]);
            map.put("authorityMark", (String)o[1]);
            list.add(map);
        }
        return list;
    }

}
