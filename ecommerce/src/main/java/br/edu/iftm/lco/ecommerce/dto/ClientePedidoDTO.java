package br.edu.iftm.lco.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientePedidoDTO {
    
    private String nome;

    private Double total;


}
