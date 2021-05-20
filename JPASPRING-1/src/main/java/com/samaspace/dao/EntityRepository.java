package com.samaspace.dao;

import java.util.List;



public interface EntityRepository<T> {

	public T save(T t);
	public List<T> findAll();
	public T findOne(Long idProd);
	public List<T> findByDescription(String desc);
	public List<T> findByCateg(String categ);
	public T update(T t);
	public void remove(Long id);
}
