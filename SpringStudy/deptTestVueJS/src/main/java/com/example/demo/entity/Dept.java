package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data //뭔가 동작이 안되면 @Setter @Getter로 하기
@Entity
@Table(name="dept")
public class Dept {
	@Id
	private int dno;
	private String dname;
	private String dloc;
	private String fname;
	
	@Transient
	private MultipartFile uploadFile;
}
