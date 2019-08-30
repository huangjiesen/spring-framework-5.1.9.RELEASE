package com.sen.learn.dao;

import com.sen.learn.config.dao.Mapper;
import com.sen.learn.config.dao.Param;
import com.sen.learn.config.dao.Select;

/**
 * @author HuangJS
 * @date 2019-08-28 5:54 PM
 */
@Mapper
public interface DogDao {

	@Select("select * from table where id=#{id} and age=#{age} and name = #{name}")
	String save(@Param("name") String name,@Param("age") int age);
}
