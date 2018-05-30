package lab4.service;
import lab4.dao.GirlDAO;
import lab4.model.Girl;
import java.util.List;

public class GirlService {
    private static GirlDAO girlDao;

    public GirlService() {
        girlDao = new GirlDAO();
    }
    public void persist(Girl entity) {
        girlDao.openCurrentSessionwithTransaction();
        girlDao.persist(entity);
        girlDao.closeCurrentSessionwithTransaction();
    }
    public void update(Girl entity) {
        girlDao.openCurrentSessionwithTransaction();
        girlDao.update(entity);
        girlDao.closeCurrentSessionwithTransaction();
    }
    public Girl findById(Integer id) {
        girlDao.openCurrentSession();
        Girl girl = girlDao.findById(id);
        girlDao.closeCurrentSession();
        return girl;
    }
    public void delete(Integer id) {
        girlDao.openCurrentSessionwithTransaction();
        Girl girl = girlDao.findById(id);
        girlDao.delete(girl);
        girlDao.closeCurrentSessionwithTransaction();
    }
    public List<Girl> findAll() {
        girlDao.openCurrentSession();
        List<Girl> girls = girlDao.findAll();
        girlDao.closeCurrentSession();
        return girls;
    }
    public void deleteAll() {
        girlDao.openCurrentSessionwithTransaction();
        girlDao.deleteAll();
        girlDao.closeCurrentSessionwithTransaction();
    }
    public GirlDAO girlDao() {
        return girlDao;
    }
}
