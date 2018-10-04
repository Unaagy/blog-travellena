package ru.travellena.blog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public String showFormForAdd(Model theModel, HttpServletRequest request) {

		Article article = new Article();
		article.setEventDate(new Date());

		theModel.addAttribute("article", article);
		theModel.addAttribute("fromPage", request.getHeader("Referer"));

		return "article-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("articleId") long theId, Model theModel, HttpServletRequest request) {

		Article theArticle = service.getArticle(theId);

		theModel.addAttribute("article", theArticle);
		theModel.addAttribute("fromPage", request.getHeader("Referer"));

		return "article-form";
	}

	@PostMapping("/saveArticle")
	public String saveArticle(@ModelAttribute("article") Article theArticle, @RequestParam("fromPage") String fromPage) {

		if (theArticle.isReadyToPublish() && theArticle.getPublishDate() == null) {
			theArticle.setPublishDate(new Date());
		}

		System.out.println("===>>> FromPage in SAVE " + fromPage);
		System.out.println(theArticle);

		service.saveArticle(theArticle);

		return "redirect:" + fromPage;
	}

	@GetMapping("/delete")
	public String deleteArticle(@RequestParam("articleId") long theId, HttpServletRequest request) {

		service.deleteArticle(theId);

		String referer = request.getHeader("Referer");

		if (referer.contains("/showArticle") || referer.contains("/searchArticle"))
			referer = "/";

		return "redirect:" + referer;
	}

	@GetMapping("/showArticle")
	public String showArticle(@RequestParam("articleId") long theId, Model theModel, HttpServletRequest request) {

		Article theArticle = service.getArticle(theId);

		String path = getRequsetPath(request) + "?articleId=" + theId;

		theModel.addAttribute("article", theArticle);
		theModel.addAttribute("path", path);

		// *****************************************
		System.out.println("===>>> Testing REFERER:");
		System.out.println(getRequsetPath(request));
		System.out.println(request.getHeader("Referer"));

		return "article-card";
	}

	@GetMapping("/searchArticle")
	public String searchArticle(@RequestParam("searchString") String searchString, Model theModel,
			HttpServletRequest request) {

		List<Article> theArticles = service.searchArticles(searchString);

		// *****************************************
		System.out.println("===>>> Testing REFERER:");
		System.out.println(getRequsetPath(request));
		System.out.println(request.getHeader("Referer"));

		theModel.addAttribute("articles", theArticles);

		return "articles-list";
	}

	// *******
	private String getRequsetPath(HttpServletRequest request) {
		String context = request.getContextPath();
		String reqUri = request.getRequestURI();
		String path = reqUri.replaceAll(context, "");
		return path;
	}

}
