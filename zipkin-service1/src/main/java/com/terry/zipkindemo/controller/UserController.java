package com.terry.zipkindemo.controller;

import java.util.ArrayList;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import com.terry.zipkindemo.model.Item;
import com.terry.zipkindemo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public List<User> getUsers(@PathVariable String name){
		logger.info("User service "+name);
		
		List<User> usersList = new ArrayList<User>();
		
		List<Item> itemList = (List<Item>)restTemplate.exchange("http://localhost:8082/users/"+name+"/items"
										,HttpMethod.GET,null
										,new ParameterizedTypeReference<List<Item>>() {}).getBody();
		usersList.add(new User(name,"myemail@mygoogle.com",itemList));
				
		return usersList;
	}

}
