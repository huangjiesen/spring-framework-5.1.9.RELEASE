package com.sen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author HuangJS
 * @date 2020-01-03 10:52 上午
 */
public class JdkProxyDemo {
    public static void main(String[] args) {
        Object proxy = Proxy.newProxyInstance(App.class.getClassLoader(), new Class<?>[]{ReadInterface.class, WriteInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 如果调用的是Object类的方法，则由代理执行，如toString,hashCode
                Class<?> declaringClass = method.getDeclaringClass();
                if (Object.class.equals(declaringClass)) {
                    return method.invoke(proxy, args);
                }

                return "this is method result,method:" + method.getName() + ",args:{" + args[0] + "}";
            }
        });
        ReadInterface readProxy = (ReadInterface) proxy;
        System.out.println(readProxy.read("d:/")); //this is method result,method:read,args:{d:/}

        WriteInterface writeProxy = (WriteInterface) proxy;
        System.out.println(writeProxy.write("e:/")); //this is method result,method:write,args:{e:/}
    }

    public interface ReadInterface {
        String read(String path);
    }
    public interface WriteInterface {
        String write(String path);
    }
}
