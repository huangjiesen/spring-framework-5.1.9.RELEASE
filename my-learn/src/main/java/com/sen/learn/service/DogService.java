package com.sen.learn.service;

import com.sen.learn.dao.DogDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author HuangJS
 * @date 2019-08-28 5:54 PM
 */
public class DogService {
	@Autowired
	private DogDao dogDao;

	public void save() {
		System.out.println("dog service save info");
		dogDao.save("haha",29);
	}
}
