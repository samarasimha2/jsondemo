package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.dto.Albums;
import com.akhm.dto.Photos;
import com.akhm.dto.User;
import com.akhm.service.PhotosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class PhotosServiceImpl implements PhotosService{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Photos> getPhotos() {
		try {

			String jsonString = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class,
					Photos.class);
			List<Photos> photosList = objectMapper.readValue(jsonString, listType);
			return photosList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Photos>();
		}
	}

}
