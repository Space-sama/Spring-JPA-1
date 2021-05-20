package com.samaspace.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.samaspace.model.Category;



@Repository("categ")
@Transactional
@Qualifier
public class CategoryDAOImpl implements EntityRepository<Category>{

	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public Category save(Category c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Category> findAll() {
		Query HQL = em.createQuery("SELECT c FROM Category c WHERE c.idCateg is NOT NULL");
		return HQL.getResultList();
	}

	@Override
	
	public Category findOne(Long idCateg) {
		Category C = em.find(Category.class, idCateg);
		return C;
	}

	@Override
	public List<Category> findByDescription(String nameCateg) {
		return null;
	}

	@Override
	public List<Category> findByCateg(String nameCateg) {
		Query HQL = em.createQuery("SELECT c FROM Category c WHERE c.nameCateg like :x");
		HQL.setParameter("x", "%"+nameCateg+"%");
		return HQL.getResultList();
	}

	@Override
	public Category update(Category c) {
		em.merge(c);
		return c;
	}

	@Override
	public void remove(Long id) {
		Category C = em.find(Category.class, id);
		em.remove(C);
		
	}

}
