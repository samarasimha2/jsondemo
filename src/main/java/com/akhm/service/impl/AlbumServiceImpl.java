package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.Albums;
import com.akhm.dto.Comments;
import com.akhm.dto.User;
import com.akhm.service.AlbumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class AlbumServiceImpl implements AlbumService{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Albums> getAlbums() {
		try {

			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
					Albums.class);
			List<Albums> albumsList = objectMapper.readValue(jsonString, listType);
			return albumsList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Albums>();
		}
	}

}
