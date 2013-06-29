package org.strongme.walter.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.strongme.walter.dao.MysqlDao;
import org.strongme.walter.pojo.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	private MysqlDao mysqlDao;
	
	@RequestMapping(method=RequestMethod.GET,params="new")
	public String toUserCreate(Model model) {
		String[] genders = {"Male","Female"};
		model.addAttribute("genders", genders);
		model.addAttribute(new User());
		System.out.println(mysqlDao==null);
		return "newUser";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addUserFromForm(@Validated User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "newUser";
		}
		return "redirect:/user/"+user.getName();
	}
	
	@RequestMapping(value="/{userName}")
	public String toSpecifyUser(@PathVariable String userName,Model model) {
		model.addAttribute("userName", userName);
		return "userInfo";
	}

	
	
}
