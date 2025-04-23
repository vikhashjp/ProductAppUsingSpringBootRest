package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;
@Service("service")
public class ProductServiceImpl implements ProductService{
	Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository repository;

	@Override
	public String saveProduct(Product product) {
		log.info("In ProductServiceImpl saveproduct method....");
		Product pro= repository.save(product);
		 return (pro!=null)?"Saved Successfully :)":"Not Saved :(";
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product pro= repository.save(product);
		 return pro;
	}

	@Override
	public String removeProduct(int productId) {
		// TODO Auto-generated method stub
		 repository.deleteById(productId);
		 return "Product deleted";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound {
		// TODO Auto-generated method stub
		Optional<Product> optional=  repository.findById(productId);
		if(optional.isPresent()) {
		  return optional.get();
		} else {
			throw new ProductNotFound("Product Id Is Invalid....");
		}
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {
		// TODO Auto-generated method stub
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String Category) {
		// TODO Auto-generated method stub
		return repository.findByProductCategory(Category);
	}

	@Override
	public List<Product> getProductsGraterThanPrice(int price) {
		
		return repository.findByProductPriceGreaterThan(price);
	}

}
