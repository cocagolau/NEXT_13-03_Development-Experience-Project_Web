package org.nhnnext.web;

import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nhnnext.repository.SignBoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.CookieGenerator;

@Controller
@RequestMapping("/sign")
public class SignController {
	
	private static final Logger log = LoggerFactory.getLogger(SignController.class);
	
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
		log.info("sign - email: " + signInEmail + ",  password: " + signInPassword);
		
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
	
	
	// mobile
	
	@RequestMapping(value="/m/in", method=RequestMethod.POST)
	public @ResponseBody boolean mSignIn(String signInEmail, String signInPassword, HttpSession session, HttpServletResponse response) {
		log.info("sign - email: " + signInEmail + ",  password: " + signInPassword);
		
		Iterator<SignBoard> signsIr = signBoardRepository.findAll().iterator();
		SignBoard tempSign;
		
		while (signsIr.hasNext()) {
			tempSign = signsIr.next();
			if(signInEmail.equals(tempSign.getEmail())) {
				if (signInPassword.equals(tempSign.getPassword())) {
					
					CookieGenerator cookieGer = new CookieGenerator();
					cookieGer.setCookieName("JSESSIONID");
					log.info("cookieName: " + cookieGer.getCookieName());
					
					return true;
				}
				return false;
			}
		}
		return false;
	}
	
	@RequestMapping(value="/m",method=RequestMethod.POST)
	public @ResponseBody boolean mSignUp (SignBoard sign) {
		log.info("sign - name: + " + sign.getName() + ",  email: " + sign.getEmail() + ",  password: " + sign.getPassword());
//		signBoardRepository.save(sign);
		return true;
	}

}
