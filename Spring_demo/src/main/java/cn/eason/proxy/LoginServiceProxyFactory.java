package cn.eason.proxy;

import cn.eason.service.LoginService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Proxy;

/**
 * @author Eason
 * @date Create in 17:58 16/04/2018
 */
public class LoginServiceProxyFactory {

    /**
     * 使用动态代理的方式
     *
     * @param ls
     * @return
     */
    public static <T> T getLoginServiceProxy(Class<T> ls) {

        return (T) Proxy.newProxyInstance(LoginServiceProxyFactory.class.getClassLoader(),
            ls.getInterfaces(),
            (proxy, method, args) -> {
                System.out.println("打开之前");
                Object object = method.invoke(ls, args);
                System.out.println("打开之前");
                return object;
            });
    }

    /**
     * 使用动态代理的方式
     *
     * @param ls
     * @return
     */
    public static LoginService getLoginServiceProxy(LoginService ls) {

        return (LoginService) Proxy.newProxyInstance(LoginServiceProxyFactory.class.getClassLoader(),
            new Class[]{LoginService.class},
            (proxy, method, args) -> {
                System.out.println("打开之前");
                Object object = method.invoke(ls, args);
                System.out.println("打开之前");
                return object;
            });
    }

    public static <T> T getLoginServiceProxyWithCglib(Class<T> tClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("打开事务");
            Object o1 = methodProxy.invokeSuper(o, objects);
            System.out.println("打开事务");
            return o1;
        });
        return (T) enhancer.create();
    }
}
