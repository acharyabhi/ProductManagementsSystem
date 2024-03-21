package com.jsp.SpringBoot.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.SpringBoot.Entity.Product;
import com.jsp.SpringBoot.Utility.ResponseStructure;
@Service
public interface ProductService {

	ResponseEntity<ResponseStructure<Product>> findProduct(int productId);

	ResponseEntity<ResponseStructure<Product>> updateProduct(int productId, Product product);

	ResponseEntity<ResponseStructure<List<Product>>> findAllProduct();

	

}
