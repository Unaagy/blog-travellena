package ru.travellena.blog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;

import ru.travellena.blog.entity.Article;
import ru.travellena.blog.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleService service;

	@GetMapping("/main")
	public String showMain(Model theModel, HttpServletRequest request) {
		
		theModel.addAttribute("articles", service.getFiveLastArticles());
		theModel.addAttribute("path", getRequsetPath(request));

		return "app-main";
	}

	@GetMapping("/showList")
	public String showList(Model theModel, HttpServletRequest request) {

		theModel.addAttribute("articles", service.getAllArticles());
		theModel.addAttribute("path", getRequsetPath(request));

		return "articles-list";
	}

	@GetMapping("/showTableOfContext")
	public String showTableOfContext(Model theModel, HttpServletRequest request) {

		theModel.addAttribute("articles", service.getAllArticles());
		theModel.addAttribute("path", getRequsetPath(request));

		return "articles-table-of-context";
	}

	@GetMapping("/showDrafts")
	public String showDrafts(Model theModel, HttpServletRequest request) {

		theModel.addAttribute("drafts", service.getDrafts());
		theModel.addAttribute("path", getRequsetPath(request));

		return "articles-drafts";
	}

	@GetMapping("/showAbout")
	public String showAbout(Model theModel, HttpServletRequest request) {
		
		theModel.addAttribute("infoArticle", service.getInfoArticle());
		theModel.addAttribute("path", getRequsetPath(request));

		return "app-about";
	}

	@InitBinder
	public void dateInitBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("fromPage") String fromPage, Model theModel) {

		// TEMP
		System.out.println("In the showFormForAdd controller: " + fromPage);

		Article article = new Article();
		article.setEventDate(new Date());

		theModel.addAttribute("article", article);
		theModel.addAttribute("fromPage", fromPage);

		return "article-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("articleId") long theId, @RequestParam("fromPage") String fromPage,
			Model theModel) {

		// TEMP
		System.out.println("In the showFormForUpdate controller: " + fromPage);

		Article theArticle = service.getArticle(theId);

		theModel.addAttribute("article", theArticle);
		theModel.addAttribute("fromPage", fromPage);

		return "article-form";
	}

	@PostMapping("/saveArticle")
	public String saveArticle(@ModelAttribute("article") Article theArticle,
			@RequestParam("fromPage") String fromPage) {

		// TEMP
		System.out.println("In the Save controller: " + fromPage);

		if (theArticle.isReadyToPublish() && theArticle.getPublishDate() == null) {
			theArticle.setPublishDate(new Date());
		}

		System.out.println(theArticle);

		service.saveArticle(theArticle);

//		return "redirect:/";
		return "redirect:" + fromPage;		
	}

	@GetMapping("/delete")
	public String deleteArticle(@RequestParam("articleId") long theId, HttpServletRequest request) {

		service.deleteArticle(theId);
		
		String referer = request.getHeader("Referer");
		System.out.println("===>>> Before: " + referer);
		if (referer.contains("/showArticle"))
			referer = "/";
		System.out.println("===>>> Before: " + referer);
		
		return "redirect:" + referer;
	}

	@GetMapping("/showArticle")
	public String showArticle(@RequestParam("articleId") long theId, Model theModel, HttpServletRequest request) {

		Article theArticle = service.getArticle(theId);
		
		String path = getRequsetPath(request) + "?articleId=" + theId;

		theModel.addAttribute("article", theArticle);
		theModel.addAttribute("path", path);

		return "article-card";
	}
	
	// *******
	private String getRequsetPath(HttpServletRequest request) {
		String context = request.getContextPath();
		String reqUri = request.getRequestURI();
		String path = reqUri.replaceAll(context, "");
		return path;
	}

}
