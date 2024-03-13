package br.edu.iftm.lco.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.lco.ecommerce.dto.ClientePedidoDTO;

@Component
public class ClientePedidoDao {
    
    @Autowired
    private JdbcTemplate db;

    public List<ClientePedidoDTO> getClientesPedidos() {
        String sql = "select c.nome,coalesce(sum(dp.precoVenda * dp. quantidade),0) as total\r\n" + //
                        "from clientes c \r\n" + //
                        "   left join pedidos p on c.clienteID = p.clienteID\r\n" + //
                        "   left join detalhes_pedido dp on p.pedidoID = dp.pedidoID\r\n" + //
                        "group by c.nome\r\n" + //
                        "order by total\r\n" + //
                        "";
        return db.query(sql, (res, rowNum) -> {
            return new ClientePedidoDTO(
                    res.getString("nome"),
                    res.getDouble("total"));
        });

    }

}
