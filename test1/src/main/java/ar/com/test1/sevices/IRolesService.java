/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.test1.sevices;


import ar.com.test1.entities.Roles;

import java.util.List;

/**
 *
 * @author gonza
 */
public interface IRolesService {
    List<Roles> getAll();
    List<Roles> findByDescrip(String descrip);
    Roles get(Integer id);
    void save(Roles entity);
    String delete(Roles entity);
}
