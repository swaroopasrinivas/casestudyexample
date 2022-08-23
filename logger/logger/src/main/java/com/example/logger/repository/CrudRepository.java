package com.example.logger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.logger.entity.Product;

public interface CrudRepository extends JpaRepository<Product, Integer>{

}
