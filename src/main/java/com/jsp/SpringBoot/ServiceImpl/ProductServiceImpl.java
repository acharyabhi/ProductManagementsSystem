package com.jsp.SpringBoot.ServiceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.SpringBoot.Entity.Product;
import com.jsp.SpringBoot.Repository.ProductRepo;
import com.jsp.SpringBoot.Service.ProductService;
import com.jsp.SpringBoot.Utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepo productRepo;
	
	private ResponseStructure<Product> structure;
	
	public ProductServiceImpl(ProductRepo productRepo,ResponseStructure<Product> structure) {
		super();
		this.productRepo = productRepo;
		this.structure = structure;
	}
	
	@Override
	public ResponseEntity<ResponseStructure<Product>> findProduct(int productId) {
		return productRepo.findById(productId).map(product -> ResponseEntity.ok(
				structure.setStatus(HttpStatus.OK.value())
				.setMessage("Product Found")
				.setData(product)
				))
				.orElseThrow(()-> new RuntimeException());
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId, Product product) {
		return productRepo.findById(productId).map(exproduct -> {
			product.setProductId(exproduct.getProductId());
			exproduct = productRepo.save(product);
			return ResponseEntity.ok(structure.setStatus(HttpStatus.OK.value())
					.setMessage("Product Update")
					.setData(exproduct));
		})
		.orElseThrow(()-> new RuntimeException());
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		List<Product> products=productRepo.findAll();
		if(!products.isEmpty()) {
			return ResponseEntity.ok(
					structure.setStatus(HttpStatus.OK.value())
					.setMessage("All Product")
					.setData(products)
					);		
		}else throw new RuntimeException();
	}

}
