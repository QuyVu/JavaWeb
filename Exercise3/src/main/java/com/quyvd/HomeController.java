package com.quyvd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = { "/", "/index" })
	public String indexPage() {
		return "indexPage";
	}

	@RequestMapping(value = "/about")
	public String aboutPage(Model model) {
		model.addAttribute("address", "Vietnam");
		model.addAttribute("email", "...");
		model.addAttribute("phone", "0123456789");
		return "aboutPage";
	}
	
	@RequestMapping(value = "/help")
	public String helpPage() {
		return "helpPage";
	}
}
