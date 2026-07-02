package org.utp.web.back.apirest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalleDTO {

    private Integer id;

    private Integer pedidoID;

    private Integer productoID;

    private Integer cantidad;

    private BigDecimal subtotal;

}
