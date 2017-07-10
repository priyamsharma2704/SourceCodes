package com.feedback;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String home(){
		return "index.jsp";
	}
	
	@RequestMapping("/feedback")
	public String feedback(){
		return "feedback.html";
	}
	
	

}
