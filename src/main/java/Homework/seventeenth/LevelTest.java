package Homework.seventeenth;


import Homework.seventeenth.Entities.Game;
import Homework.seventeenth.Entities.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    private CriteriaBuilder builder;
    private CriteriaQuery<Level> CriteriaQuery;
    private Root<Level> root;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        CriteriaQuery = builder.createQuery(Level.class);
        root = CriteriaQuery.from(Level.class);

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

    public Game getGame(UUID id){
        return session.createQuery("from Level where id = :id", Level.class)
                .setParameter("id",id).getSingleResult().getGame();
    }

    public void deleteLevel(UUID id) {
        session.beginTransaction();

        Level temp = session.load(Level.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
    public void delete(Level level) {
        session.beginTransaction();

        List<Level> query = session.createQuery("select s from Level where name = '" +
                level.getName() + "' and complexity = '" + level.getComplexity() + "'", Level.class).list();
        for (Level lvl: query){
            session.delete(lvl);
        }

        session.getTransaction().commit();
    }
    public List<Level> getByName() {
        CriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Level> query = session.createQuery(CriteriaQuery);
        return query.getResultList();
    }

    public List<Level> getByCmp() {
        CriteriaQuery.select(root).orderBy(builder.asc(root.get("Complexity")));
        Query<Level> query = session.createQuery(CriteriaQuery);
        return query.getResultList();
    }
}