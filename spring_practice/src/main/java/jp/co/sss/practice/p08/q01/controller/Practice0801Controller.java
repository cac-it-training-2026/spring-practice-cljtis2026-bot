package jp.co.sss.practice.p08.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.practice.p08.q01.form.BodyTempForm;

@Controller
public class Practice0801Controller {
	
	@RequestMapping(path = "/body_temp/input",method = RequestMethod.GET)
    public String inputBodyTemp(@ModelAttribute BodyTempForm bodyTempForm) {

		return "practice08/01/bt_input";
    }
	
	@RequestMapping(path = "/body_temp/check",method = RequestMethod.POST)
    public String checkBodyTemp(@Valid @ModelAttribute BodyTempForm bodyTempForm, 
    		BindingResult result) {
		
		if (result.hasErrors()) { 
			return "practice08/01/bt_input";  
			}
		Double bt =bodyTempForm.getBodyTemp();
		if (35.0 < bt && bt < 37.5) {
			return "practice08/01/bt_ok";
		} else {
			return "practice08/01/bt_ng";
		}
    }
}
