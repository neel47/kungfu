package com.project.kungfu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.kungfu.model.Product;
import com.project.kungfu.model.Student;
import com.project.kungfu.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/ProductCreation")
	public ModelAndView productCreationPage(ModelAndView model, HttpServletRequest request) throws IOException {
		Product product = new Product();
		String sid = request.getSession().getId();
		model.addObject("product", product);
		model.setViewName("productForm");
		return model;
	}

	@RequestMapping(value = "/ProductCreationSave")
	public ModelAndView save(ModelAndView model, @Valid @ModelAttribute("product") Product product, BindingResult result,
			HttpServletRequest request) throws IOException {

		if (result.hasErrors()) {
			System.out.println("Error in Student Controller");
		}
		
		productService.addProduct(product);
		model.setViewName("redirect:/ProductList");
		return model;
	}

	@RequestMapping(value = "/ProductList")
	public ModelAndView productList(ModelAndView model, HttpServletRequest request) throws IOException {

		
		List<Product> productList = productService.getAllProducts("", " PROD_ID desc ");
		String sid = request.getSession().getId();
		model.addObject("productList", productList);
		model.setViewName("productList");
		return model;
	}

	@RequestMapping(value = "/ProductEdit")
	public ModelAndView editProduct(ModelAndView model, HttpServletRequest request) throws IOException {

		int productid = Integer.parseInt(request.getParameter("id"));
		Product product =productService.getProduct(productid);
		String sid = request.getSession().getId();
		model.addObject("product", product);
		model.setViewName("productForm");
		return model;
	}

	@RequestMapping(value = "/ProductDelete")
	public ModelAndView deleteProduct(ModelAndView model, HttpServletRequest request) throws IOException {

		int productId = Integer.parseInt(request.getParameter("id"));
		productService.deleteProduct(productId);
		model.setViewName("redirect:/ProductList");
		return model;
	}

}
