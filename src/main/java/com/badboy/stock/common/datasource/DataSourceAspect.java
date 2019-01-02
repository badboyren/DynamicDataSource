package com.badboy.stock.common.datasource;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.badboy.stock.common.datasource.myDataSource.Badboy1DataSource;
import com.badboy.stock.common.datasource.myDataSource.BadboyDataSource;


@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {


    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("execution(* com.badboy.stock.mapper..*.*(..))")
    public void aspect() {
    }
    
	@Before("aspect()")
    public void before(JoinPoint point) {
    	try {
	    	Class<?> clz = point.getSignature().getDeclaringType();
	        String className = point.getSignature().getDeclaringTypeName();
	        String method = point.getSignature().getName();
	        String args = StringUtils.join(point.getArgs(), ",");
//	        logger.info("className:{}, method:{}, args:{} ", className, method, args);
        	
	        if (BadboyDataSource.class.isAssignableFrom(clz)) {
	        	
	        	logger.info(">>BadboyDataSource {}方法使用的数据源为:{}<<", method);
	        	
                 DatabaseContextHolder.setDatabaseType(DatabaseType.badboy);
                 DatabaseType types = DatabaseContextHolder.getDatabaseType();
                 logger.info(">>{}方法使用的数据源为:{}<<", method, types);
			}else if(Badboy1DataSource.class.isAssignableFrom(clz)) {
				
				logger.info(">>Badboy1DataSource {}方法使用的数据源为:{}<<", method);
				
				 DatabaseContextHolder.setDatabaseType(DatabaseType.badboy1);
                 DatabaseType types = DatabaseContextHolder.getDatabaseType();
                 logger.info(">>{}方法使用的数据源为:{}<<", method, types);
                 
			} else {
				 logger.info(">>default {}方法使用的数据源为:{}<<", method);
				 DatabaseContextHolder.setDatabaseType(DatabaseType.badboy);
                 DatabaseType types = DatabaseContextHolder.getDatabaseType();
                 logger.info(">>{}方法使用的数据源为:{}<<", method, types);
			}
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
