package ru.travellena.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.travellena.blog.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService service;
	
	@GetMapping("/main")
	public String showMain(Model theModel) {
		
		theModel.addAttribute("articles", service.getFiveLastArticles());
		
		return "app-main";
	}
	
	@GetMapping("/showList")
	public String showIndex(Model theModel) {
		
		theModel.addAttribute("articles", service.getAllArticles());
		
		return "articles-list";
	}

}
