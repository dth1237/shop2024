package com.tmdt.comtroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tmdt.model.Category;
import com.tmdt.service.CategoryService;

@Controller

@RequestMapping("/admin")
public class categoryController {

	@Autowired
	private CategoryService categoryService;
	@GetMapping("/category")
	public String index(Model model )
	{
		List<Category> list = this.categoryService.getALL();
		model.addAttribute("list",list);
		
		return "admin/category/index";
	}
	@GetMapping("/add-category")
	public String add(Model model)
	{
		Category category = new Category();
		model.addAttribute("category", category);
		
		return "admin/category/add";
	}
	@PostMapping("/add-category")
	public String save(@ModelAttribute("category") Category category)
	{
		if(this.categoryService.create(category))
		{return "redirect:/admin/category";}
		else
		{
			
		
		return "redirect:/admin/category/add";
		}
	}
	@GetMapping("/edit-category/{id}")
	public String edit(Model model,@PathVariable("id") Integer id)
	{
		Category category = this.categoryService.findById(id);
		model.addAttribute("category",category);
		
		return "admin/category/edit";
	}
	@PostMapping("/edit-category")
	public String update(@ModelAttribute("category") Category category)
	{
		if(this.categoryService.create(category))
		{return "redirect:/admin/category";}
		else
		{
			
		
		return "redirect:/admin/category/add";
		}
	}
	@GetMapping("/delete-category/{id}")
	public String delete(@PathVariable("id") Integer id)
	{
		if(this.categoryService.delete(id))
		{return "redirect:/admin/category";}
		else
		{return "redirect:/admin/category";}
		
		
	}
	
	
}
