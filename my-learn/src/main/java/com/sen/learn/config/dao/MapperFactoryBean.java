package com.sen.learn.config.dao;

import com.sen.learn.service.DogService;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author HuangJS
 * @date 2019-08-29 10:43 AM
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {
	private Class<T> t;

	private String vars;

	//
	// GenericBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
	// 注册BeanDefinition 通过以上
	private DogService dogService;

	public DogService getDogService() {
		return dogService;
	}

	public void setDogService(DogService dogService) {
		System.out.println("auto set dog service");
		this.dogService = dogService;
	}

	public String getVars() {
		return vars;
	}

	public void setVars(String vars) {
		this.vars = vars;
	}


	public MapperFactoryBean(Class<T> t) {
		this.t = t;
	}

	@Override
	public T getObject() throws Exception {
		System.out.println("com.sen.learn.config.dao.MapperFactoryBean.getObject#dogService：" + dogService);
		return MapperProxyUtil.getProxy(t);
	}

	@Override
	public Class<?> getObjectType() {
		return t;
	}
}
