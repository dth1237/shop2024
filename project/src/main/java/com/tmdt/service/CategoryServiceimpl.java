package com.tmdt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdt.model.Category;
import com.tmdt.repos.CategoryRepository;

@Service
public class CategoryServiceimpl implements CategoryService{

	@Autowired 
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getALL() {
		
		
		return categoryRepository.findAll();
	}

	@Override
	public Boolean create(Category category) {

		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Category findById(Integer id) {

		return categoryRepository.findById(id).get();
	}

	@Override
	public Boolean update(Category category) {

		try {
			this.categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			this.categoryRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}

	
	
	

}
