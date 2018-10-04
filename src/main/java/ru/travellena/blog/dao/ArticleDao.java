package ru.travellena.blog.dao;

import java.util.List;

import ru.travellena.blog.entity.Article;

/**
 * DAO layer to operate with articles
 * 
 * @author tuchnyak, https://github.com/Tuchnyak
 *
 */
public interface ArticleDao {

	/**
	 * Should return all articles which is ready to be published. Sort order -
	 * oldest is first
	 * 
	 * @return List<Article> - list with all articles
	 */
	public List<Article> getAllArticles();

	/**
	 * Should return five last articles which is ready to be published. Sort order -
	 * freshest is first
	 * 
	 * @return List<Article> - list with five freshest articles
	 */
	public List<Article> getFiveLastArticles();

	/**
	 * Should return all drafts - articles which isn't ready to be published. Sort
	 * order - freshest is first
	 * 
	 * @return List<Article> - list with all freshest drafts (articles which is not
	 *         ready to publishing) and info article no matter ready it for
	 *         publishing or not
	 */
	public List<Article> getDrafts();

	/**
	 * Returns one article with "about" content
	 * 
	 * @return an object of Article class
	 */
	public Article getInfoArticle();

	/**
	 * Saves or Updates article
	 * 
	 * @param theArticle - Article object to save
	 */
	public void saveArticle(Article theArticle);

	/**
	 * Get Article by article ID
	 * 
	 * @param theId - ID of an article to get
	 * @return an object of Article class
	 */
	public Article getArticle(long theId);

	/**
	 * Deletes Article by article ID
	 * 
	 * @param theId - ID of an article to get
	 */
	public void deleteArticle(long theId);

	/**
	 * Method to get list of articles which have been searched by a searching
	 * request with string by the title and body fields
	 * 
	 * @param searchString - word for search
	 * @return List<Article> - articles list which have been found or full list of
	 *         an articles
	 */
	public List<Article> searchArticles(String searchString);

}
