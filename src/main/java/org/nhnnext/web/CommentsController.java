package org.nhnnext.web;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentsController {
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CommentsRepository commentsRepository;
	
	@RequestMapping (value="/board/{id}/comments", method=RequestMethod.POST)
	public String create (@PathVariable Long id, String contents) {
		PhotoBoard photoBoard = boardRepository.findOne(id);
		CommentsBoard commentsBoard = new CommentsBoard (photoBoard, contents);
		commentsRepository.save(commentsBoard);

		
		return "redirect:/";
	}
}
