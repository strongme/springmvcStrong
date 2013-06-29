package org.strongme.walter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.strongme.walter.pojo.Category;
import org.strongme.walter.pojo.Film;

@Repository
@Transactional(value="mysqlEM")
public class MysqlDao {
	
	@PersistenceContext(unitName="mysql")
	private EntityManager entityManager;
	
	/**
	 * 获取所有电影分类
	 * @return
	 */
	public List<Category> allCategory() {
		List<Category> result = null;
		Query query = entityManager.createNamedQuery("allCatrgory");
		result = query.getResultList();
		return result;
	}
	
	/**
	 * 根据分类获取该分类所以电影
	 * @param categoryId
	 * @return
	 */
	public List<Film> getFilmsByCategory(Short categoryId) {
		List<Film> result = null;
		Query query = entityManager.createNamedQuery("filmsByCategory");
		query.setParameter("categoryId", categoryId);
		result =query.getResultList();
		System.out.println(result.get(0).getDescription());
		return result;
	}

}
