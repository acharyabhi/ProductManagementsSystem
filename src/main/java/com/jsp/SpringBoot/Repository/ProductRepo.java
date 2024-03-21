package com.jsp.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.SpringBoot.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
