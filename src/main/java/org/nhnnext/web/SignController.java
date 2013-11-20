package org.nhnnext.web;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nhnnext.repository.SignBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sign")
public class SignController {
	@Autowired
	private SignBoardRepository signBoardRepository;
	
	
	@RequestMapping("/up")
	public String signUp () {
		return "signUpForm";
	}
	@RequestMapping("/out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userEmail");
		return "redirect:/";
	}
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	public @ResponseBody boolean verify (String value) {
		SignBoard tempSignBoard = null;
		boolean flag = false;
		Iterator<SignBoard> ir = signBoardRepository.findAll().iterator();
		while (ir.hasNext()) {
			tempSignBoard = ir.next();
			if (tempSignBoard.getEmail() == value) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	@RequestMapping(value="/in", method=RequestMethod.POST)
	public String signIn(String signInEmail, String signInPassword, HttpSession session) {
		
		Iterator<SignBoard> signsIr = signBoardRepository.findAll().iterator();
		SignBoard tempSign;
		
		while (signsIr.hasNext()) {
			tempSign = signsIr.next();
			if(signInEmail.equals(tempSign.getEmail())) {
				if (signInPassword.equals(tempSign.getPassword())) {
					session.setAttribute("userEmail", tempSign.getEmail());
					session.setAttribute("userName", tempSign.getName());
					return "redirect:/";
				}
				return "signInFailure";
			}
		}
		return "signInFailure";
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String signUp (SignBoard sign) {
		signBoardRepository.save(sign);
		return "redirect:/";
	}

}
