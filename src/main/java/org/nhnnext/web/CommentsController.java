package org.nhnnext.web;

import java.util.Iterator;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentsRepository;
import org.nhnnext.repository.SignBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentsController {
	
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private CommentsRepository commentsRepository;
	@Autowired
	private SignBoardRepository signBoardRepository;
	
	@RequestMapping ("/board/comments/{id}/delete")
	public String delete(@PathVariable Long id) {
		commentsRepository.delete(id);
		return "redirect:/";
	}
	
//	@RequestMapping (value="/board/{id}/comments", method=RequestMethod.POST)
//	public String create (@PathVariable Long id, String contents, String sign) {
//		PhotoBoard photoBoard = boardRepository.findOne(id);
//		CommentsBoard commentsBoard = addSignBoard(new CommentsBoard (photoBoard, contents), sign);
//		commentsRepository.save(commentsBoard);
//		
//		return "redirect:/";
//	}
	
	@RequestMapping (value="/board/{id}/test.json", method=RequestMethod.POST)
	public @ResponseBody CommentsBoard createJson (@PathVariable Long id, String contents, String sign) {
		PhotoBoard photoBoard = boardRepository.findOne(id);
		CommentsBoard commentsBoard = addSignBoard(new CommentsBoard (photoBoard, contents), sign);
		
		return commentsRepository.save(commentsBoard);
		
//		CommentsBoard crr = commentsRepository.save(commentsBoard);
//		return crr;
	}
	
	
	@SuppressWarnings("unused")
	private CommentsBoard addSignBoard (CommentsBoard commentsBoard, String sign) {
		SignBoard tempSignBoard = null;
		Iterator<SignBoard> signIr = signBoardRepository.findAll().iterator();
		while (signIr.hasNext()) {
			tempSignBoard = signIr.next();
			if (tempSignBoard.getEmail().equals(sign)) {
				commentsBoard.setSignBoard(tempSignBoard);
				break;
			}
		}
		return commentsBoard;
	}
	
}
