package com.ds.mdb.Aop;

import com.ds.mdb.Annotion.DS;
import com.ds.mdb.config.DynamicDataSourceConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * mqx
 */
@Component
@Aspect
public class DsAop {

    @Before("within(com.ds.mdb.service.Impl.*) && @annotation(ds)")
    public void before(JoinPoint joinPoint, DS ds){
        DynamicDataSourceConfig.local.set(ds.value());
    }
}
