package org.utp.web.back.apirest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer id;

    private String descripcion;

    private String sku;

    private BigDecimal precioLista;

    private BigDecimal precioOnline;

    private Integer stock;

    private Integer categoriaID;

    private Integer marcaID;

    private String rutaImg;

    private Integer estado;

    private String slug;

    private String unidad;

    private String colorPlaceholder;

    private String descripcionLarga;

    private Integer oferta;

    private Integer destacado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    private Integer descuento;

    private Boolean stockBajo;

    private Boolean agotado;

    public Integer getDescuento() {
        if ( precioLista != null && precioOnline != null ){
            BigDecimal diff = precioLista.subtract(precioOnline);
            if ( diff.signum() <= 0 ){
                return 0;
            }
            return diff.multiply(new BigDecimal(100)).divide(precioLista, 0, BigDecimal.ROUND_HALF_UP).intValue();
        }
        return 0;
    }

    public Boolean getStockBajo() {
        return stock > 0 && stock <= 5;
    }

    public Boolean getAgotado() {
        return stock <= 0;
    }

}
