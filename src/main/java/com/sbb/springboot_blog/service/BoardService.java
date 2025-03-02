package com.sbb.springboot_blog.service;

import com.sbb.springboot_blog.dto.BoardDTO;
import com.sbb.springboot_blog.entity.Board;
import com.sbb.springboot_blog.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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
@Log4j2
public class BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    // 글 목록
    public List<Board> list(){
        return boardRepository.findAll();
    }

    // 글 쓰기
    public long insertBoard(BoardDTO boardDTO){
        log.info("글쓰기 write() / 서비스로 들어오는 boardDTO :" + boardDTO);

        // 지금 들어온 건 DTO 인데 -> 저장할때 Entity 로
        // 이럴 때 ModelMapper를 쓰긴 하는데 이거 실무에서 비추
        // 그래서 직접 toEntity, toDTO 만듬
        Board board = boardDTO.toEntity(boardDTO);
        Board savedBoard = boardRepository.save(board);
        return savedBoard.getId();


    }

    // 글 상세보기
    public BoardDTO selectBoard(Long id) {

        log.info("여기는 서비스 id : " + id);

//        Optional<Board> board = boardRepository.findById(id);
//        if (board.isPresent()){
//            return modelMapper.map(board.get(), Board.class);
//        }else {
//            // 값이 없으면 예외 발생
//            throw new RuntimeException("게시글 번호를 찾을 수 없습니다." + id);
//        }

         Board board = boardRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("게시글 번호를 찾을 수 없습니다." + id));
         return modelMapper.map(board, BoardDTO.class);

    }
}
