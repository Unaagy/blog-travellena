package ru.travellena.blog.service;

import java.util.List;

import ru.travellena.blog.entity.Article;

public interface ArticleService {
	
	public List<Article> getAllArticles();

	public List<Article> getFiveLastArticles();

	public List<Article> getDrafts();

	public Article getInfoArticle();

	public void saveArticle(Article theArticle);

	public Article getArticle(long theId);

	public void deleteArticle(long theId);

	public List<Article> searchArticles(String searchString);

}
