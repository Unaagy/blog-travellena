package ru.travellena.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.travellena.blog.service.ArticleService;

@Controller
public class HomeController {
	
	@Autowired
	ArticleService service;
	
	@RequestMapping("/showList")
	public String showIndex(Model theModel) {
		
		theModel.addAttribute("articlesList", service.getAllArticles());
		
		return "articles-list";
	}

}
