
package com.project.kungfu.dao;

import java.util.List;

import com.project.kungfu.model.Product;

public interface ProductDAO {

	public void addProduct(Product product);

	public List<Product> getAllProducts(String specs, String orderBy);

	public void deleteProduct(Integer productId);

	public Product updateProduct(Product product);

	public Product getProduct(int productid);
}
