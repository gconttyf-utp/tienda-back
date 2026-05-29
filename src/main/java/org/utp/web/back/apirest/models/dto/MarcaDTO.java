package org.utp.web.back.apirest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {

    private Integer id;

    private String nombre;

    private Integer estado;
}
