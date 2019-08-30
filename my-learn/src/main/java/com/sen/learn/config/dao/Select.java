package com.sen.learn.config.dao;

import java.lang.annotation.*;

/**
 * @author HuangJS
 * @date 2019-08-29 11:10 AM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
	String value();
}
