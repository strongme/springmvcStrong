package org.strongme.walter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.strongme.walter.pojo.Film;
import org.strongme.walter.pojo.User;
import org.strongme.walter.service.FilmService;

@Controller
@RequestMapping(value="/film")
public class FilmController {
	
	@Resource
	private FilmService filmService;
	
	@RequestMapping(value="/filmsByCateId/{categoryId}")
	public String getFilmsByCategoryId(@PathVariable String categoryId,Model model) {
		List<Film> result = filmService.getFilmsByCategoryId(Short.valueOf(categoryId));
		model.addAttribute("films",result);
		List users =  new ArrayList();
		User user = new User();
		user.setName("ASASA");
		user.setGender("Male");
		user.setPassword("123");
		user.setUsername("asasa");
		user.setAge((short) 23);
		users.add(user);
		users.add(user);
		users.add(user);
		model.addAttribute("users", users);
		return "filmList";
	}

}
