package com.SLiottaDev.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SLiottaDev.Models.Product;
import com.SLiottaDev.Repositories.IProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	public ProductService() {
	}

	@Override
	public Product Add(Product prd) {
		if (prd != null) {
			productRepository.Add(prd);
		}
		return prd;
	}

	@Override
	public Product Modify(Product prd, Long id) {
		if ((prd != null) && (productRepository.ProductExists(id))) {
			productRepository.Modify(prd, id);
		}
		return prd;
	}

	@Override
	public Product Delete(Long id) {
		if (productRepository.ProductExists(id)) {
			return productRepository.Delete(id);
		} else {
			return null;
		}
	}

	@Override
	public Product GetProductById(Long id) {
		
		return productRepository.GetProductById(id);
	}

	@Override
	public Boolean ProductExists(Long id) {
		
		return productRepository.ProductExists(id);
	}

	@Override
	public List<Product> getProducts() {		
		return productRepository.getProducts();
	}

}
