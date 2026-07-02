package org.utp.web.back.apirest.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/{tipo : usuario|cliente}/pedidos")
public class PedidoController {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPedidos() {
        return Response.ok("Lista de reclamos para: ").build();
    }

}
