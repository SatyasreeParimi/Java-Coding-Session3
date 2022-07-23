package com.MicroserviceUser.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MicroserviceUser.UserService.Client.UserServiceProxy;
import com.MicroserviceUser.UserService.Model.UserServiceModel;

@RestController
@RequestMapping(value = "/feign")
public class UserServiceController {
	
	
	@Autowired
	private UserServiceProxy userServiceProxy;
	
	@RequestMapping(method = RequestMethod.GET, value = "/allProducts")
	public ResponseEntity<List> productDetails() {
		
	 return ResponseEntity.ok(userServiceProxy.getAllProducts());
	}
	
    @SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/products/{Id}")
    public List<UserServiceModel> findByProductId(@RequestParam(required = false) String Id) {
   
    	return (List<UserServiceModel>) ResponseEntity.ok(userServiceProxy.findProductById(Id));
    }
	/*
	@GetMapping
    public ResponseEntity<Object> productDetails(@RequestParam(required = false) String Id) {
        if (Id == null) {
            return ResponseEntity.ok(userServiceProxy.getAllProducts());
        }
        return ResponseEntity.ok(userServiceProxy.findProductById(Id));
    } */
}
