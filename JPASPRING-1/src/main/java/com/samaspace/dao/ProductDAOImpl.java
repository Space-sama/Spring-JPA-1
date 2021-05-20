package com.samaspace.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.samaspace.model.Product;



@Repository("DAOProduct") // Ou bien @ Component
@Transactional

public class ProductDAOImpl implements EntityRepository<Product>{

	//Pour que Spring créer un objet de EntityManager au début de démmarage de l'app
		@PersistenceContext
		private EntityManager em;
		
		@Override
		public Product save(Product p) {
			em.persist(p);
			return p;
		}

		@Override
		public List<Product> findAll() {
			javax.persistence.Query HQL = em.createQuery("SELECT p FROM Product p WHERE p.idProduct IS NOT NULL");
			return HQL.getResultList();
		}

		@Override
		public Product findOne(Long idProd) {
			Product p = em.find(Product.class, idProd);
			return p;
		}

		@Override
		public List<Product> findByDescription(String desc) {
			javax.persistence.Query HQL = em.createQuery("SELECT p FROM Product p WHERE p.idProduct IS NOT NULL"
					+ " AND p.descriptionProduct LIKE :x");
			HQL.setParameter("x", "%"+desc+"%");
			return HQL.getResultList();
		}

		@Override
		public List<Product> findByCateg(String categ) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Product update(Product p) {
			em.merge(p);
			return p;
		}

		
		@Override
		public void remove(Long id) {
			Product p = em.find(Product.class, id);
			em.remove(p);
		}
}
