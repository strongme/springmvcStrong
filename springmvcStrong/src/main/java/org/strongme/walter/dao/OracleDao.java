package org.strongme.walter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value="oracleEM")
public class OracleDao {
	
	@PersistenceContext(unitName="oracle")
	private EntityManager entityManager;

	
}
