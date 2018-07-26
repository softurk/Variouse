package com.project.e_commerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.project.e_commerce.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByBasketId(@Param("id") Integer id);
	
	List<Product> findByProductName(@Param("productName") String productName);
}
