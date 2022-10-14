package com.example.ShoppingCartProduct.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ShoppingCartProduct.entity.Cart;
import com.example.ShoppingCartProduct.entity.Product;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

	@Query("select p from Product p where p.productId=:productId")
	public Product getProductDetails(int productId);

	@Query("select c from Cart c where c.username=:username")
	public List<Cart> getAllProductsBasedOnUsername(String username);
}
