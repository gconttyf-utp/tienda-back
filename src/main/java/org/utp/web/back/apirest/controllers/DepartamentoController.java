package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.DepartamentoDTO;
import org.utp.web.back.ejb.services.DepartamentoEjbService;

@Path("/usuario/departamentos")
public class DepartamentoController {

    @Inject
    private DepartamentoEjbService departamentoEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDepartamentos(@QueryParam("estado") List<Integer> estados){
        System.out.println("departamento.listar()");

        // 1. Definimos exactamente qué estados vamos a consultar en la BD
        List<Integer> estadosConsultados = (estados == null || estados.isEmpty()) ? List.of(0, 1) : estados;

        // 2. Ejecutamos la consulta con la lista limpia
        List<DepartamentoDTO> listarDepartamentos = departamentoEjbService.listarDepartamentos( estadosConsultados );

        if (listarDepartamentos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay departamentos para los estados %s", estadosConsultados));
        }
        return Response.ok().entity( listarDepartamentos ).build();
    }

}
