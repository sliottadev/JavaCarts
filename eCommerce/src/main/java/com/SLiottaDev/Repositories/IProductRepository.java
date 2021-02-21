package com.SLiottaDev.Repositories;

import java.util.List;

import com.SLiottaDev.Models.Product;

public interface IProductRepository {
	
	public Product Add(Product prd);
	
	public Product Modify(Product prd, Long id);
	
	public Product Delete(Long id);
	
	public Product GetProductById(Long id);
	
	public Boolean ProductExists(Long id);
	
	public List<Product> getProducts();

}
