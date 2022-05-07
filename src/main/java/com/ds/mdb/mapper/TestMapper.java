package com.ds.mdb.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    int insert(String name, int age);

    String query();
}
