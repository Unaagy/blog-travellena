package ru.travellena.blog.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.travellena.blog.entity.Article;

@Repository
public class ArticleDaoImplDb implements ArticleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Article> getAllArticles() {

		Session session = sessionFactory.getCurrentSession();

		Query<Article> theQuery = session.createQuery(
				"from Article a where a.readyToPublish = true and a.info = false order by publishDate", Article.class);

		List<Article> articles = theQuery.getResultList();

		return articles;
	}

	@Override
	public List<Article> getFiveLastArticles() {

		Session session = sessionFactory.getCurrentSession();

		Query<Article> theQuery = session.createQuery(
				"from Article a where a.readyToPublish = true and a.info = false order by publishDate desc",
				Article.class);

		theQuery.setFirstResult(0);
		theQuery.setMaxResults(5);

		List<Article> articles = theQuery.getResultList();

		return articles;
	}

	@Override
	public List<Article> getDrafts() {

		Session session = sessionFactory.getCurrentSession();

		Query<Article> theQuery = session.createQuery(
				"from Article a where a.readyToPublish = false or a.info = true order by publishDate desc",
				Article.class);

		List<Article> articles = theQuery.getResultList();

		return articles;
	}

	@Override
	public Article getInfoArticle() {

		Session session = sessionFactory.getCurrentSession();

		Query<Article> theQuery = session.createQuery("from Article a where a.info = true and a.readyToPublish = true",
				Article.class);

		Article theArticle = null;

		try {
			theArticle = theQuery.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("===>>> Information article not found");
		}

		return theArticle;
	}

	@Override
	public void saveArticle(Article theArticle) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theArticle);

	}

	@Override
	public Article getArticle(long theId) {

		return sessionFactory.getCurrentSession().get(Article.class, theId);
	}

	@Override
	public void deleteArticle(long theId) {

		Session session = sessionFactory.getCurrentSession();

		Query theQuery = session.createQuery("delete from Article where id = :theId").setParameter("theId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Article> searchArticles(String searchString) {

		Session session = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if (searchString != null && searchString.trim().length() > 0) {
			theQuery = session.createQuery(
					"from Article where lower(title) like :searchString or lower(body) like :searchString",
					Article.class);
			theQuery.setParameter("searchString", "%" + searchString.toLowerCase() + "%");

		} else {
			theQuery = session.createQuery(
					"from Article a where a.readyToPublish = true and a.info = false order by publishDate desc",
					Article.class);
		}

		List<Article> articles = theQuery.getResultList();

		return articles;
	}

}
