package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("photoBoards", boardRepository.findAll());
		return "main";
	}
}
