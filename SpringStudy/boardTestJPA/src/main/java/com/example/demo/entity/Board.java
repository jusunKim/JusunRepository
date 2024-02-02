package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="board")
public class Board {
	private int b_ref;
	private int b_level;
	private int b_step;
	private int hit;
	@Id
	private int no;
	private String regdate;
	private String content;
	private String fname;
	private String id;
	private String pwd;
	private String title;

	@Transient //테이블에서 제외
	private MultipartFile uploadFile; //얘는 넣어야 해서 엔티티에 들어는 가야되는데 테이블에 들어가는 속성은 아니니까
}
