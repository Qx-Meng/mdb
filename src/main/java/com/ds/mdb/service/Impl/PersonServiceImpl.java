package com.ds.mdb.service.Impl;

import com.ds.mdb.config.DynamicDataSourceConfig;
import com.ds.mdb.mapper.TestMapper;
import com.ds.mdb.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    TestMapper testMapper;

    @Override
    public void insert() {

        testMapper.insert("zhans", 18);
    }

    @Override
    public String query() {
        return testMapper.query();
    }

    @Override
    public String edit() {

        //读写混合,走写库,配置这样的代码即可
        DynamicDataSourceConfig.local.set("wr");

        testMapper.insert("zhans", 18);

        return testMapper.query();
    }


}
