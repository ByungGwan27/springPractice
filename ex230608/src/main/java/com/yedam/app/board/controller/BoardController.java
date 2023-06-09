package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	//controller에선 mapper를 직접적으로 사용X. 교육에서만 누락
	@Autowired BoardService boardService;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
//	@GetMapping("boardList")
//	public String boardList(Model model) {
//		model.addAttribute("boardList", boardService.getBoardList());
//		return "board/boardList";
//	}
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();//변수를 선언하지 않으면 'getBoardList'가 정확히 뭘 return하는지 모르기 때문에 나눴음. 위에처럼 해도 상관 없음
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO vo, Model model) {//command or reqparam 둘 다 상관 없음
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
//	public String boardInsert(BoardVO vo) {
//		boardService.insertBoardInfo(vo);
//		return "redirect:boardList";
//	}
	public String boardInsert(BoardVO vo, Model model) {
		boardService.insertBoardInfo(vo);
		return "redirect:boardList";
	}
	
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
//	public String boardUpdate(Model model, BoardVO vo) {
//		model.addAttribute("board", boardService.getBoardInfo(vo));
//		return "board/boardUpdate";
//	}
	public String boardUpdate(Model model, BoardVO vo) {
		BoardVO findVO = boardService.getBoardInfo(vo);
		model.addAttribute("board", findVO);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	@ResponseBody
//	public String boardUpdate(BoardVO vo, Model model) {
//		System.out.println("수정 vo"+vo);
//		int result = boardService.updateBoardInfo(vo);
//		String res = "";
//		
//		if(result >= 1) {
//			res = "성공";
//		} else {
//			res = "실패";
//		}
//		System.out.println(res);
//		model.addAttribute("res", res);
//		
//		
//		return "redirect:boardList";
//	}
	public Map<String, Object> boardUpdate(BoardVO vo) {//comand속성의 필드 값이 jsp의 'name'과 일치 해야 함
		boolean result = false;
		int boardNo = boardService.updateBoardInfo(vo);
		
		if(boardNo > -1) {//음수 값은 '>', '<'을 사용. 순수하게 -1이 아닐때만 -1 != 사용하는게 더 좋음
			result = true;
		}
		Map <String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("board_no", boardNo);
		
		return map;
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	//RequestParam은 사용하는 순간 데이터가 무조건 있어야 함.
	public String boardDelete(@RequestParam(required = false,// 필수 여부.
											defaultValue = "0",//값이 정상적으로 넘어 오지 않았을때 가질 매개변수 값(기본은 null(String))
											name="bno"//name 지정
											) int bno) {//사용 할 땐 3가지 정도 사용하는것이 좋음
		boardService.deleteBoardInfo(bno);//serviceImpl
		return "redirect:boardList";
	}
}
