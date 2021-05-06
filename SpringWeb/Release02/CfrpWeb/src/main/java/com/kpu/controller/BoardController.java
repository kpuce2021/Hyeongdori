package com.kpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



// Controller의 역할 : url을 Mapping 시킨다.

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 실행할 메서드 생성하기
	// String 반환형 : jsp를 만들 String
	// GetMapping : /board 다음에 무엇을 붙여야 되는지 기재하는 것 
	// GetMapping : list()를 호출하려면 어떤 url을 기술해야 하는지를 명시해주는 것 
	@GetMapping("list")
	public String list() {
		System.out.println("BoardController.list()");
		// /WEB-INF/views(servlet에 설정됨) + board/list + .jsp
		return "board/list"; // viewResolver가 가져간다.
	}
	
	
}
