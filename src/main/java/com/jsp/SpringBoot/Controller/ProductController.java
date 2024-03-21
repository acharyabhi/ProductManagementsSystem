package com.jsp.SpringBoot.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SpringBoot.Entity.Product;
import com.jsp.SpringBoot.Service.ProductService;
import com.jsp.SpringBoot.Utility.ResponseStructure;

@RestController
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	public ResponseEntity<ResponseStructure<Product>> findProduct(int productId){
		return productService.findProduct(productId);
	}
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId, @RequestParam Product product){
		return productService.updateProduct(productId,product);
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct(){
		return productService.findAllProduct();
	}
	

}
