package com.ds.mdb.service.Impl;

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
}
