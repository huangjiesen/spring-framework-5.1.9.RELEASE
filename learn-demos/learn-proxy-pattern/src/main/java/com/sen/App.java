package com.sen;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author HuangJS
 * @date 2019-12-31 5:10 下午
 */
public class App {

    public static void main(String[] args)  {

        Method sss3 = null;
        try {
            Class.forName("com.sss");
            sss3 = Test3.class.getDeclaredMethod("sss5",new Class<?>[]{});
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sss3.getName());

        for (Method method : Test4.class.getMethods()) {

            System.out.println(method.getName()+"  ->   "+method.getDeclaringClass());
        }


        System.out.println("--------------");
        for (Method method : Test4.class.getDeclaredMethods()) {
            System.out.println(method.getName()+"  ->   "+method.getDeclaringClass());
        }
    }

    public void sss() {

    }
    public void sss1() {

    }

    public  interface Test1 {
        void sss1();
        void sss2();
        void sss3();
    }

    public interface Test2 {
        LocalDateTime sss4(LocalDate now, Test3 test);
        void sss5();
        void sss6();
    }

    public static class Test4 extends Test3 implements Test1 {

        @Override
        public void sss1() {

        }

        @Override
        public void sss2() {

        }

        protected void seeee() {

        }
        @Override
        public void sss3() {

        }
    }
    public static class Test3  implements Test2 {
        @Override
        public LocalDateTime sss4(LocalDate now,Test3 test) {
            System.out.println("now is " + now);
            return now.atTime(22,34);
        }

        @Override
        public void sss5() {

        }

        @Override
        public void sss6() {

        }

        public Runtime getRuntime(LocalDate now,Test3 test) {
            System.out.println();
            return null;
        }
    }


}
