package org.strongme.walter.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.walter.pojo.Category;
import org.strongme.walter.service.CategoryService;


@Controller
@RequestMapping(value="category")
public class CategoryController {
	
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping(value="/categoryList",method=RequestMethod.GET)
	public @ResponseBody List<Category> allCategory() {
		List<Category> result = categoryService.allCategory();
		return result;
	}
	
}
