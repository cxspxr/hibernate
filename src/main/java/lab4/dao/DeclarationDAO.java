package lab4.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import lab4.model.Declaration;

public class DeclarationDAO implements DAOInterface<Declaration, String> {
    private Session currentSession;
    private Transaction currentTransaction;

    public DeclarationDAO() {

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

    public void persist(Declaration entity) {
        getCurrentSession().save(entity);
    }

    public void update(Declaration entity) {
        getCurrentSession().update(entity);
    }

    public Declaration findById(String id) {
        return (Declaration) getCurrentSession().get(Declaration.class, id);
    }

    public void delete(Declaration entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Declaration> findAll() {
        return (List<Declaration>) getCurrentSession().createQuery("from Declaration").list();
    }

    public void deleteAll() {
        List<Declaration> entityList = findAll();
        for (Declaration entity : entityList) {
            delete(entity);
        }
    }
}