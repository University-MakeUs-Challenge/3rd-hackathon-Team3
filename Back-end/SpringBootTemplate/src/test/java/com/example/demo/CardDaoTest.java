package com.example.demo;

import com.example.demo.src.card.CardDao;
import com.example.demo.src.card.model.GetCardReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class CardDaoTest {
	//@Autowired
	//GetCardReq getCardReq;

	@Test
	void addTest() {
		Timestamp timestamp;
		//CardDao cardDao = new CardDao();


		System.out.println("등록 성공");

	}


}
