package com.MicroserviceUser.UserService.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MicroserviceUser.UserService.Model.UserServiceModel;

@FeignClient(name = "product-service", url="http://localhost:8080/")
public interface UserServiceProxy{
	
	@RequestMapping(method = RequestMethod.GET, value = "/products")
    List<UserServiceModel> getAllProducts();
    @RequestMapping(method = RequestMethod.GET, value = "/products/{Id}")
    UserServiceModel findProductById(@PathVariable("Id") String Id);

}
