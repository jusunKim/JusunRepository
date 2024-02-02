package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Board;

import jakarta.transaction.Transactional;

public interface BoardDAO extends JpaRepository<Board,Integer> {

	@Modifying
	@Transactional
	@Query(value = "insert into board(b_level,b_ref,b_step,hit,no,regdate,content,fname,id,pwd,title) values(:#{#b.b_level},:#{#b.b_ref},:#{#b.b_step},0,:#{#b.no},sysdate,:#{#b.content},:#{#b.fname},:#{#b.id},:#{#b.pwd},:#{#b.title})", nativeQuery = true)
	public void insert(Board b);
	
	@Query(value = "select nvl(max(no),0)+1 from board", nativeQuery = true)
	public int getNextNo();
	
	@Modifying
	@Transactional
	@Query(value="update board set b_step=b_step+1 where b_ref=?1 and b_step>?2", nativeQuery = true)
	public int updateStep(int b_ref, int b_step);

	@Query(value="select * from board order by b_ref desc, b_step", nativeQuery = true)
	public List<Board> selectAll();
}
