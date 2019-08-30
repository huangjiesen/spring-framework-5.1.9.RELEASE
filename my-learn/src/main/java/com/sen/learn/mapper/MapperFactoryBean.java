package com.sen.learn.mapper;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author HuangJS
 * @date 2019-08-29 10:43 AM
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {
	private Class<T> t;
	private String proxyTargetName;
	private SqlSession sqlSession;


	// GenericBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
	// 注册BeanDefinition时通过以上设置,容器会自动set方法注入可用依赖
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setProxyTargetName(String proxyTargetName) {
		this.proxyTargetName = proxyTargetName;
	}

	public MapperFactoryBean(Class<T> t) {
		this.t = t;
	}

	@Override
	public T getObject() throws Exception {
		System.out.println("create proxy instance " + proxyTargetName);
		return MapperProxyUtil.getProxy(t, sqlSession);
	}

	@Override
	public Class<?> getObjectType() {
		return t;
	}
}
