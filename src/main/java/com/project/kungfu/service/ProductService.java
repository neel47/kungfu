
package com.project.kungfu.service;

import java.util.List;

import com.project.kungfu.model.Product;

public interface ProductService {

	public void addProduct(Product product);

	public List<Product> getAllProducts(String specs, String orderBy);

	public void deleteProduct(Integer productId);

	public Product updateProduct(Product product);

	public Product getProduct(int productid);
}
