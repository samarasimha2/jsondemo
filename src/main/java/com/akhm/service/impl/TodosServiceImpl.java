package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.Todos;
import com.akhm.dto.User;
import com.akhm.service.TodosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class TodosServiceImpl implements TodosService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Todos> getTodos() {
		try {

			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
					Todos.class);
			List<Todos> todosList = objectMapper.readValue(jsonString, listType);
			return todosList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Todos>();
		}
	}

}
