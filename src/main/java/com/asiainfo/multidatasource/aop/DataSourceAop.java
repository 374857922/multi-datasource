package com.asiainfo.multidatasource.aop;

import com.asiainfo.multidatasource.datasource.DataSource;
import com.asiainfo.multidatasource.datasource.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DataSourceAop {


    @Before("execution(* com.asiainfo.multidatasource..list*(..)) " +
            "|| execution(* com.asiainfo.multidatasource..query*(..))")
    public void setReadDataSourceType() {
        DataSourceHolder.setDataSource(DataSource.slave);
        System.err.println("dataSource切换到：Read");
    }

    @Before("execution(* com.asiainfo.multidatasource..save*(..))" + "" +
            "||execution(* com.asiainfo.multidatasource..update*(..))")
    public void setWriteDataSourceType() {

        DataSourceHolder.setDataSource(DataSource.master);
        System.err.println("dataSource切换到：write");
    }

    @AfterReturning("execution(* com.asiainfo.multidatasource..*(..))" +
            "|| execution(* com.asiainfo.multidatasource..*(..))")
    public void afterReturn(JoinPoint joinPoint) {
        System.err.println("afterReturn {}");
        DataSourceHolder.clear();
    }
}
