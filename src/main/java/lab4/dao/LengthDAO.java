package lab4.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import lab4.model.Length;

public class LengthDAO implements DAOInterface<Length, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    public LengthDAO() {

    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Length entity) {
        getCurrentSession().save(entity);
    }

    public void update(Length entity) {
        getCurrentSession().update(entity);
    }

    public Length findById(Integer id) {
        return (Length) getCurrentSession().get(Length.class, id);
    }

    public void delete(Length entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Length> findAll() {
        return (List<Length>) getCurrentSession().createQuery("from Length").list();
    }

    public void deleteAll() {
        List<Length> entityList = findAll();
        for (Length entity : entityList) {
            delete(entity);
        }
    }
}