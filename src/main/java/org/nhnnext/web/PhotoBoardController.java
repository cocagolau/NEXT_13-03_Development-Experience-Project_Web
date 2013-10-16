package org.nhnnext.web;

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
public class PhotoBoardController {
	
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
		model.addAttribute("photoBoards", boardRepository.findAll());
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
