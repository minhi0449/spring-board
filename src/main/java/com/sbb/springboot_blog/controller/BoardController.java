package com.sbb.springboot_blog.controller;

import com.sbb.springboot_blog.dto.BoardDTO;
import com.sbb.springboot_blog.entity.Board;
import com.sbb.springboot_blog.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
    날짜 : 2025.01.10 (금)
    이름 : 김민희
    내용 : Board Controller 생성
          - 글 목록
          - 글 작성
          - 글 보기

    수정 이력 :
 */


@Controller
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 글 목록
    @GetMapping("/board/list")
    public String list(Model model){
        log.info("여기는 글 목록 컨트롤러 : 🍀 ");
        List<Board> boards = boardService.list();

        log.info("저장된 글 목록 1: " + boards);
        // Service에서 생성한 리스트를 "board" 이름으로 반환
        model.addAttribute("boards", boards);

        log.info("저장된 글 목록 22 : " + boards);
        return "/board/list";
    }

    // 글 작성
    @GetMapping("/board/write")
    public String write(){
        log.info("🎈 여기는 글 쓰기 컨트롤러 : GET ");
        return "/board/write";
    }

    // 글 작성 후 POST 메서드로 글 쓴 내용을 DB에 저장
    @PostMapping("/board/write")
    public String write(BoardDTO boardDTO){
        log.info("📝 여기는 글 쓰기 컨트롤러 : POST");
        boardService.insertBoard(boardDTO);
        log.info("글쓰기 컨트롤러 boardDTO : "+ boardDTO);
        return "redirect:/board/list";
    }

    // 글 보기
    @GetMapping("/board/view")
    public String view(Long id, Model model){
        log.info("어이 GetMapping 글 보기👀 컨트롤러 --> ");
        log.info("클릭 된 글 id : "+ id);
        log.info("📌 [GET] /board/view - 요청된 게시글 ID: {}", id);

        BoardDTO boardDTO = boardService.selectBoard(id);
        model.addAttribute("boardDTO", boardDTO);


        return "/board/view";
    }

    // 글 보기 (설명)
    // 1. 사용자가 웹브라우저에세 /board/view 로 요청을 보내면, view 컨트롤러가 실행됨!
    // 2. @GetMapping 은 "GET 방식의 요청을 처리 할거야" 라는 뜻 (미니 이건 알제?)
    // 비유 : 이건 마치 " 이 도로를 지나가는 모든 차(요청)를 여기서 검사하겠다" 라고 지정한 신호등 같은 거

    // 3-1. id : 사용자가 [ ?id=3 ] 이렇게 보낸 값을 받음.
    // 3-2. Model model : 화면(view)에게 데이터를 넘겨주는 역할 (aka. 데이터를 담는 그릇)
    // 비유 : id 는 식당에서 주문번호 (몇 번 테이블인지@!)
    //       model 은 요리사가 요리를 담아서 -> 웨이터에게 전달하는 쟁반 (쟁반 ^^,,)

    // 4. 서비스(boardService)에서 id에 맞는 게시글 데이터를 가져옴
    // 4-1. BoardDTO 는 DB 에서 꺼낸 Board 엔티티를 가공한 객체

    // 비유 : 이건 주방장이 주문번호 (3번 테이블)를 보고, 해당 요리를 만드는 과정!
    // 개념 : DTO(Data Transfer Object) -> 데이터를 안전하게 주고받기 위해 사용하는 객체
    //                                 -> 데이터베이스 (Entity) 와 직접 연결되는 걸 막아줌

    // model.addAttribute("boardDTO", boardDTO);
    // boardDTO 데이터를 model 에 넣어서 뷰 (HTML)에서 사용할 수 있게 함
    // 즉, 화면이 boardDTO 데이터를 받아서 게시글 내용을 보여줄 수 있음

    // 이건 요리사가 요리를 쟁반(Model)에 올려서 웨이터(View)에게 전달하는 것!
    




}
