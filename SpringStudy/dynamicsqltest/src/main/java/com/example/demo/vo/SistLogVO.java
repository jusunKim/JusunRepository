package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //매개변수 있는 생성자 만들어줘 라는 뜻-> 기본생성자 없겟찌
@NoArgsConstructor //기본생성자도 만들어줘
public class SistLogVO {
	private int no;
	private String uri;
	private String ip;
	private String method;
	private String time;
	private int delay;
}
