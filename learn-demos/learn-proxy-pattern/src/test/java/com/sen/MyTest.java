package com.sen;

/**
 * @author HuangJS
 * @date 2020-01-06 10:01 上午
 */
public class MyTest {
    static class AAA extends MyTest implements BBB {}
    interface BBB { }
    // 字段
    private BBB bbb;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //
        // 父类.class.isAssignableFrom(子类.class)
        // 判断类继承关系: 调用者和参数都是Class对象，调用者为父类，参数为本身或者其子类。
        //
        System.out.println(BBB.class.isAssignableFrom(BBB.class)); // true  类相同
        System.out.println(BBB.class.isAssignableFrom(AAA.class)); // true  AAA实现BBB接口

        System.out.println(AAA.class.isAssignableFrom(BBB.class)); // false BBB非AAA的子类或实现

        MyTest aaaInstance = new AAA();
        MyTest testInstance = new MyTest();
        System.out.println(testInstance.getClass().isAssignableFrom(aaaInstance.getClass())); // true AAA继承MyTest
        System.out.println(testInstance.getClass().isAssignableFrom(AAA.class));              // true AAA继承MyTest
        System.out.println(MyTest.class.isAssignableFrom(aaaInstance.getClass()));            // true AAA继承MyTest
        System.out.println(AAA.class.isAssignableFrom(MyTest.class));                         // false MyTest非AAA的子类

        // true
        System.out.println(MyTest.class.getDeclaredField("bbb").getType().isAssignableFrom(aaaInstance.getClass()));
        System.out.println(MyTest.class.getDeclaredFields()[0].getType().isAssignableFrom(aaaInstance.getClass()));

        //
        // 子类实例 instanceof 父类类型
        // 判断实例继承关系: 前一个为类的实例，后一个为其本身或者父类的类型。
        //
        System.out.println(aaaInstance instanceof MyTest);  // true AAA继承MyTest
        System.out.println(testInstance instanceof MyTest); // true 自身实例
        System.out.println(new Object() instanceof MyTest); // false
    }
}
