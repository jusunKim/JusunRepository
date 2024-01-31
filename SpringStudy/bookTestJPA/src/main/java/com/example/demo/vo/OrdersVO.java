package com.example.demo.vo;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class OrdersVO {

	@Id
	private int orderid;
	
	@ManyToOne //내가 many. 저쪽이 one(내 custid는 여기서 많이나올수있고 저 테이블에서는 하나만있으니까)
	@JoinColumn(name="custid", insertable= true, updatable=true)
	private CustomerVO customer;
	
	@ManyToOne
	@JoinColumn(name="bookid", insertable=true, updatable = true)
	private BookVO book;
	
	private int saleprice;
	private String orderdate;
}
