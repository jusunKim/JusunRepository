package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	public String imp_uid;
	public String merchant_uid;
	public int paid_amount;
	public String apply_num;
	
}
