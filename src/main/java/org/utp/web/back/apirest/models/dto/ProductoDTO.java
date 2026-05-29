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
    
}
