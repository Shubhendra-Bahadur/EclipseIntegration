package com.sunny.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunny.springmvc.dao.AlienDao;
import com.sunny.springmvc.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	private AlienDao dao;
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "aliens");
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}

//	@RequestMapping("add")
//	public String add(HttpServletRequest req, HttpServletRequest res) {
//
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//
//		int sum = i + j;
//		HttpSession session=req.getSession();
//		session.setAttribute("num3", sum);
//		
//		return "result.jsp";
//	}

	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		int sum = i + j;
		mv.addObject("num3", sum);

		return mv;
	}

//	@RequestMapping("addAlien")
//	public String addAlien(@RequestParam("aid") int id, @RequestParam("aname") String name, Model m) {
//		
//		Alien a=new Alien();
//		a.setAid(id);
//		a.setAname(name);
//		m.addAttribute("alien",a);
//		return "result";
//	}

	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("a1") Alien a) {
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		m.addAttribute("result",dao.getAliens());
		return "showAliens";
	}
}
