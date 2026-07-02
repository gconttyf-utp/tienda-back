package org.utp.web.back.apirest.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

// La ruta acepta un parámetro "tipo" que estrictamente debe ser "usuario" o "cliente"
@Path("/{tipo : usuario|cliente}/reclamos")
public class ReclamoController {

    @GET
    @Path("/")
    public Response obtenerReclamos(@PathParam("tipo") String tipo) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        return Response.ok("Lista de reclamos para: " + tipo).build();
    }

}
