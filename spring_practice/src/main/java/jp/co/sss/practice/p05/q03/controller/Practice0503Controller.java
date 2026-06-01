package jp.co.sss.practice.p05.q03.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0503Controller {
	
	@Autowired
    private FruitsSeasonRepository repository;
	
	@RequestMapping(path = "/fruits/list/sort/id",method = RequestMethod.GET)
    public String fruitsList(Model model) {
		model.addAttribute("fruits", repository.findAllByOrderByFruitId());
		return "practice05/03/fruits_list";
    }
	
	@RequestMapping(path = "/fruits/detail/{fruitId}",method = RequestMethod.GET)
    public String fruitsDetail(@PathVariable Integer fruitId,Model model) {
		FruitsSeason fruit = repository.getReferenceById(fruitId);
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruit, fruitBean);

		model.addAttribute("fruit", fruitBean);
		return "Practice05/03/fruit_detail";
    }
}
