package com.sen.learn.config.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author HuangJS
 * @date 2019-08-29 10:58 AM
 */
public class MapperProxyUtil {

	public static <T> T getProxy(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new ProxyInvocationHandler());
	}

	public static class ProxyInvocationHandler implements InvocationHandler {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Select select = method.getAnnotation(Select.class);
			if (select != null) {
				String sql = select.value();

				if (args.length == 1) {
					sql = sql.replaceAll("#\\{_parameter\\}", args[0].toString());
				} else if (args.length > 1) {
					Annotation[][] annotations = method.getParameterAnnotations();
					for (int i = 0; i < args.length; i++) {
						String paramName = getAnnotationParamName(annotations[i]);
						if (paramName != null) {
							String arg = args[i].toString();
							if (args[i] instanceof String) {
								arg = "'" + args[i] + "'";
							}

							sql = sql.replaceAll("#\\{" + paramName + "\\}", arg);
						}
					}
				}

				System.out.println("proxy execute sql: " + sql);
				return sql;
			}
			Class<?> declaringClass = method.getDeclaringClass();
			if (Object.class.equals(declaringClass)) {
				System.out.println("method.invoke(proxy, args)");
				return method.invoke(this, args);
			}
			return proxy;
		}

		public String getAnnotationParamName(Annotation[] annotations) {
			for (Annotation annotation : annotations) {
				if (annotation.annotationType().equals(Param.class)) {
					return ((Param) annotation).value();
				}
			}
			return null;
		}
	}
}
