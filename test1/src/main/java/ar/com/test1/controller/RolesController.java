package ar.com.test1.controller;

import java.util.List;

import ar.com.test1.entities.Roles;
import ar.com.test1.sevices.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RolesController {

    @Autowired
    IRolesService entityService;
    
    @GetMapping(path = "/roles")
    public List<Roles> getAll() {
        return entityService.getAll();
    }

    @GetMapping(path = "/roles/{id}")
    public Roles get(@PathVariable Integer id) {
        return entityService.get(id);
    }

    @GetMapping(path = "/roles/search/{expresion}")
    public List<Roles> getListRoles(@PathVariable String expresion) {
        return entityService.findByDescrip(expresion);
    }

    @PostMapping(value = "/roles", consumes = "application/json", produces = "application/json")
    public Roles save(@RequestBody Roles entity) {
        entityService.save(entity);
        return entity;
    }

    @GetMapping(path = "/roles/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Roles entity = null;
         try {
            entity = entityService.get(id);
            entityService.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
         
    }

}
