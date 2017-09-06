package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.ProductDAO;
import com.example.entity.Product;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductDAO productDao;

	@GetMapping("list")
	public String getAllProduct(Model product) throws Exception {
		try {
			List<Product> listProduct = productDao.getProduct();
			product.addAttribute("arr", listProduct);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "list_product";
	}

	@GetMapping("/add")
	public String addProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "add_product";
	}

}
