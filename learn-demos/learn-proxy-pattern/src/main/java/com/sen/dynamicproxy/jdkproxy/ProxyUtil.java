package com.sen.dynamicproxy.jdkproxy;

import com.sen.App;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

/**
 * @author HuangJS
 * @date 2020-01-02 9:39 上午
 */
public class ProxyUtil  {
    public static Object newProxyInstance(ClassLoader loader, Class<?> target, InvocationHandler handler) throws Exception{
        String distDir = ProxyUtil.class.getClassLoader().getResource("").getPath()+"/";
        File packageDir = new File(distDir + target.getPackage().getName().replaceAll("\\.", "/"));
        if (!packageDir.exists()) {
            packageDir.mkdirs();
        }
        Path path = Paths.get(packageDir.getPath() + "/$" + target.getSimpleName() + "Proxy.java");
        Files.write(path, generateProxyClass(target), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);


        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int flag = compiler.run(null, null, null, path.toString());
        if(flag!=0){
            throw new RuntimeException("编译失败");
        }


        // 如果代理类生成在外部，则需要URLClassLoader进行加载，如D:/com/sen/$TestProxy.java
        // loader = new URLClassLoader(new URL[]{new URL("file://D://")});

        Class<?> aClass = loader.loadClass(target.getPackage().getName() + ".$" + target.getSimpleName() + "Proxy");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(InvocationHandler.class);
        return declaredConstructor.newInstance(handler);
    }

    public interface InvocationHandler {
        Object invoke(Object proxy, Method method, Object[] args);
    }

    private static byte[] generateProxyClass(Class<?> target) {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + target.getPackage().getName() + ";\n");
        sb.append("import com.sen.dynamicproxy.jdkproxy.ProxyUtil.InvocationHandler;\n");
        sb.append("import java.lang.reflect.Method;\n");

        sb.append("public class $" + target.getSimpleName() + "Proxy " + (target.isInterface() ? "implements " : "extends ") + target.getCanonicalName() + " {\n");
        sb.append("    private InvocationHandler handler;\n");
        sb.append("    public $" + target.getSimpleName() + "Proxy(InvocationHandler handler){\n");
        sb.append("        this.handler=handler;\n");
        sb.append("    }\n");

        for (Method method : target.getDeclaredMethods()) {
            Class<?>[] types = method.getParameterTypes();
            String args = "";
            String params = "";
            String argsType = "";
            for (int i = 0; i < types.length; i++) {
                argsType += "," + types[i].getCanonicalName() + ".class";
                args += "," + types[i].getCanonicalName() + " p" + i;
                params += ",p" + i;
            }
            if (args.length() > 0) {
                args = args.substring(1);
                params = params.substring(1);
                argsType = argsType.substring(1);
            }
            String returnType = "void".equals(method.getReturnType().getName()) ? "" : "return (" + method.getReturnType().getName() + ")";

            sb.append("    @Override\n");
            sb.append("    public " + method.getReturnType().getName() + " " + method.getName() + "(" + args + ") {\n");
            sb.append("        Method method = null;\n");
            sb.append("        try {\n");
            sb.append("            method = Class.forName(\"" + target.getTypeName() + "\").getDeclaredMethod(\"" + method.getName() + "\",new Class<?>[]{" + argsType + "});\n");
            sb.append("        } catch (Exception e) {\n");
            sb.append("             throw new RuntimeException(e);\n");
            sb.append("        }\n");
            sb.append("        " + returnType + "handler.invoke(this,method,new Object[]{" + params + "});\n");
            sb.append("    }\n");
        }
        sb.append("}");
        return sb.toString().getBytes();
    }






    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            App.Test4 test3 = new App.Test4();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                try {
                    Class<?> declaringClass = method.getDeclaringClass();
                    if (Object.class.equals(declaringClass)) {
                        System.out.println("method.invoke(proxy, args)");
                        return method.invoke(proxy, args);
                    }

                    System.out.println("proxy logs --------------------");
                    return method.invoke(test3, args);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };


        // 类的代理，问题在于继承的方法是否要代理
        App.Test4 test2 = (App.Test4)ProxyUtil.newProxyInstance(ProxyUtil.class.getClassLoader(), App.Test4.class, handler);


        test2.sss4(LocalDate.now(), null);
        System.out.println(test2.toString());
    }
}
