package com.akhm.dto;

import lombok.Data;

@Data
public class Address {
	private String street;
	private String state;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;
	

}
