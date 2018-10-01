package ru.travellena.blog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.travellena.blog.entity.Article;
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
	public String showList(Model theModel) {

		theModel.addAttribute("articles", service.getAllArticles());

		return "articles-list";
	}

	@GetMapping("/showTableOfContext")
	public String showTableOfContext(Model theModel) {

		theModel.addAttribute("articles", service.getAllArticles());

		return "articles-table-of-context";
	}

	@GetMapping("/showDrafts")
	public String showDrafts(Model theModel) {

		theModel.addAttribute("drafts", service.getDrafts());

		return "articles-drafts";
	}

	@GetMapping("/showAbout")
	public String showAbout(Model theModel) {

		theModel.addAttribute("infoArticle", service.getInfoArticle());

		return "app-about";
	}

	@InitBinder
	public void dateInitBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Article article = new Article();
		article.setEventDate(new Date());

		theModel.addAttribute("article", article);

		return "article-form";
	}

	// TODO
	@PostMapping("/saveArticle")
	public String saveArticle(@ModelAttribute("article") Article theArticle) {

		return "redirect:/";
	}

}
