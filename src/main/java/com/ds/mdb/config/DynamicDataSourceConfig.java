package com.ds.mdb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * mqx
 */
@Configuration
@Primary
public class DynamicDataSourceConfig extends AbstractRoutingDataSource {

    public static ThreadLocal local = new ThreadLocal();

    @Autowired
    DataSource writeDs;

    @Autowired
    DataSource readDs;

    @Override
    protected Object determineCurrentLookupKey() {
        Object o = local.get();
        if (o == null) {
            return "w";
        }
        //读写混合,走写库
        if (o.equals("wr")) {
            return "w";
        }
        return o;
    }

    @Override
    public void afterPropertiesSet() {

        HashMap<Object, Object> dbs = new HashMap<>();
        dbs.put("w", writeDs);
        dbs.put("r", readDs);

        this.setTargetDataSources(dbs);

        super.afterPropertiesSet();

    }
}
