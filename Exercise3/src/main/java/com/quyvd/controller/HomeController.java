package com.quyvd.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quyvd.model.AccountDAO;

@Controller
public class HomeController {

	@Autowired
	private AccountDAO accountDAO;

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
		model.addAttribute("fullname", "");
		return "formPage";
	}

	@RequestMapping(value = "/forms", method = RequestMethod.POST)
	public String handleSubmit(@RequestParam String email, @RequestParam String password, Model model)
			throws ClassNotFoundException, SQLException {
		if (email == "" || password == "") {
			model.addAttribute("fullname", "Error!!!");
		} else {
			int checkrs = accountDAO.insertAccount(email, password);
			switch (checkrs) {
			case 0:
				model.addAttribute("fullname", "Connect Fail!!!");
				break;
			case -1:
				model.addAttribute("fullname", "Invalid Email!!!");
				break;
			default:
				model.addAttribute("fullname", "Success!!!");
				break;
			}
		}
		/*
		 * model.addAttribute("fullname", firstname+lastname); Date date = new
		 * Date(); User user = new User(firstname, lastname, new
		 * Timestamp(date.getTime())); DatabaseConnector.addUser(user);
		 */
		return "formPage";

	}

	@RequestMapping(value = "/iframe")
	public String iframePage() {
		return "iframePage";
	}

	@RequestMapping(value = "/CSSList")
	public String CSSListPage() {
		return "CSSListPage";
	}

	@RequestMapping(value = "/bstAlert")
	public String bstAlertPage() {
		return "bstAlertPage";
	}
}
