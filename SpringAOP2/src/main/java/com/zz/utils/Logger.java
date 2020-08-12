package com.zz.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 模拟日志工具类
 */
@Component(value = "logger")
@Aspect //表示当前类是一个切面类
public class Logger {

    // 切入点表达式
    @Pointcut("execution(* com.zz.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 在切入点方法执行前执行（切入点就行业务层方法）
     * 前置通知
     */
    @Before("pt1()")
    public void printLog(){
        System.out.println("Logger日志开始记录了~~~前置");
    }

    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterprintLog(){
        System.out.println("Logger日志开始记录了~~~后置");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void exceptionprintLog(){
        System.out.println("Logger日志开始记录了~~~异常");
    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public void finalprintLog(){
        System.out.println("Logger日志开始记录了~~~最终");
    }

    /**
     * 环绕通知
     *  问题：
     *      配置环绕通知后，切入点方法没有执行
     *  分析：
     *      通过与动态代理方法的比对，可用发现在动态代理方法中有明确指定什么时候调用切入点方法，
     *      而这里的环绕通知方法没有指明要调用切入点方法。
     *  解决：
     *      Spring框架提供了一个 ProceedingJoinPoint 接口，此接口可以通过调用 proceed()方法来明确调用切入点方法。
     *      同时此接口可以作为环绕通知的方法参数。Spring框架会提供该接口的实现类，所以可以大胆放心的使用
     *  Spring中的环绕通知：
     *      它是Spring框架为我们提供的一种可以手动控制增强方法何时执行的方式。
     */
//    @Around("pt1()")
//    public Object arountprintLog(ProceedingJoinPoint pjt){
//        Object retunValue = null;
//        try {
//            Object[] args = pjt.getArgs();
//            System.out.println("Logger日志的环绕通知**********前置");
//            retunValue = pjt.proceed(args); // 明确调用业务层方法 == 切入点方法
//            System.out.println("Logger日志的环绕通知**********后置");
//            return retunValue;
//        } catch (Throwable t){
//            System.out.println("Logger日志的环绕通知**********异常");
//            throw new RuntimeException(t);
//        } finally {
//            System.out.println("Logger日志的环绕通知**********最终");
//        }
//
//    }
}
