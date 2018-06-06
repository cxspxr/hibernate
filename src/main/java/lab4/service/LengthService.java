package lab4.service;

import lab4.dao.LengthDAO;
import lab4.model.Length;
import java.util.List;

public class LengthService {
    private static LengthDAO lengthDao;

    public LengthService() {
        lengthDao = new LengthDAO();
    }

    public void persist(Length entity) {
        lengthDao.openCurrentSessionwithTransaction();
        lengthDao.persist(entity);
        lengthDao.closeCurrentSessionwithTransaction();
    }
    public void update(Length entity) {
        lengthDao.openCurrentSessionwithTransaction();
        lengthDao.update(entity);
        lengthDao.closeCurrentSessionwithTransaction();
    }
    public Length findById(Integer id) {
        lengthDao.openCurrentSession();
        Length declaration = lengthDao.findById(id);
        lengthDao.closeCurrentSession();
        return declaration;
    }
    public void delete(Integer id) {
        lengthDao.openCurrentSessionwithTransaction();
        Length declaration = lengthDao.findById(id);
        lengthDao.delete(declaration);
        lengthDao.closeCurrentSessionwithTransaction();
    }
    public List<Length> findAll() {
        lengthDao.openCurrentSession();
        List<Length> declarations = lengthDao.findAll();
        lengthDao.closeCurrentSession();
        return declarations;
    }
    public void deleteAll() {
        lengthDao.openCurrentSessionwithTransaction();
        lengthDao.deleteAll();
        lengthDao.closeCurrentSessionwithTransaction();
    }
    public LengthDAO lengthDao() {
        return lengthDao;
    }
}
