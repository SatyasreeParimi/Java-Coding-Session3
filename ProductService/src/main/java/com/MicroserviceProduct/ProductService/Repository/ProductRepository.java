package com.MicroserviceProduct.ProductService.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MicroserviceProduct.ProductService.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


	
	

}
