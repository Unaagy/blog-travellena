package ru.travellena.blog.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ru.travellena.blog.entity.Article;

@Repository
public class ArticleDaoImplTest implements ArticleDao {

	private List<Article> articles;

	@PostConstruct
	private void initializeArticles() {
		Article a1 = new Article();
		Article a2 = new Article();
		Article a3 = new Article();
		Article a4 = new Article();
		Article a5 = new Article();
		Article a6 = new Article();
		Article a7 = new Article();
		Article aInfo = new Article();

		a1.setTitle("Day 1");
		a2.setTitle("Day 2");
		a3.setTitle("Day 3");
		a4.setTitle("Day 4");
		a5.setTitle("Day 5");
		a6.setTitle("Day 6");
		a7.setTitle("Day 7");
		aInfo.setTitle("About us");
		aInfo.setInfo(true);

		a1.setBody(
				"Наконец мы решили отправиться к знаменитому Большому Будде. Называется он так потому что является второй самой большой бронзовой статуей сидячего Будды в мире (первая если что на Тайване ;) ) Вообще занятно сколько делают разных статуй Будды со статусами: самый большой лежащий, самый большой сидящий, самый большой золотой, самый большой в камне и т.д. Наверно для привлечения туристов, которые для галочки могут туда съездить и потом говорить: я видел самого большого лежащего золотого Будду )) А может просто, думают, что снизойдёт на них благословение Будды таким образом. Это лишь мои субъективные домыслы. Но закончим лирическое отступление.");
		a2.setBody(
				"Наш Будда находился на соседнем острове Лантау, чтобы туда добраться нам пришлось сперва воспользоваться метро, затем, выбравшись из подземного лабиринта (иногда в Гонконге просто не понятно куда идти на пересадку или где выход), мы стали искать автобус до деревни Нгонг Пинг(вроде правильно написала) или монастырь По Лин, рядом с которыми и располагается Будда. Сразу скажу, что есть также возможность добраться на фуникулере (цена варьируется от 145 hkd до 200 hkd в одну сторону в зависимости от кабинки: со стеклянным дном или нет). Так как нам не повезло в этот день с погодой, мы воспользовались более привычным нам транспортом - автобусом. Чуть подробнее  как туда добраться здесь. Цена за билет была около 17hkd, и была крыша от дождя.");
		a3.setBody(
				"Пройдя аллею скульптур и коров, мы наконец вышли к подъёму к Большому Будде. Рядом продавали какие-то ваучеры на комплексный обед. Тогда мы не предали этому значения, как оказалось позднее, при наличии этого ваучера можно подняться наверх внутри статуи Будды + ты получаешь обед - неплохое комбо. Но мы прошли мимо и стали подниматься.");
		a4.setBody(
				"Ступенек оказалось около 300, поэтому мы быстро забрались наверх. Преодолев пару сотен ступенек, мы увидили  гигантскую бронзовую статую Будды, в окружении шести статуй Бодхисаттве. Каждая из них символизирует одно из шести качеств - ступеней, ведущих к нирване (совершенство даяния; совершенство нравственности; совершенство терпения; совершенство усердия, мужества; совершенство созерцания; совершенство мудрости). В руках они держат священные подношения Будде: цветы, благовония, мази, фрукты и музыкальные инструменты.");
		a5.setBody(
				"Уже после, просматривая фотографии большого Будды при хорошей погоде, я заметила, что в нашем случае было более необычно и интересно созерцать его именно в таком виде, поэтому мы не сильно расстроились туману. Зато дождю мы были точно не рады. Уже когда мы спускались вниз стал накрапывать мелкий противны дождь (мы как обычно не пожалели, что взяли дождевики). ");
		a6.setBody(
				"В самом конце монастыря находилась столовая. Цены там были адекватные, но еда вегетарианская. В итоге мы заказали соевое ассорти (может видели у нас в супермаркетах продаётся соевое мясо, вот такое примерно и было) с разными соусами. Мы осилили лишь в кисло-сладком соусе и немного в сладком, острый соус был настолько острый, что нам хватило только по кусочку попробовать, чтобы во рту разыгралась первая мировая. Благо у нас были взяты сосиски в тесте и мы втихаря, чтобы не ущемлять вегетарианские достоинства, умяли их все хD");
		a7.setBody(
				"Устав от шума, грязи и бесконечного трафика, мы решили в этот день сгонять на другой остров - Лама, также находящийся в полномочии Гонконга. Плыть туда надо на пароме, который отправляется от центрального причала. Позавтракав чём-то непонятным (то ли рыбные шарики, то ли из других каких-то морегадов), мы направились к паромной станции. Искать нужный нам кораблик долго не пришлось, достаточно было сказать «Лама?» и вам указывают куда идти. Билет в один конец стоил 17,8 hkd (но то было в будни, в выходные уже чуть дороже), ехать минут 30-40. Вышли мы в северной части острова (название станции я как всегда не смогла ни выговорить ни запомнить). Вооружившись мепсми, мы пошли правее, вдоль моря, затем попали то ли на рынок, то ли на главную улицу острова. Там было давольно оживлённо и за небольшими прилавками продавали всякую всячину. Тут же были кафешки да ресторанчики с морегадами, которых нельзя было фотографировать.");
		aInfo.setBody("We are crazy travelers!!!");

		a1.setReadyToPublish(true);
		a2.setReadyToPublish(true);
		a3.setReadyToPublish(true);
		a4.setReadyToPublish(true);
		a5.setReadyToPublish(true);
		a6.setReadyToPublish(true);
		a7.setReadyToPublish(false);
		aInfo.setReadyToPublish(true);

		articles = new ArrayList<>();
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		articles.add(a4);
		articles.add(a5);
		articles.add(a6);
		articles.add(a7);
		articles.add(aInfo);

		Date refDate = new Date();
		int id = 1;
		long timeDelta = 86400000;
		for (Article a : articles) {
			a.setId(id);
			a.setPublishDate(new Date(refDate.getTime() - timeDelta));

			id++;
			timeDelta = timeDelta * 2;
		}

	}

	@Override
	public List<Article> getAllArticles() {

		return getClearList(articles);
	}

	@Override
	public List<Article> getFiveLastArticles() {

		List<Article> tempList = getClearList(articles);

		tempList.sort(new ArticlesDateComparator().reversed());

		List<Article> lastFive = null;

		if (tempList.size() >= 5) {
			lastFive = tempList.subList(0, 5);

		} else {
			lastFive = tempList.subList(0, tempList.size());

		}

		return lastFive;
	}

	@Override
	public List<Article> getDrafts() {

		List<Article> drafts = new ArrayList<>();

		for (Article a : articles) {
			if (!a.isReadyToPublish() && !a.isInfo())
				drafts.add(a);
		}

		return drafts;
	}

	@Override
	public void saveArticle(Article theArticle) {

		if (theArticle.getId() == 0) {
			theArticle.setId(getMaxId() + 1);
			articles.add(theArticle);

		} else {
			int index = 0;

			for (int i = 0; i < articles.size(); i++) {
				if (articles.get(i).getId() == theArticle.getId()) {
					index = i;
					break;
				}
			}

			articles.set(index, theArticle);
		}

	}

	@Override
	public Article getArticle(long id) {

		for (Article a : articles) {
			if (a.getId() == id)
				return a;
		}

		return null;
	}

	@Override
	public void deleteArticle(long theId) {
		int index = 0;
		for (int i = 0; i < articles.size(); i++) {
			if (theId == articles.get(i).getId()) {
				index = i;
				break;
			}
		}

		articles.remove(index);
	}

	@Override
	public List<Article> searchArticles(String searchString) {

		List<Article> searchedArticles;

		if (searchString != null && searchString.trim().length() > 0) {
			searchedArticles = new ArrayList<>();

			for (Article a : articles) {
				if (!a.isInfo() && a.isReadyToPublish() && (a.getTitle().toLowerCase().contains(searchString.toLowerCase())
						|| a.getBody().toLowerCase().contains(searchString.toLowerCase()))) {
					searchedArticles.add(a);
				}
			}

		} else {
			searchedArticles = getAllArticles();

		}

		return searchedArticles;
	}

	// *********************************************
	// Help method to get list without info article and ready to be published
	private long getMaxId() {
		long max = 0;

		for (Article a : articles) {
			if (a.getId() > max) {
				max = a.getId();
			}
		}

		return max;
	}

	private List<Article> getClearList(List<Article> articles) {

		List<Article> returnList = new ArrayList<>();

		for (Article a : articles) {
			if (!a.isInfo() && a.isReadyToPublish())
				returnList.add(a);
		}

		return returnList;
	}

	// Get info article
	public Article getInfoArticle() {

		for (Article a : articles) {
			if (a.isInfo())
				return a;
		}

		return null;
	}

	// Comparator
	private class ArticlesDateComparator implements Comparator<Article> {

		@Override
		public int compare(Article o1, Article o2) {
			int res = 0;

			if (o1.getPublishDate().getTime() > o2.getPublishDate().getTime()) {
				res = 1;
			} else if (o1.getPublishDate().getTime() < o2.getPublishDate().getTime()) {
				res = -1;
			}

			return res;
		}

	}

}
