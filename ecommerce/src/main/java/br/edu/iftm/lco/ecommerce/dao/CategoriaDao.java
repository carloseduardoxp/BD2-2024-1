package br.edu.iftm.lco.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.lco.ecommerce.dao.domain.Categoria;

@Component
public class CategoriaDao {

    @Autowired
    private JdbcTemplate db;

    public List<Categoria> getCategorias() {
        String sql = "select categoriaID, categoria, descricao from categorias";
        return db.query(sql, (res, rowNum) -> {
            return new Categoria(
                    res.getInt("categoriaID"),
                    res.getString("categoria"),
                    res.getString("descricao"));
        });

    }

    public List<Categoria> getCategoriasId(Integer id) {
        String sql = "call sp_listar_categorias(?);";
        return db.query(sql, (res, rowNum) -> {
            return new Categoria(
                    res.getInt("categoriaID"),
                    res.getString("categoria"),
                    res.getString("descricao"));
        },new Object[] { id });
    }


    public List<Categoria> getCategorias(String nome) {
        String sql = "select categoriaID, categoria, descricao from categorias where lower(categoria) like ?";
        return db.query(sql, (res, rowNum) -> {
            return new Categoria(
                    res.getInt("categoriaID"),
                    res.getString("categoria"),
                    res.getString("descricao"));
        },new Object[] { "%" + nome + "%" });
    }
}
