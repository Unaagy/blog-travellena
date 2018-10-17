package ru.travellena.blog.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.travellena.blog.entity.Article;
import ru.travellena.blog.service.ArticleService;

/**
 * 
 * @author tuchnyak, https://github.com/Tuchnyak
 *
 * @About Controller to handle requests which operates articles
 */

@Controller
@RequestMapping("/article")
public class ArticleController {

	/**
	 * Field to inject an article's Service layer
	 */
	@Autowired
	ArticleService service;

	/**
	 * @param theModel - keeps five last articles
	 * @return "app-main" - main page of the app
	 */
	@GetMapping("/main")
	public String showMain(Model theModel) {

		theModel.addAttribute("articles", service.getFiveLastArticles());

		return "app-main";
	}

	/**
	 * @param theModel - keeps all articles from DB
	 * @return "articles-list" - page with all articles
	 */
	@GetMapping("/showList")
	public String showList(Model theModel) {

		theModel.addAttribute("articles", service.getAllArticles());

		return "articles-list";
	}

	/**
	 * @param theModel - keeps all articles from DB
	 * @return "articles-table-of-context" - page with all articles in short text
	 *         view
	 */
	@GetMapping("/showTableOfContext")
	public String showTableOfContext(Model theModel) {

		theModel.addAttribute("articles", service.getAllArticles());

		return "articles-table-of-context";
	}

	/**
	 * @param theModel - keeps all drafts from DB
	 * @return "articles-drafts"
	 */
	@GetMapping("/showDrafts")
	public String showDrafts(Model theModel) {

		theModel.addAttribute("drafts", service.getDrafts());

		return "articles-drafts";
	}

	/**
	 * @param theModel - keeps info article. An article which marked as
	 *                 informational. Should be only one in all DB.
	 * @return "app-about" - page to show info article
	 */
	@GetMapping("/showAbout")
	public String showAbout(Model theModel) {

		theModel.addAttribute("infoArticle", service.getInfoArticle());

		return "app-about";
	}

	/**
	 * Shows form to create new article
	 * 
	 * @param theModel - keeps new empty article and reference to a previous page
	 * @param request  - is used to get the previous page where the form has been
	 *                 called
	 * @return "article-form"
	 */
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel, HttpServletRequest request) {

		Article article = new Article();

		theModel.addAttribute("article", article);
		theModel.addAttribute("fromPage", request.getHeader("Referer"));

		return "article-form";
	}

	/**
	 * Shows form to update existing article
	 * 
	 * @param theId    - ID number of an existing page
	 * @param theModel - keeps read article and reference to a previous page
	 * @param request  - is used to get the previous page where the form has been
	 *                 called
	 * @return "article-form"
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("articleId") long theId, Model theModel, HttpServletRequest request) {

		Article theArticle = service.getArticle(theId);

		theModel.addAttribute("article", theArticle);
		theModel.addAttribute("fromPage", request.getHeader("Referer"));

		return "article-form";
	}

	/**
	 * Saves new or update existing article
	 * 
	 * @param theArticle - model attribute has been gotten from an article form
	 * @param fromPage   - request parameter that keeps a reference to a page where
	 *                   article form has been called
	 * @return '"redirect:" + fromPage' - redirection to a previous page
	 */
	@PostMapping("/saveArticle")
	public String saveArticle(@ModelAttribute("article") Article theArticle,
			@RequestParam("fromPage") String fromPage) {

		if (theArticle.isReadyToPublish() && theArticle.getPublishDate() == null) {
			theArticle.setPublishDate(LocalDateTime.now());
		}

		System.out.println("===>>> FromPage in SAVE " + fromPage);
		System.out.println(theArticle);

		service.saveArticle(theArticle);

		return "redirect:" + fromPage;
	}

	/**
	 * Deletes existing article
	 * 
	 * @param theId   - ID of an article to delete
	 * @param request - is used to get the previous page where the form has been
	 *                called
	 * @return '"redirect:" + referer' - redirection to a previous page or to "/" if
	 *         action has been done is on article or search page
	 */
	@GetMapping("/delete")
	public String deleteArticle(@RequestParam("articleId") long theId, HttpServletRequest request) {

		service.deleteArticle(theId);

		String referer = request.getHeader("Referer");

		if (referer.contains("/showArticle") || referer.contains("/searchArticle"))
			referer = "/";

		return "redirect:" + referer;
	}

	/**
	 * Opens an article in the separate page
	 * 
	 * @param theId    - ID to load an article from a DB
	 * @param theModel - keeps article from a DB
	 * @return "article-card" - page for a separate article
	 */
	@GetMapping("/showArticle")
	public String showArticle(@RequestParam("articleId") long theId, Model theModel) {

		Article theArticle = service.getArticle(theId);

		theModel.addAttribute("article", theArticle);

		return "article-card";
	}

	/**
	 * Method to get list of articles which have been searched by a searching
	 * request with string by the title and body fields
	 * 
	 * @param searchString - word to find in an article
	 * @param theModel     - keeps articles list which have been found or full list
	 *                     of an articles
	 * @return "articles-list" - send to all articles page
	 */
	@GetMapping("/searchArticle")
	public String searchArticle(@RequestParam("searchString") String searchString, Model theModel) {

		List<Article> theArticles = service.searchArticles(searchString);

		theModel.addAttribute("articles", theArticles);

		return "articles-list";
	}

	/**
	 * Deprecated method which gives last part of a http request from current page
	 * For example: "/articles/main"
	 * 
	 * @param request - HttpServletRequest object
	 * @return String path
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private String getRequsetPath(HttpServletRequest request) {
		String context = request.getContextPath();
		String reqUri = request.getRequestURI();
		String path = reqUri.replaceAll(context, "");
		return path;
	}

}
