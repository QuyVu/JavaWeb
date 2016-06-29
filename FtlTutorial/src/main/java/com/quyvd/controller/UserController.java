package com.quyvd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quyvd.model.User;
import com.quyvd.model.UserDaoImpl;

@Controller
public class UserController {
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute("model") ModelMap model) {
		List<User> userList =  userDaoImpl.listAll();
		model.addAttribute("userList", userList);
		return "list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "error", required = false) String error, Model model) {
		return "login";
	}

	@RequestMapping(value = "/update-data", method = RequestMethod.POST)
	public @ResponseBody Integer updateData(@RequestBody User user) {
		Integer result = 0;
		result = userDaoImpl.editUser(user);
		return result;
	}
	
	@RequestMapping(value = "/getjson", method = RequestMethod.POST)
	public @ResponseBody User getJsonData(@RequestParam("id") int userId) {
		System.out.println("id " + userId);
		User user = userDaoImpl.getUserById(userId);
		return user;
	}

}
