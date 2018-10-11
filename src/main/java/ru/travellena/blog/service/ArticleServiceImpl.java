package ru.travellena.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.travellena.blog.dao.ArticleDao;
import ru.travellena.blog.entity.Article;

/**
 * Article servise interface implementaiton
 * 
 * @author tuchnyak, https://github.com/Tuchnyak
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	/**
	 * Article DAO-layer dependency
	 */
	@Autowired
	@Qualifier("articleDaoImplDb")
	private ArticleDao dao;

	@Override
	@Transactional
	public List<Article> getAllArticles() {

		return dao.getAllArticles();
	}

	@Override
	@Transactional
	public List<Article> getFiveLastArticles() {

		return dao.getFiveLastArticles();
	}

	@Override
	@Transactional
	public List<Article> getDrafts() {

		return dao.getDrafts();
	}

	@Override
	@Transactional
	public Article getInfoArticle() {

		return dao.getInfoArticle();
	}

	@Override
	@Transactional
	public void saveArticle(Article theArticle) {

		dao.saveArticle(theArticle);
	}

	@Override
	@Transactional
	public Article getArticle(long theId) {

		return dao.getArticle(theId);
	}

	@Override
	@Transactional
	public void deleteArticle(long theId) {

		dao.deleteArticle(theId);
	}

	@Override
	@Transactional
	public List<Article> searchArticles(String searchString) {

		return dao.searchArticles(searchString);
	}

}
