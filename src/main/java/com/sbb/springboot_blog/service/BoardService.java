package com.sbb.springboot_blog.service;

import com.sbb.springboot_blog.dto.BoardDTO;
import com.sbb.springboot_blog.entity.Board;
import com.sbb.springboot_blog.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    날짜 : 2025.01.10 (금)
    이름 : 김민희
    내용 : Board Service 생성
          - 글 목록
          - 글 쓰기
          - 글 보기

    수정 이력 :
 */

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 글 목록
    public List<Board> list(){
        return boardRepository.findAll();
    }

    // 글 쓰기
    public long write(BoardDTO boardDTO){
        // 지금 들어온 건 DTO인데 -> 저장할때 Entity로
        // 이럴 때 ModelMapper를 쓰긴 하는데 이거 실무에서 비추
        // 그래서 직접 toEntity, toDTO 만듬
        Board board = boardDTO.toEntity(boardDTO);
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getId();
    }
    
    
    
}
