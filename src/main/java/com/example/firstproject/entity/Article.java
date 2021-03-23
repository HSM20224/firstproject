package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //DB가 해당 객체를 인식 가능
@AllArgsConstructor
@ToString
public class Article {

    @Id //대표값을 지정 | primary key 인듯?
    @GeneratedValue // 1, 2, 3 | auto increment 같은 느낌?
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

}
