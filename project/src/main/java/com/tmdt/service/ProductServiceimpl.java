package com.tmdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdt.model.Category;
import com.tmdt.model.Product;
import com.tmdt.repos.ProductRepository;

@Service
public class ProductServiceimpl implements ProductService{


	@Autowired 
	ProductRepository productRepository;
	public List<Product> getALL() {
		
		return this.productRepository.findAll();
	}

	@Override
	public Boolean create(Product product) {
		try {
			 this.productRepository.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
