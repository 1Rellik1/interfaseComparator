package Homework.sixteenth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
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


}
