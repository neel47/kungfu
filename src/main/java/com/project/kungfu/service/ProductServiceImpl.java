package com.project.kungfu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kungfu.dao.ProductDAO;
import com.project.kungfu.model.Parent;
import com.project.kungfu.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);
		
	}

	@Override
	public List<Product> getAllProducts(String specs, String orderBy) {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts(specs, orderBy);
	}

	@Override
	public void deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(productId);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(product);
	}

	@Override
	public Product getProduct(int productid) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(productid);
	}

	
	
	

}
