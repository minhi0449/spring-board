package com.sbb.springboot_blog.dto;

import com.sbb.springboot_blog.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@Builder
public class BoardDTO {

    private Long id; // 게시글 번호

    private String title; // 제목
    private String content; // 내용

    private String writer; // 작성자
    private String creatAt; // 날짜

    // 어디서든지 쓸 수 있어야하니까
    public Board toEntity(BoardDTO boardDTO){
        return Board.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .creatAt(this.creatAt).build();
    }
}
