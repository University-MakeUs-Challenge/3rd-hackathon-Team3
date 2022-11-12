package com.example.demo.src.card.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter // 해당 클래스에 대한 접근자 생성
@Setter // 해당 클래스에 대한 설정자 생성
@AllArgsConstructor // 해당 클래스의 모든 멤버 변수(userIdx, nickname, email, password)를 받는 생성자를 생성
public class GetCardRes {

    private String name;
    private String profile_img;
    private String intro; // 이미지 방식 찾기 - TEXT도 string으로 처리.
    private String card_front_img;
    private String card_back_img;
    private int age;
    private String group;
    private String mbti;
    private Date birth;
    private String extra_info;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String status;
    private int is_main;
    private int owner_idx;
    private int maker_idx;
}

