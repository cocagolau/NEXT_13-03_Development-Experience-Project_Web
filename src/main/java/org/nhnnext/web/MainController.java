package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	CommentsRepository commentsRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		log.info("in MainController - index");
		model.addAttribute("photoBoards", boardRepository.findAll());
		return "main";
	}
}
