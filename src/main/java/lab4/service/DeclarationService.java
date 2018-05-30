package lab4.service;

import lab4.dao.DeclarationDAO;
import lab4.model.Declaration;
import java.util.List;

public class DeclarationService {
    private static DeclarationDAO declarationDao;

    public DeclarationService() {
        declarationDao = new DeclarationDAO();
    }
    public void persist(Declaration entity) {
        declarationDao.openCurrentSessionwithTransaction();
        declarationDao.persist(entity);
        declarationDao.closeCurrentSessionwithTransaction();
    }
    public void update(Declaration entity) {
        declarationDao.openCurrentSessionwithTransaction();
        declarationDao.update(entity);
        declarationDao.closeCurrentSessionwithTransaction();
    }
    public Declaration findById(String id) {
        declarationDao.openCurrentSession();
        Declaration declaration = declarationDao.findById(id);
        declarationDao.closeCurrentSession();
        return declaration;
    }
    public void delete(String id) {
        declarationDao.openCurrentSessionwithTransaction();
        Declaration declaration = declarationDao.findById(id);
        declarationDao.delete(declaration);
        declarationDao.closeCurrentSessionwithTransaction();
    }
    public List<Declaration> findAll() {
        declarationDao.openCurrentSession();
        List<Declaration> declarations = declarationDao.findAll();
        declarationDao.closeCurrentSession();
        return declarations;
    }
    public void deleteAll() {
        declarationDao.openCurrentSessionwithTransaction();
        declarationDao.deleteAll();
        declarationDao.closeCurrentSessionwithTransaction();
    }
    public DeclarationDAO declarationDao() {
        return declarationDao;
    }
}
