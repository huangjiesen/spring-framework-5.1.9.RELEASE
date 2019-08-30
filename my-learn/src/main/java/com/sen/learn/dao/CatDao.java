package com.sen.learn.dao;

import com.sen.learn.config.dao.Param;
import com.sen.learn.config.dao.Select;

/**
 * @author HuangJS
 * @date 2019-08-28 5:54 PM
 */
//@Mapper
public interface CatDao {
	@Select("select * from catInfo where id=#{id} and age=#{age} and name = #{name}")
	void save(@Param("name") String name, @Param("age") int age);
}
