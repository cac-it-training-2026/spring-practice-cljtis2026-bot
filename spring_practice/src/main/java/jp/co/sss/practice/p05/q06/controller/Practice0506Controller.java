package jp.co.sss.practice.p05.q06.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {
	
	@Autowired
    private FruitsSeasonRepository repository;
	
	@RequestMapping(path = "/fruits/update",method = RequestMethod.GET)
    public String fruitsSelect(Model model) {
		model.addAttribute("fruits",repository.findAllByOrderByFruitId());
		return "practice05/06/fruit_select";
    }
	
	@RequestMapping(path = "/fruits/update/input",method = RequestMethod.POST)
    public String fruitsInput(Integer fruitId , Model model) {
		FruitsSeason fruit = repository.getReferenceById(fruitId);
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruit, fruitBean);
		model.addAttribute("fruit", fruitBean);
		return "practice05/06/fruit_input";
    }
	
	@RequestMapping(path = "/fruits/update/complete/{fruitId}",method = RequestMethod.POST)
    public String fruitsDetail(@PathVariable Integer fruitId,FruitsSeasonForm fruitForm,Model model) {
		FruitsSeason fruit = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fruit);
		fruit = repository.save(fruit);
		
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruit, fruitBean);
		model.addAttribute("fruit", fruitBean);
		
		return "Practice05/06/fruit_detail";
    }
}
