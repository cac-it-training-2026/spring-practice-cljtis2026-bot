package jp.co.sss.practice.p10.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1001Controller {

	@RequestMapping(path = "/filter/def",method = RequestMethod.GET)
    public String showFilterDef() {

		return "practice10/01/filter_view";
    }
	
	@RequestMapping(path = "/filter/xyz",method = RequestMethod.GET)
    public String showFilterXyz() {

		return "practice10/01/filter_redirect";
    }
}
