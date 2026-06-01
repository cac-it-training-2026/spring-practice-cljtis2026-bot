package jp.co.sss.practice.p05.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0504Controller {
	
	@Autowired
    private FruitsSeasonRepository repository;
	
	@RequestMapping(path = "/fruits/search/input",method = RequestMethod.GET)
    public String fruitsList() {
		return "practice05/04/fruits_select_season";
    }
	
	@RequestMapping(path = "/fruits/search/result",method = RequestMethod.GET)
    public String fruitsDetail(Integer season,Model model) {
		model.addAttribute("fruits", repository.findBySeasonMonthOrderByFruitId(season));
		
		String searchSeason="<"+season+"月>";
		
		if(season==13) {
			searchSeason="<通年>";
		}
		model.addAttribute("searchSeason", searchSeason);
		return "Practice05/04/fruits_list";
    }
}
