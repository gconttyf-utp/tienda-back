package org.utp.web.back.apirest.models.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenDTO {

    private Integer id;

    private Integer tiendaId;

    private Integer productoId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaIngreso;

    private Integer cantidad;

    public AlmacenDTO(Integer tiendaId, Integer productoId, Long cantidadTotal) {
        this.tiendaId = tiendaId;
        this.productoId = productoId;
        this.cantidad = (cantidadTotal != null) ? cantidadTotal.intValue() : 0;
    }
}
