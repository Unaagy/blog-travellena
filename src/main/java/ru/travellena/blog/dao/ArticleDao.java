package ru.travellena.blog.dao;

import java.util.List;

import ru.travellena.blog.entity.Article;

public interface ArticleDao {

	// Should return all articles which is ready to be published
	public List<Article> getAllArticles();

	// Should return five last articles which is ready to be published
	public List<Article> getFiveLastArticles();
	
	// Should return all drafts - articles which isn't ready to be published
	public List<Article> getDrafts();
	
}
