package org.nhnnext.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/m")
public class MobileController {

	private static final Logger log = LoggerFactory.getLogger(MobileController.class);
	
	@RequestMapping (value="/upload", method=RequestMethod.POST)
	public String upload(String title, String author, String imgName) {
		
		log.info(".upload(): title: " + title + ",  author: " + author + ",  imgName: " + imgName);	
		
		
		return "redirect:/";
	}
	
}
