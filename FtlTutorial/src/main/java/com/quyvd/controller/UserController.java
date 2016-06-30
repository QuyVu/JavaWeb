package com.quyvd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String index(@ModelAttribute("model") ModelMap model, Model total) {
		total.addAttribute("total", userDaoImpl.count(""));
		List<User> userList =  userDaoImpl.search("",0,10);
		model.addAttribute("userList", userList);
		return "list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error) {
		return "login";
	}
	
	@RequestMapping(value = "/submit-new-user", method = RequestMethod.POST)
	public @ResponseBody Integer getUser(@RequestBody User user) {
		Integer response = new Integer(0);
		response = userDaoImpl.addUser(user);
		return response;
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

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> search(@RequestParam("keyword") String keyword, @RequestParam("offset") int offset) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<User> users = userDaoImpl.search(keyword.toLowerCase(),offset,10);
		String html = "";
		for(User user: users) {
			html += genHtml(user);
		} 
		response.put("total", userDaoImpl.count(keyword.toLowerCase()));
		response.put("html", html);
		return response;
	}
	
	private String genHtml(User user) {
		String html = 
		("<tr>" +
		"<td class='text-center'>" + user.getId() + "</td>" +
		"<td id='data-name-" + user.getId() + "' class='data-name'>" +
			"<p id='p-name-" + user.getId() + "'>" + user.getName() + "</p>" + 
			"<input id='input-name-" + user.getId() + "' type='text'" +
			"class='form-control input-sm' style='display: none; width: 100%'" +
			"value='" + user.getName() + "'>" +
		"</td>" +
		"<td id='data-password-" + user.getId() + "' class='data-password'>" +
			"<p id='p-password-" + user.getId() + "'>" + user.getPassword() + "</p>" +
			"<input id='input-password-" + user.getId() + "' type='text' class='form-control input-sm' style='display: none; width: 100%'" +
			"value='" + user.getPassword() + "'>" +
		"</td>" +
		"<td class='text-center'>" +
			"<button id='edit-data-" + user.getId() + "' name='edit-data'" +
				"style='width: 80px' class='edit edit-data btn btn-warning btn-sm'" +
				"value='" + user.getId() + "'onClick=('editData()')>" +
				"<i class='fa fa-pencil-square-o'></i> edit" +
			"</button>" +
			"<button id='get-data-" + user.getId() + "' name='get-data'" +
				"style='width: 80px' class='get-data btn btn-primary btn-sm'" +
				"value='" + user.getId() + "'>" +
				"<i class='fa fa-download'></i> data" +
			"</button>" +
			"<button id='save-data-" + user.getId() + "'" +
				"style='width: 80px; display: none;'" +
				"class='save-data btn btn-success btn-sm'" +
				"value='" + user.getId() + "'>" +
				"<i class='fa fa-floppy-o'></i> save" +
			"</button>" +
			"<button id='cancel-edit-" + user.getId() + "'" +
				"style='width: 80px; display: none;'" +
				"class='cancel-edit btn btn-danger btn-sm'" +
				"value='" + user.getId() + "'>" +
				"<i class='fa fa-times'></i> calcel" +
			"</button>" +
		"</td>" +
		"</tr>");

		return html;
	} 
	

}
