package org.utp.web.back.ejb.services;

import org.utp.web.back.apirest.models.dto.ReporteDTO;

import java.util.List;

public interface ReporteEjbService {

    List<ReporteDTO> reporteDiario();

    List<ReporteDTO> reporteSemanal();

    List<ReporteDTO> reporteMensual();

}
