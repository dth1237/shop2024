package com.tmdt.service;

import java.util.List;

import com.tmdt.model.Category;

public interface CategoryService {
	List<Category> getALL();
	Boolean create(Category category);
	Category findById(Integer id);
	Boolean update(Category category);
	Boolean delete(Integer id);
	

}
