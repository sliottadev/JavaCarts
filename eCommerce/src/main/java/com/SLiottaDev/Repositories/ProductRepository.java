package com.SLiottaDev.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

import com.SLiottaDev.Models.Product;

@Repository
public class ProductRepository implements IProductRepository{
	
	private EntityManagerFactory emf;
	private EntityManager manager;

	public ProductRepository() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}

	@Override
	public Product Add(Product prd) {
		
		try {
			
			this.manager.getTransaction().begin();
			this.manager.merge(prd);
			this.manager.getTransaction().commit();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return prd;
	}

	@Override
	public Product Modify(Product prd, Long id) {
		Product aux_prd = new Product();
		try {
			
			this.manager.getTransaction().begin();
			aux_prd = this.manager.find(Product.class, id);
			aux_prd = prd;
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		return aux_prd;
	}

	@Override
	public Product Delete(Long id) {
		Product prd = new Product();
		try {
			
			this.manager.getTransaction().begin();
			prd = this.manager.find(Product.class, id);
			this.manager.remove(prd);
			this.manager.getTransaction().commit();
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		} 
		return prd;
	}

	@Override
	public Product GetProductById(Long id) {
		Product prd = new Product();
		try {
			
			this.manager.getTransaction().begin();
			this.manager.find(Product.class, id);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		return prd;
	}

	@Override
	public Boolean ProductExists(Long id) {
		Boolean result = false;
		try {
			
			this.manager.getTransaction().begin();
			if(this.manager.find(Product.class, id) != null) {
				result = true;
			}
			this.manager.getTransaction().commit();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		List<Product> result;
		try {
			
			this.manager.getTransaction().begin();
			result = this.manager.createQuery("FROM Product").getResultList();
			this.manager.getTransaction().commit();
			return result;
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} 
		return null;
	}

}
