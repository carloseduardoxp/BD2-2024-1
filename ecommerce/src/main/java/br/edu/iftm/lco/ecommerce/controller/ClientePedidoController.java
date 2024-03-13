package br.edu.iftm.lco.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.lco.ecommerce.dao.ClientePedidoDao;
import br.edu.iftm.lco.ecommerce.dto.ClientePedidoDTO;

@RestController
public class ClientePedidoController {

    @Autowired
    private ClientePedidoDao dao;

    @RequestMapping(value = "/clientePedido", method = RequestMethod.GET)
    public List<ClientePedidoDTO> getClientesPedidos() {
        return dao.getClientesPedidos();
    }
    
}
