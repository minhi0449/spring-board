package com.sbb.springboot_blog.controller;

import com.sbb.springboot_blog.dto.BoardDTO;
import com.sbb.springboot_blog.entity.Board;
import com.sbb.springboot_blog.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@AllArgsConstructor
//@RequestMapping("/board")
public class boardController {

    private final BoardService boardService;

    // 글 목록
    @GetMapping("/list")
    public String list(Model model){
        log.info("여기는 글 목록 컨트롤러 : 🍀 ");
        List<Board> boards = boardService.list();

        log.info("저장된 글 목록 1: " + boards);
        // Service에서 생성한 리스트를 "board" 이름으로 반환
        model.addAttribute("boards", boards);

        log.info("저장된 글 목록 22 : " + boards);
        return "/list";
    }

    // 글 쓰기
    @GetMapping("/write")
    public String write(){
        log.info("🎈 여기는 글 쓰기 컨트롤러 : GET ");
        return "/write";
    }

    // 글 작성 후 POST 메서드로 글 쓴 내용을 DB에 저장
    @PostMapping("/write")
    public String write(BoardDTO boardDTO){
        log.info("📝 여기는 글 쓰기 컨트롤러 : POST");
        boardService.write(boardDTO);
        log.info("글쓰기 컨트롤러 boardDTO : "+boardDTO);
        return "redirect:/list";
    }

    // 글 보기
    @GetMapping("/view")
    public String view(){
        log.info("어이 GetMapping 글 보기👀 컨트롤러 --> ");
        return "/view";
    }

}
