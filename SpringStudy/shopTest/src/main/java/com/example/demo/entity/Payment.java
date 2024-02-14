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
	private int no;
	private String pay_method;
	public String merchant_uid;
	public String name;
	public int amount;
	public String buyer_email;
	public String buyer_name;
	public String buyer_tel;
	public String buyer_addr;
	public String buyer_postcode;
	public String imp_uid;
	public String apply_num;
	public String buyer_id;

}
