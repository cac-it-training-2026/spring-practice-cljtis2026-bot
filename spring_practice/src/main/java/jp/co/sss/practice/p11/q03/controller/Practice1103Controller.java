package jp.co.sss.practice.p11.q03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1103Controller {
	
	@RequestMapping(path = "/layout/first",method = RequestMethod.GET)
    public String first() {

		return "practice11/03/first";
    }
	@RequestMapping(path = "/layout/second",method = RequestMethod.GET)
    public String second() {

		return "practice11/03/second";
    }
	@RequestMapping(path = "/layout/third",method = RequestMethod.GET)
    public String third() {

		return "practice11/03/third";
    }
}
