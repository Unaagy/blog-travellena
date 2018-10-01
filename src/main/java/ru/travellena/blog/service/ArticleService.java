package ru.travellena.blog.service;

import java.util.List;

import ru.travellena.blog.entity.Article;

public interface ArticleService {
	
	public List<Article> getAllArticles();

	public List<Article> getFiveLastArticles();

	public List<Article> getDrafts();

}
