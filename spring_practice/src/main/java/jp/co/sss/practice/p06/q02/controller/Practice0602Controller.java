package jp.co.sss.practice.p06.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p06.entity.Area;
import jp.co.sss.practice.p06.repository.AreaRepository;
import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0602Controller {
	
	@Autowired
	private FruitsAreaRepository fruitsAreaRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@RequestMapping(path = "/fruits/select/area",method = RequestMethod.GET)
    public String showFruitsAreaList(Model model) {
		model.addAttribute("areaList",areaRepository.findAllByOrderByAreaId());
		return "practice06/02/area_select";
    }
	
	@RequestMapping(path = "/fruits/select/area/result",method = RequestMethod.GET)
    public String fruitsAreaListResult(Integer areaId,Model model) {
		Area area = areaRepository.getReferenceById(areaId);
		model.addAttribute("fruitsList", fruitsAreaRepository.findByAreaOrderByFruitId(area));
		model.addAttribute("areaName", area.getAreaName());
		return "practice06/02/fruits_list";
    }
}
