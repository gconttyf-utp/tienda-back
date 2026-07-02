package org.utp.web.back.apirest.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.utp.web.back.ejb.entities.enums.EstadoReclamo;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReclamoDTO {

    private Integer id;

    private Integer clienteID;

    private Integer pedidoID;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaCreacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaAtencion;

    private String comentario;

    private String comentarioRespuesta;

    private EstadoReclamo estado = EstadoReclamo.PENDIENTE;
}
