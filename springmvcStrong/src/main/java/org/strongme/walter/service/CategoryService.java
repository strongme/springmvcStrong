package org.strongme.walter.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.strongme.walter.dao.MysqlDao;
import org.strongme.walter.pojo.Category;

@Service
public class CategoryService {
	
	@Resource
	private MysqlDao mysqlDao;
	
	/**
	 * 获取所有电影分类
	 * @return
	 */
	public List<Category> allCategory() {
		List<Category> result = mysqlDao.allCategory();
		return result;
	}

}
