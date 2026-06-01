package jp.co.sss.practice.p11.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1102Controller {
	
	@RequestMapping(path = "/checkbox/input",method = RequestMethod.GET)
    public String checkboxInput() {

		return "practice11/02/checkbox_input";
    }
	
	@RequestMapping(path = "/checkbox/result",method = RequestMethod.POST)
    public String checkboxResult(Model model , String[] destPrefs) {
		model.addAttribute("destPrefs",destPrefs);
		return "practice11/02/result";
    }
}
