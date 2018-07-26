package com.project.e_commerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.e_commerce.model.Basket;


@Repository("basketRepository")
public interface BasketRepository extends JpaRepository<Basket, Integer>{

	List<Basket> findByUserId(@Param("id") Integer id);
}
