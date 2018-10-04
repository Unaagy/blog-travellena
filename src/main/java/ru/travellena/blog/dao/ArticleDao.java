package ru.travellena.blog.dao;

import java.util.List;

import ru.travellena.blog.entity.Article;

public interface ArticleDao {

	// Should return all articles which is ready to be published. Sort forward - oldest is first
	public List<Article> getAllArticles();

	// Should return five last articles which is ready to be published. Sort reverse - freshest is first
	public List<Article> getFiveLastArticles();
	
	// Should return all drafts - articles which isn't ready to be published. Sort reverse - freshest is first
	public List<Article> getDrafts();

	// Returns one article with "about" content
	public Article getInfoArticle();

	// Save or Update article
	public void saveArticle(Article theArticle);

	// Get Article by article ID
	public Article getArticle(long theId);

	// Delete Article by article ID
	public void deleteArticle(long theId);

	public List<Article> searchArticles(String searchString);
	
}
