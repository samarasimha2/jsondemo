package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.Comments;
import com.akhm.dto.Posts;
import com.akhm.dto.User;
import com.akhm.service.CommentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class CommentsServiceImpl implements CommentsService{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Comments> getComments() {
		try {

			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
					Comments.class);
			List<Comments> commentsList = objectMapper.readValue(jsonString, listType);
			return commentsList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Comments>();
		}
	}

}
