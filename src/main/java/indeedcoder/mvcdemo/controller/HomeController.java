package indeedcoder.mvcdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private List<String> skills = Arrays.asList("Java", "HTML", "CSS", "JS");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome() {
		return "HomePage";
	}

	@RequestMapping(value = "/modelintf", method = RequestMethod.GET)
	public String showUsingModel(Model m) {
		m.addAttribute("implClass", m.getClass().getName());
		m.addAttribute("id", 101);
		m.addAttribute("skills", skills);
		return "ModelPage";
	}

	@RequestMapping(value = "/modelmapclass", method = RequestMethod.GET)
	public String showUsingModelMap(ModelMap m) {
		m.addAttribute("id", 101);
		m.addAttribute("skills", skills);
		return "ModelMapPage";
	}

	@RequestMapping(value = "/modelandview", method = RequestMethod.GET)
	public ModelAndView showUsingModelAndView() {
		ModelAndView m = new ModelAndView();
		m.setViewName("ModelAndViewPage");
		m.addObject("id", 101);
		m.addObject("skills", skills);
		return m;
	}
}
