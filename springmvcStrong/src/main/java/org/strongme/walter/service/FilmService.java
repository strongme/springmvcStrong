package org.strongme.walter.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.strongme.walter.dao.MysqlDao;
import org.strongme.walter.pojo.Film;

@Service
public class FilmService {
	
	@Resource
	private MysqlDao mysqlDao;
	
	/**
	 * 根据分类ID获取所有电影
	 * @param categoryId
	 * @return
	 */
	public List<Film> getFilmsByCategoryId(Short categoryId) {
		List<Film> result = mysqlDao.getFilmsByCategory(categoryId);
		return result;
	}

	
	
}
