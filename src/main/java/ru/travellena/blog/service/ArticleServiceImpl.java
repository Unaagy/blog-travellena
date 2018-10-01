package ru.travellena.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ru.travellena.blog.dao.ArticleDao;
import ru.travellena.blog.entity.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	@Qualifier("articleDaoImplTest")
	private ArticleDao dao;
	
	@Override
	public List<Article> getAllArticles() {
		
		return dao.getAllArticles();
	}

	@Override
	public List<Article> getFiveLastArticles() {
		
		return dao.getFiveLastArticles();
	}

	@Override
	public List<Article> getDrafts() {
		
		return dao.getDrafts();
	}

	@Override
	public Article getInfoArticle() {
		
		return dao.getInfoArticle();
	}

}
