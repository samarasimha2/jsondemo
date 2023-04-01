package com.akhm.dto;

import lombok.Data;

@Data
public class UsersDTO {
	private Integer id;
	private String name;
	private String userName;
	private String email;
	private Address address;
	private Geo geo;
	private String phone;
	private String website;
	private Company company;
	private int postsCount;
	private int commentsCount;
	private int todosCount;
	private int pendingTodosCount;
	private int completedTodosCount;
	private int albumsCount;

}
