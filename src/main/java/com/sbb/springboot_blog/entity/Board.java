package com.sbb.springboot_blog.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@Builder
@Entity
@Table(name ="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 번호

    // 글자 길이 20자 x, not Null
    @Column(length = 20, nullable = false)
    private String title; // 제목

    // 글자 길이 20자 x, not Null
    @Column(length = 20, nullable = false)
    private String content; // 내용

    private String writer; // 작성자
    private String creatAt; // 날짜

}
