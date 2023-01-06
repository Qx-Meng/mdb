package com.ds.mdb;

import com.ds.mdb.tx.MdbTransactionManager;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TranscationMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (MdbTransactionManager.count.get().get() != 0) {
            return invocation.proceed();
        }
        boolean state = true;
        Object proceed = null;
        try {
            proceed = invocation.proceed();
        } catch (Exception e) {
            state = false;
        }finally {
            if (state) {
                MdbTransactionManager.commit();
            } else {
                MdbTransactionManager.rollBack();
            }
        }
        return proceed;
    }
}
