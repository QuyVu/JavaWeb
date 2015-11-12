package com.quyvd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/heading")
	public String headingPage() {
		return "headingPage";
	}

	@RequestMapping(value = "/paragraph")
	public String paragraphPage() {
		return "paragraphPage";
	}

	@RequestMapping(value = "/textformat")
	public String textformatPage() {
		return "textformatPage";
	}

	@RequestMapping(value = "/hyper")
	public String hyperPage() {
		return "hyperPage";
	}

	@RequestMapping(value = "/img")
	public String imgPage() {
		return "imgPage";
	}

	@RequestMapping(value = "/list")
	public String listPage() {
		return "listPage";
	}

	@RequestMapping(value = "/table")
	public String tablePage() {
		return "tablePage";
	}

	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public String formPage(Model model) {
		model.addAttribute("fullname","");
		return "formPage";
	}

	@RequestMapping(value = "/forms", method = RequestMethod.POST)
	public String handleSubmit(@RequestParam String firstname, @RequestParam String lastname, Model model){
		model.addAttribute("fullname", firstname+lastname);
		return "formPage";
	}

	@RequestMapping(value = "/iframe")
	public String iframePage() {
		return "iframePage";
	}
}
