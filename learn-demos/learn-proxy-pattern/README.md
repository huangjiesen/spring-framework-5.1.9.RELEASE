# 代理模式
在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。<br />
在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。

` 意图: ` 为其他对象提供一种代理以控制对这个对象的访问。<br />
`何时使用：`想在访问一个类时做一些控制。

几种实现代理的实现：
* 静态代理，如通过继承或聚合实现
* 动态代理，如jdk动态代理或cglib动态代理

术语：
* 代理对象：增加控制逻辑后的对象(增强后的对象)
* 目标对象：要增加控制逻辑的对象(要增强的对象)

# 静态代理
## 继承代理
代理对象继承目标对象，重写需要增强的方法<br/>
缺点：当有多个代理业务时，代理类数量随之增多,如果要组成代理链路则类会更多且复杂
```java
public class UserDao {
    public void save(String user) {
        System.out.println("save user info:" + user);
    }
}
public class UserDaoLogProxy extends UserDao {
    @Override
    public void save(String user) {
        System.out.println("com.sen.sp.DogProxy: dog proxy logic");
        super.save(user);
    }
}
```
## 聚合代理
目标对象和代理对象实现同一个接口，代理对象当中要包含目标对象。
缺点：相比继承代理，组成代理链路时不需要创建新的继承链路类
```java
public interface UserDao {
    void save(String user);
}
public class UserDaoImpl implements UserDao {
    @Override
    public void save(String user) {
        System.out.println("save user info:" + user);
    }
}
public class UserDaoLogProxy implements UserDao {
    UserDao target;
    public UserDaoLogProxy(UserDao target) {
        this.target = target;
    }
    @Override
    public void save(String user) {
        System.out.println(this.getClass().getSimpleName()+": logs logic");
        target.save(user);
    }
}
public class UserDaoVerifyProxy implements UserDao {
    UserDao target;
    public UserDaoVerifyProxy(UserDao target) {
        this.target = target;
    }
    @Override
    public void save(String user) {
        System.out.println(this.getClass().getSimpleName()+": verify logic");
        target.save(user);
    }
}
public static void main(String[] args) {
    UserDao target = new UserDaoImpl();
    // 目标对象作为代理对象的属性存在，相比继承代理顺序更灵活，不存在链路继承产生更多类的问题
    //UserDao proxy = new UserDaoVerifyProxy(new UserDaoLogProxy(target));
    UserDao proxy = new UserDaoLogProxy(new UserDaoVerifyProxy(target));
    proxy.save("lishi");
}
```

# 动态代理
## jdk动态代理

jdk动态代理，动态生成的代理类会继承`Proxy`类，基于java单继承的原则所以只可代理接口
