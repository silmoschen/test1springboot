/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.test1.servicesimp;

import java.util.List;
import javax.transaction.Transactional;

import ar.com.test1.dao.IRolesDao;
import ar.com.test1.entities.Roles;
import ar.com.test1.sevices.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonza
 */
@Service
public class RolesService implements IRolesService {

    @Autowired
    private IRolesDao entityDao;

    public List<Roles> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descrip"));
    }

    public List<Roles> findByDescrip(String descrip) {
        return entityDao.findByDescrip("%" + descrip + "%");
    }

    public Roles get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Roles entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Roles entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
