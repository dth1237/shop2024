package com.tmdt.service;

import java.util.List;

import com.tmdt.model.Category;
import com.tmdt.model.Product;

public interface ProductService {

	List<Product> getALL();
	Boolean create(Product product);
	Category findById(Integer id);
	Boolean update(Product product);
	Boolean delete(Integer id);
	
}
