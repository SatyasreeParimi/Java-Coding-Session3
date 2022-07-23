package com.MicroserviceProduct.ProductService.Controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroserviceProduct.ProductService.Entity.Product;
import com.MicroserviceProduct.ProductService.Repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	 //get all products
	
		@GetMapping
		public List<Product> getAllProducts() {
			
			return this.productRepository.findAll();
			
		}
		
		//get product by ID
		
		@GetMapping("/{id}")
		public Product getProductByID(@PathVariable(value = "id") long id) throws AttributeNotFoundException {
			
			return this.productRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Product not found with given id"+ id));
					
			
		}
		
		//create product
		
		@PostMapping
		public Product creatProduct (@RequestBody Product product) {
			return this.productRepository.save(product);
		}
	

}
