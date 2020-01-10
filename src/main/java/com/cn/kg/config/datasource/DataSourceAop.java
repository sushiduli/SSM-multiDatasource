package com.cn.kg.config.datasource;

/**
 * @program: mvc-template
 * @description: TODO
 * @author: konggang
 * @create: 2019-11-01 23:22
 **/
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class DataSourceAop {

    @Pointcut("!@annotation(com.cn.kg.config.datasource.annotation.Master) " +
            "&& (execution(* com.cn.kg.service..*.select*(..)) " +
            "|| execution(* com.cn.kg.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.cn.kg.config.datasource.annotation.Master) " +
            "|| execution(* com.cn.kg.service..*.insert*(..)) " +
            "|| execution(* com.cn.kg.service..*.add*(..)) " +
            "|| execution(* com.cn.kg.service..*.update*(..)) " +
            "|| execution(* com.cn.kg.service..*.edit*(..)) " +
            "|| execution(* com.cn.kg.service..*.delete*(..)) " +
            "|| execution(* com.cn.kg.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
