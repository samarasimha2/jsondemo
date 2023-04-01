package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.Posts;
import com.akhm.dto.Todos;
import com.akhm.dto.User;
import com.akhm.service.PostsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class PostsServiceImpl implements PostsService{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Posts> getPosts() {
		try {

			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
					Posts.class);
			List<Posts> postsList = objectMapper.readValue(jsonString, listType);
			return postsList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Posts>();
		}
	}
	

}
