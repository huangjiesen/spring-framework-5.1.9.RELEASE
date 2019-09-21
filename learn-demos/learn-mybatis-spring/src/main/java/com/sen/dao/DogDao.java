package com.sen.dao;

import com.sen.mapper.Mapper;
import com.sen.mapper.Param;
import com.sen.mapper.Select;

/**
 * @author HuangJS
 * @date 2019-08-28 5:54 PM
 */
@Mapper
public interface DogDao {

	@Select("select * from table where age=#{age} and name = #{name}")
	String query(@Param("name") String name, @Param("age") int age);
}
