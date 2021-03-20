package Homework.fifteenth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class LevelTest {
    @Autowired
    private final SessionFactory sessionFactory;

    public LevelTest(SessionFactory sessionFactory) {
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

    public void addLevel(Level level) {
        session.beginTransaction();
        session.saveOrUpdate(level);
        session.getTransaction().commit();
    }

    public List<Level> getLevels() {
        return session.createQuery("select p from Level p", Level.class).list();
    }



    public void deleteLevel(UUID id) {

        session.beginTransaction();

        Level temp = session.load(Level.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
}
