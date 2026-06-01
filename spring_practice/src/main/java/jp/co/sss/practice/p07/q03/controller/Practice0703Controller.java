package jp.co.sss.practice.p07.q03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0703Controller {
	@Autowired
	private FruitsShopItemRepository fruitsShopItemRepository;
	@Autowired
	private TypeRepository typeRepository;
	
	@RequestMapping(path = "/fruits_shop/query/input",method = RequestMethod.GET)
    public String showFruitsShopItem(Model model) {
		model.addAttribute("typeList",typeRepository.findAll());
		return "practice07/03/search_input";
    }
	
	@RequestMapping(path = "/fruits_shop/query/result",method = RequestMethod.GET)
    public String resultFruitsShopItem(Integer minPrice, Integer maxPrice, Integer typeId ,Model model) {
		Type type = new Type();
		type.setTypeId(typeId);
		model.addAttribute("itemsList", fruitsShopItemRepository.findQueryByPriceRangeAndType(minPrice,maxPrice,type));
		return "practice07/03/items_list";
    }
}
