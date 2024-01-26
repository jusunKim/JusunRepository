package com.example.demo.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsVO {
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
	private MultipartFile uploadFile; //html파일에서 input type="file"에서의 name이랑 같아야한대 name="uploadFile"
	
	
	
}
