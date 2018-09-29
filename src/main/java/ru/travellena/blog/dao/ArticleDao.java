package ru.travellena.blog.dao;

import java.util.List;

import ru.travellena.blog.entity.Article;

public interface ArticleDao {

	public List<Article> getAllArticles();
	
}
