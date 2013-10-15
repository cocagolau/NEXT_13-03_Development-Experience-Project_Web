package org.nhnnext.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.nhnnext.repository.BoardRepository;
import org.nhnnext.support.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/form/{id}")
	public String modify(@PathVariable Long id, Model model) {
		model.addAttribute(boardRepository.findOne(id));
		return "form";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		boardRepository.delete(id);
		return "redirect:/board";
	}
	@RequestMapping("")
	public String list(Model model) {
		List<PhotoBoard> photoBoards = new ArrayList<PhotoBoard>();
		Iterator<PhotoBoard> photoBoardsIterator = boardRepository.findAll().iterator();
		
		while (photoBoardsIterator.hasNext()) {
			photoBoards.add(photoBoardsIterator.next());
		}
		
		model.addAttribute("photoBoards", photoBoards);
		return "boardList";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String upload(PhotoBoard photoBoard, MultipartFile photo) {
		
		Long currentId = photoBoard.getId();
		String currentFilename = FileUploader.upload(photo);
		
		if (currentId != null && currentFilename == null) {
			String newFilename = boardRepository.findOne(currentId).getFilename();
			currentFilename = newFilename;
		}
		
		photoBoard.setFilename(currentFilename);
		boardRepository.save(photoBoard);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/{id}")
	public String show (@PathVariable Long id, Model model) {
		model.addAttribute(boardRepository.findOne(id));
		return "show";
	}
}
