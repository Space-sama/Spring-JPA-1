package com.samaspace;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.samaspace.dao.EntityRepository;
import com.samaspace.model.Category;
import com.samaspace.model.Product;

@SpringBootApplication
public class Jpaspring1Application {

	public static void main(String[] args) {
		
		
		ApplicationContext apx =  SpringApplication.run(Jpaspring1Application.class, args);
		EntityRepository<Product> ProductDAO = (EntityRepository<Product>) apx.getBean("DAOProduct");
		EntityRepository<Category> CategoryDAO = (EntityRepository<Category>) apx.getBean("categ");
		// NB : si j'a deux Beans alors, je dois forcément nommé les deux sinon ca va générer une exception 
		// par ce que Spring expecte un seul bean
		
		
		Category c1= new Category("PC");
		Category c2= new Category("Téléphone");
		Category c3= new Category("Télévision");
		Category c4= new Category("Jeux");
		CategoryDAO.save(c4);
		CategoryDAO.save(c3);
		CategoryDAO.save(c2);
		CategoryDAO.save(c1);
		
		
		  ProductDAO.save(new Product("hsdsdaaa", 899, 90, c1));
		  ProductDAO.save(new Product("ihdsidsd", 211, 100, c2));
		 
			/*
			 * ProductDAO.save(new Product("ihdsidsd", 8933, 152, c1)); ProductDAO.save(new
			 * Product("oooooo", 77733, 11, c1)); ProductDAO.save(new Product("oooooop", 93,
			 * 1287, c1)); ProductDAO.save(new Product("nom", 98, 122));
			 */
		  // error addidng product with a Category ProductDAO.save(new Product("ffffff", 9, 1222, new Category("PC")));
		 //ProductDAO.removeProduct(1L);
		
		List<Product> myProducts = ProductDAO.findAll();
		 //List<Product> myProducts = ProductDAO.findByDescription("o");
		for(int i=0;i<myProducts.size();++i) {
			System.out.println("Product name is :"+ " " +myProducts.get(i).getDescriptionProduct());
			System.out.println("Product price is :"+ " " +myProducts.get(i).getPriceProduct());
			System.out.println("Product amount in the stock is :"+ " " +myProducts.get(i).getAmountProduct());
			System.out.println("********");
		}
		
		
		
		
		
		//CategoryDAO.removeProduct(2L);
		
		
		
		List<Category> myCategs = CategoryDAO.findByCateg("é");
		//List<Category> myCategs = CategoryDAO.findAll();
		for(int i=0;i<myCategs.size();++i) {
			System.out.println("The category name is :"+" "+myCategs.get(i).getNameCateg());
			System.out.println("***************");
		}
		}
		
		
	}


