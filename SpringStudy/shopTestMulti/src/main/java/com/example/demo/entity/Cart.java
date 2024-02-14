package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cart")
@SequenceGenerator(name="SEQ_CART_GEN", sequenceName = "SEQ_CART", initialValue = 1, allocationSize = 1) //이름, 시퀀스이름, 초기값, 간격
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CART_GEN")
	private int no;
	private String id;
	private int gno;
	private int qty;

}
