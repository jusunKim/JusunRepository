package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payment;

import jakarta.transaction.Transactional;

@Repository
public interface PayDAO extends JpaRepository<Payment, String> {
	
	/*불필요
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(
	 * value="insert into payment(imp_uid,merchant_uid,paid_amount,apply_num) values(:#{#p.imp_uid},:#{#p.merchant_uid},:#{#p.paid_amount},:#{#p.apply_num})"
	 * , nativeQuery = true) public void insertPay(Payment p);
	 */
}