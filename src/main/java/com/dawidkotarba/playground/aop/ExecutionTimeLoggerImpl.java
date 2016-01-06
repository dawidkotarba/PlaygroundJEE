package com.dawidkotarba.playground.aop;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Dawid Kotarba
 */
@Interceptor
@ExecutionTimeLogger
public class ExecutionTimeLoggerImpl implements Serializable {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @AroundInvoke
    public Object apply(InvocationContext context) throws Exception {
        long startTime = System.currentTimeMillis();
        Object proceedVal = context.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.info("Execution time: {} ms for {}", endTime - startTime, context.getContextData());
        return proceedVal;
    }
}
