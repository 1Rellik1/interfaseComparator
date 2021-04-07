package Homework.seventeenth;

import Homework.seventeenth.Entities.Game;
import Homework.seventeenth.Entities.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

@Service

public class GameTest {
    @Autowired
    private final SessionFactory sessionFactory;

    public GameTest(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Game> gameCriteriaQuery;
    private Root<Game> root;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        gameCriteriaQuery = builder.createQuery(Game.class);
        root = gameCriteriaQuery.from(Game.class);
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void addGame(Game game) {
        session.beginTransaction();
        session.saveOrUpdate(game);
        session.getTransaction().commit();
    }

    public List<Game> getGames() {
        return session.createQuery("select mn from Game mn", Game.class).list();
    }


    public void deleteGame(UUID id) {
        session.beginTransaction();

        Game temp = session.load(Game.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }

    public void delete(Game game) {
        session.beginTransaction();

        List<Level> query = session.createQuery("select s from Level where name = '" +
                game.getName() + "' and complexity = '" + game.getCreationYear() + "'", Level.class).list();
        for (Level lvl: query){
            session.delete(lvl);
        }

        session.getTransaction().commit();
    }
    public List<Game> getByName() {
        gameCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Game> query = session.createQuery(gameCriteriaQuery);
        return query.getResultList();
    }

    public List<Game> getByYear() {
        gameCriteriaQuery.select(root).orderBy(builder.asc(root.get("creationYear")));
        Query<Game> query = session.createQuery(gameCriteriaQuery);
        return query.getResultList();
    }
}
