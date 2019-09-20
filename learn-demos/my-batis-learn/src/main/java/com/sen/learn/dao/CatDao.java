package com.sen.learn.dao;

import com.sen.learn.mapper.Mapper;
import com.sen.learn.mapper.Param;
import com.sen.learn.mapper.Select;

/**
 * @author HuangJS
 * @date 2019-08-28 5:54 PM
 */
@Mapper
public interface CatDao {
	@Select("select * from catInfo where age=#{age} and name = #{name}")
	void select(@Param("name") String name, @Param("age") int age);
}
