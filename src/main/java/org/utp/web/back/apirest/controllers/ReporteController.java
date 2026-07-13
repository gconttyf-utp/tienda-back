package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.models.dto.ReporteDTO;
import org.utp.web.back.ejb.services.ReporteEjbService;

import java.util.List;

@Path("/usuario/reportes")
public class ReporteController {

    @Inject
    private ReporteEjbService reporteService;

    @GET
    @Path("/diario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reporteDiario() {
        List<ReporteDTO> reporte = reporteService.reporteDiario();
        return Response.ok(reporte).build();
    }

    @GET
    @Path("/semanal")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reporteSemanal() {
        List<ReporteDTO> reporte = reporteService.reporteSemanal();
        return Response.ok(reporte).build();
    }

    @GET
    @Path("/mensual")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reporteMensual() {
        List<ReporteDTO> reporte = reporteService.reporteMensual();
        return Response.ok(reporte).build();
    }
}
