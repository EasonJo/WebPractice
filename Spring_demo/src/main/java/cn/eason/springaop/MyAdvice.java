package cn.eason.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * AOP 通知类.通过注解的方式实现 AOP
 *
 * @author Eason
 * @date Create in 18:39 16/04/2018
 */
@Aspect
public class MyAdvice {
    //前置通知
//		|-目标方法运行之前调用 before
    //后置通知(如果出现异常不会调用)
//		|-在目标方法运行之后调用 after
    //环绕通知
//		|-在目标方法之前和之后都调用
    //异常拦截通知
//		|-如果出现异常,就会调用
    //后置通知(无论是否出现 异常都会调用)
//		|-在目标方法运行之后调用
//----------------------------------------------------------------

    @Pointcut("execution(* cn.eason.service.impl.*ServiceImpl.*(..)))")
    public void pc() {
    }

    @Before("MyAdvice.pc()")
    public void before() {
        System.out.println("前置通知");
    }

    @AfterReturning("MyAdvice.pc()")
    public void afterReturning() {
        System.out.println("后置通知(异常之后不会调用)");
    }

    @Around("MyAdvice.pc()")
    public Object around(ProceedingJoinPoint pip) throws Throwable {
        System.out.println("环绕通知,方法之前执行");
        Object o = pip.proceed();
        System.out.println("环绕通知,方法之后执行");
        return o;
    }

    @AfterThrowing("execution(* cn.eason.service.impl.*ServiceImpl.*(..)))")
    public void afterException() {
        System.out.println("Exception after");
    }

    @After("execution(* cn.eason.service.impl.*ServiceImpl.*(..)))")
    public void after() {
        System.out.println("在目标方法运行之后调用,出现异常也会调用");
    }
}
