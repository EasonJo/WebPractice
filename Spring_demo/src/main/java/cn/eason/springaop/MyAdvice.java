package cn.eason.springaop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Eason
 * @date Create in 18:39 16/04/2018
 */
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

    public void before() {
        System.out.println("前置通知");
    }

    public void afterReturning() {
        System.out.println("后置通知(异常之后不会调用)");
    }

    public Object around(ProceedingJoinPoint pip) throws Throwable {
        System.out.println("环绕通知,方法之前执行");
        Object o = pip.proceed();
        System.out.println("环绕通知,方法之后执行");
        return o;
    }

    public void afterException() {
        System.out.println("Exception after");
    }

    public void after() {
        System.out.println("在目标方法运行之后调用,出现异常也会调用");
    }
}
