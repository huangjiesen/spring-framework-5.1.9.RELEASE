<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [What is IoC](#what-is-ioc)
- [spring实现IOC的思路和方法](#spring%E5%AE%9E%E7%8E%B0ioc%E7%9A%84%E6%80%9D%E8%B7%AF%E5%92%8C%E6%96%B9%E6%B3%95)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

### What is IoC
控制反转（`Inversion of Control`，缩写为`IoC`），是面向对象编程中的一种设计原则，可以用来减低计算机代码之间的耦合度。其中最常见的实现方式叫做依赖注入（`Dependency Injection`，简称`DI`）,换言之`DI`是`IoC`的一种实现方式。还有另外两种方式叫依赖查找（`Dependency Lookup`）及依赖拖拽(`Dependency Pull`)


### spring实现IOC的思路和方法
spring实现IOC的思路是提供一些配置信息用来描述类之间的依赖关系，然后由容器去解析这些配置信息，继而维护好对象之间的依赖关系，前提是对象之间的依赖关系必须在类中定义好，比如A.class中有一个B.class的属性，那么我们可以理解为A依赖了B。既然我们在类中已经定义了他们之间的依赖关系那么为什么还需要在配置文件中去描述和定义呢？

spring实现IOC的思路大致可以拆分成3点
1. 应用程序中提供类，提供依赖关系（属性或者构造方法）
1. 把需要交给容器管理的对象通过配置信息告诉容器（xml、annotation，javaconfig）
1. 把各个类之间的依赖关系通过配置信息告诉容器

<br/>

1. 配置这些信息的方法有三种分别是xml，annotation和javaconfig
1. 维护的过程称为自动注入，自动注入的方法有两种构造方法和setter
1. 自动注入的值可以是对象，数组，map，list和常量比如字符串整形等
