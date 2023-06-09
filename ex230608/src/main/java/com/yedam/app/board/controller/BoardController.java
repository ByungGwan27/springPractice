package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO vo, Model model) {
		BoardVO find = boardService.getBoardInfo(vo);
		model.addAttribute("board", find);
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO vo) {
		boardService.insertBoardInfo(vo);
		return "redirect:boardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdate(Model model, BoardVO vo) {
		model.addAttribute("board", boardService.getBoardInfo(vo));
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	public String boardUpdate(BoardVO vo, Model model) {
		System.out.println("수정 vo"+vo);
		int result = boardService.updateBoardInfo(vo);
		String res = "";
		
		if(result >= 1) {
			res = "성공";
		} else {
			res = "실패";
		}
		System.out.println(res);
		model.addAttribute("res", res);
		
		
		return "redirect:boardList";
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam int bno) {
		boardService.deleteBoardInfo(bno);//serviceImpl
		return "redirect:boardList";
	}
}
