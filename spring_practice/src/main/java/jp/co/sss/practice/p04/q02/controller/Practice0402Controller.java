package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {

	@RequestMapping(path = "/numguess/start",method = RequestMethod.GET)
    public String start(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		System.out.println("[動作確認] 生成された数値: " + hitNumber);
		session.setAttribute("hitNumber", hitNumber);
		return "practice04/02/numguess_start";
    }
	
	@RequestMapping(path = "/numguess/input",method = RequestMethod.GET)
    public String input() {
		return "practice04/02/numguess_input";
    }
	
	@RequestMapping(path = "/numguess/judge",method = RequestMethod.GET)
    public String judge(HttpSession session,Integer inputNum) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		if (hitNumber == null) {

	        return "redirect:/numguess/start";
	    }
	    
	    if (inputNum == null) {
	       
	        return "practice04/02/numguess_judge"; 
	    }
		if (hitNumber.equals(inputNum)) {
            
            return "redirect:/numguess/hit";
            
        } else {
         
            return "practice04/02/numguess_judge";
        }
    }
	
	@RequestMapping(path = "/numguess/hit",method = RequestMethod.GET)
	public String hitNum(Model model,HttpSession session) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		String message = "当たりです！ 正解は" + hitNumber + "でした。";
		model.addAttribute("message", message);
		session.removeAttribute("hitNumber");
		return "practice04/02/numguess_end";
    }
}
