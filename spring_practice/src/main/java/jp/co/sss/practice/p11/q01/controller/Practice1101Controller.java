package jp.co.sss.practice.p11.q01.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1101Controller {
	
	@RequestMapping(path = "/fortune",method = RequestMethod.GET)
    public String fortune(Model model) {
		
		Integer fortuneNum = (int) (Math.floor(Math.random() * 5)+1);
		System.out.println("## Practice1101 ## fortuneNum:"+fortuneNum);
		Date today = new Date();
		
		model.addAttribute("today",today);
		model.addAttribute("fortuneNum",fortuneNum);
		
		return "practice11/01/fortune";
    }
}
