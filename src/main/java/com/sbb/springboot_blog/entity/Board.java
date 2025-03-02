package com.sbb.springboot_blog.entity;

import jakarta.persistence.*;
import lombok.*;

/*
    날짜 : 2025.01.10 (금)
    이름 : 김민희
    내용 : Spring Boot 익명게시판 Entity 클래스 구현

    수정 이력:
    - 2025.03.02 (일) 김민희 - Lombok 어노테이션 리팩토링 (@Getter, @Setter, @ToString을 @Data로 통합)
 */

// lombok : 반복적인 코드 (getter, setter 등)를 자동 생성해주는 라이브러리
@Data
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 자동으로 생성 | ex: new Board(id, title, content, writer, createAt)
@NoArgsConstructor // 기본 생성자 (parameter 가 없는 기본 생성자 생성) JPA -> Entity 클래스에서 기본생성자 필수
@Builder // 빌더 패턴을 위한 코드를 자동 생성, 객체 생성할 때, 메서드 체이닝 방식으로 필드 값을 설정할 수 있게 해줌
// 예: Board.builder().title("제목").content("내용").build()
@Entity // 이 클래스가 JPA 엔티티 임을 나타냅니다.
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
