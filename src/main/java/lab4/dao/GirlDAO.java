package lab4.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import lab4.model.Girl;

public class GirlDAO implements DAOInterface<Girl, Integer>{
    private Session currentSession;
    private Transaction currentTransaction;

    public GirlDAO(){

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

    public void persist(Girl entity) {
        getCurrentSession().save(entity);
    }

    public void update(Girl entity) {
        getCurrentSession().update(entity);
    }

    public Girl findById(Integer id) {
        return (Girl) getCurrentSession().get(Girl.class, id);
    }

    public void delete(Girl entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Girl> findAll() {
        return (List<Girl>) getCurrentSession().createQuery("from Girl").list();
    }

    public void deleteAll() {
        List<Girl> entityList = findAll();
        for (Girl entity : entityList) {
            delete(entity);
        }
    }
}
