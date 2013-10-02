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
public class BoardController {
	
	@Autowired
	BoardRepository boardRepository;
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String upload(PhotoBoard photoBoard, MultipartFile file) {
		
		photoBoard.setFilename(FileUploader.upload(file));
		PhotoBoard currentPhotoBoard = boardRepository.save(photoBoard);
		
		return "redirect:/board/"+ currentPhotoBoard.getId();
	}
	
	@RequestMapping("/{id}")
	public String show (@PathVariable Long id, Model model) {
		model.addAttribute(boardRepository.findOne(id));
		return "show";
	}
}
