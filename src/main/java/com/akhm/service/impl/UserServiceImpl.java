package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.User;
import com.akhm.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class UserServiceImpl implements UserService{
	@Autowired(required = false)
	private RestTemplate restTemplate;

	@Override
	public List<User> getUsers() {
		try {
			
			String jsonString=restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", String.class);
			ObjectMapper objectMapper=new ObjectMapper();
			CollectionType listType=objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
			List<User> userList=objectMapper.readValue(jsonString, listType);
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<User>();
		}
		
	
		
	}

}
