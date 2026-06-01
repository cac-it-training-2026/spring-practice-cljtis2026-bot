package jp.co.sss.practice.p07.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0702Controller {
	@Autowired
	private TypeRepository typeRepository;
	@Autowired
	private EntityManager entityManager;
	
	@RequestMapping(path = "/fruits_shop/named/input",method = RequestMethod.GET)
    public String showFruitsShopItem(Model model) {
		model.addAttribute("typeList",typeRepository.findAll());
		return "practice07/02/search_input";
    }
	
	@RequestMapping(path = "/fruits_shop/named/result",method = RequestMethod.GET)
    public String resultFruitsShopItem(Integer minPrice, Integer maxPrice, Integer typeId ,Model model) {
		Type type = new Type();
		type.setTypeId(typeId);
		Query query = entityManager.createNamedQuery("findNamedQueryByPriceRangeAndType");
		query.setParameter("min",minPrice);
		query.setParameter("max",maxPrice);
		query.setParameter("type",type);
		model.addAttribute("itemsList",query.getResultList());
		return "practice07/02/items_list";
    }
}
