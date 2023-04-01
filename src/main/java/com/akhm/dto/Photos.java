package com.akhm.dto;

import lombok.Data;

@Data
public class Photos {
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String thumbNailUrl;

}
