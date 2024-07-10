package br.edu.iftm.lco.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.lco.ecommerce.dao.CategoriaDao;
import br.edu.iftm.lco.ecommerce.dao.domain.Categoria;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaDao dao;
    
    @RequestMapping(value = "/categoria/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> 
                                GetById(@PathVariable(value = "id") Integer id) {
        List<Categoria> categorias = dao.getCategorias(id);
        if (categorias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categorias);
    }

    @RequestMapping(value = "/categoria/{nome}", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> GetByNome(@PathVariable(value = "nome") String nome) {
        List<Categoria> categorias = dao.getCategorias(nome);
        if (categorias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categorias);
    }

}
