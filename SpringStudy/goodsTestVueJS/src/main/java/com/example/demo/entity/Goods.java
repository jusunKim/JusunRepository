package com.example.demo.entity;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data //뭔가 동작이 안되면 @Setter @Getter로 하기
@Entity
@Table(name="goods")
public class Goods {
	@Id
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
	
	
}
