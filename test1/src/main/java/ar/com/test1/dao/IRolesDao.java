/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.test1.dao;

import ar.com.test1.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author gonza
 */
@Repository
public interface IRolesDao extends JpaRepository<Roles, Integer> {
    @Query("select c from Roles c where c.descrip like ?1")
    public List<Roles> findByDescrip(String name);
}
