package com.tmdt.comtroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tmdt.model.Category;
import com.tmdt.model.Product;
import com.tmdt.service.CategoryService;
import com.tmdt.service.ProductService;
import com.tmdt.service.StorageService;

@Controller
@RequestMapping("/admin")
public class productcontroller {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private StorageService storageService;
	

	@Autowired
	private ProductService productService;

	@RequestMapping("/product")
	public String index(Model model)
	{
	List<Product> listCategory = this.productService.getALL();
	model.addAttribute("listCategory",listCategory);
	
	
		
		
		return"admin/product/index";
	}
	@RequestMapping("/product-add")
	public String add(Model model)
	{
		Product product =new Product();
		model.addAttribute("product",product);
		
		List<Category> listCate = this.categoryService.getALL();
		model.addAttribute("listCate",listCate);
		return "admin/product/add";
	}
	@PostMapping("/product-add")
	public String save(@ModelAttribute("product") Product product,@RequestParam("fileImage") MultipartFile file)
	{
		this.storageService.store(file);
		String filename = file.getOriginalFilename();
		product.setImage(filename);
		if(this.productService.create(product))
		{
			return "redirect:/admin/product";
		}
		
		return "/admin/product/add";
		
	}
}

