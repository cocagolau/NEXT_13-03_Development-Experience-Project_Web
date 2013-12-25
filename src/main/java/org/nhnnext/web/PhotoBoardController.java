package org.nhnnext.web;

import java.util.Iterator;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.repository.CommentsRepository;
import org.nhnnext.repository.SignBoardRepository;
import org.nhnnext.support.FileUploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class PhotoBoardController {
	
	private static final Logger log = LoggerFactory
			.getLogger(PhotoBoardController.class);
	
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	SignBoardRepository signBoardRepository;
	@Autowired
	CommentsRepository commentsRepository;
	
	@RequestMapping("/writing")
	public String form() {
		return "writingForm";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		Iterator<CommentsBoard> ir = commentsRepository.findAll().iterator();
		CommentsBoard currCommentsBoard = null;
		while (ir.hasNext()) {
			currCommentsBoard = ir.next();
			if (currCommentsBoard.getPhotoBoard().getId() == id) {
				commentsRepository.delete(currCommentsBoard);
			}
		}
		boardRepository.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping("/modify/{id}")
	public String modifyForm(@PathVariable Long id, Model model) {
		model.addAttribute(boardRepository.findOne(id));
		return "modifyForm";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(PhotoBoard photoBoard, String sign, MultipartFile photo) {
		photoBoard = addSignBoard(photoBoard, sign);	
		String currentFilename = FileUploader.upload(photo);
		if (currentFilename == null) {
			currentFilename = boardRepository.findOne(photoBoard.getId()).getFilename();
		}		
		
		photoBoard.setFilename(currentFilename);
		boardRepository.save(photoBoard);
		return "redirect:/";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(PhotoBoard photoBoard,String sign, MultipartFile photo) {		
		photoBoard = addSignBoard(photoBoard, sign);
		photoBoard.setFilename(FileUploader.upload(photo));
		boardRepository.save(photoBoard);
//		log.debug("((((((((((((((((board : {}", photoBoard);
		
		return "redirect:/";
	}
	
	@SuppressWarnings("unused")
	private PhotoBoard addSignBoard (PhotoBoard photoBoard, String sign) {
		SignBoard tempSignBoard = null;
		Iterator<SignBoard> signIr = signBoardRepository.findAll().iterator();
		while (signIr.hasNext()) {
			tempSignBoard = signIr.next();
			if (tempSignBoard.getEmail().equals(sign)) {
				photoBoard.setSignBoard(tempSignBoard);
				break;
			}
		}
		return photoBoard;
	}
	
//	@RequestMapping(value="", method=RequestMethod.POST)
//	public String upload(PhotoBoard photoBoard, MultipartFile photo) {		
//		Long currentId = photoBoard.getId();
//		String currentFilename = FileUploader.upload(photo);
//		
//		if (currentId != null && currentFilename == null) {
//			String newFilename = boardRepository.findOne(currentId).getFilename();
//			currentFilename = newFilename;
//		}
//		
//		String sign = photoBoard.getSign();
//		Iterator<SignBoard> signIr = signBoardRepository.findAll().iterator();
//		SignBoard tempSignBoard;
//		while (signIr.hasNext()) {
//			tempSignBoard = signIr.next();
//			if (tempSignBoard.getEmail().equals(sign)) {
//				photoBoard.setSignBoard(tempSignBoard);
//				break;
//			}
//		}
//		
//		
//		photoBoard.setFilename(currentFilename);
//		boardRepository.save(photoBoard);
//		
//		return "redirect:/board";
//	}
//	
//	@RequestMapping("/{id}")
//	public String show (@PathVariable Long id, Model model) {
//		PhotoBoard photoBoard = boardRepository.findOne(id);
//		model.addAttribute(photoBoard);
//		return "show";
//	}
//	
//	@RequestMapping("")
//	public String list(Model model) {
//		model.addAttribute("photoBoards", boardRepository.findAll());
//		return "boardList";
//	}
}
