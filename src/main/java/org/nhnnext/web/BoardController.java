package org.nhnnext.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String upload(String photo, String article) {
		System.out.println ("photo: " + photo +",  article: " + article);
//		return "form";
		return "redirect:/board/form";
	}
}
