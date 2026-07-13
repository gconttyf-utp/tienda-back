package org.utp.web.back.apirest.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.PedidoDTO;
import org.utp.web.back.apirest.util.TokenJwtConfig;
import org.utp.web.back.ejb.entities.enums.EstadoPedido;
import org.utp.web.back.ejb.services.PedidoEjbService;

import java.util.List;

@Path("/{tipo : usuario|cliente}/pedidos")
public class PedidoController {

    @Inject
    private PedidoEjbService pedidoEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPedidos(@PathParam("tipo") String tipo) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        List<PedidoDTO> listado = pedidoEjbService.listarTodosConDetalle();

        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPedido(@PathParam("tipo") String tipo, @PathParam("id") Integer id) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        PedidoDTO pedidoDTO = pedidoEjbService.encontrarID( id );

        return Response.ok().entity( pedidoDTO ).build();
    }

    @GET
    @Path("/cliente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPedidosCliente(@PathParam("tipo") String tipo,
                                          @HeaderParam("Authorization") String authorizationHeader) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        String loginJWT = "";
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            loginJWT = authorizationHeader.substring(7);
        }
        Claims claims = Jwts.parser()
                .verifyWith(TokenJwtConfig.SECRET_KEY)
                .build()
                .parseSignedClaims(loginJWT)
                .getPayload();
        Integer clienteID = claims.get("id", Integer.class);

        List<PedidoDTO> listado = pedidoEjbService.listarPorCliente( clienteID );

        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/clientependientepago")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerPedidosClientePendientePago(@PathParam("tipo") String tipo,
                                   @HeaderParam("Authorization") String authorizationHeader) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        String loginJWT = "";
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            loginJWT = authorizationHeader.substring(7);
        }
        Claims claims = Jwts.parser()
                .verifyWith(TokenJwtConfig.SECRET_KEY)
                .build()
                .parseSignedClaims(loginJWT)
                .getPayload();
        Integer clienteID = claims.get("id", Integer.class);

        List<PedidoDTO> listado = pedidoEjbService.listarPorClienteAndEstado( clienteID, EstadoPedido.PENDIENTE_PAGO);

        return Response.ok().entity( listado ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(@PathParam("tipo") String tipo,
                          @HeaderParam("Authorization") String authorizationHeader,
                          PedidoDTO oDTO){
        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        String loginJWT = "";
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            loginJWT = authorizationHeader.substring(7);
        }
        Claims claims = Jwts.parser()
                .verifyWith(TokenJwtConfig.SECRET_KEY)
                .build()
                .parseSignedClaims(loginJWT)
                .getPayload();
        Integer clienteID = claims.get("id", Integer.class);

        oDTO.setClienteID( clienteID );

        PedidoDTO oBD = pedidoEjbService.nuevo( oDTO );

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el pedido con datos %s", oBD));
        }
        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/actualizarpago/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarPago(@PathParam("tipo") String tipo, @PathParam("id") Integer id, @QueryParam("pago") Integer pago){
        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        PedidoDTO oDTO = pedidoEjbService.actualizarPago( id, pago );

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay pedido con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @PUT
    @Path("/actualizardespacho/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarDespacho(@PathParam("tipo") String tipo, @PathParam("id") Integer id){
        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        PedidoDTO oDTO = pedidoEjbService.actualizarDespacho( id );

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay pedido con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @PUT
    @Path("/actualizarrecojo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarRecojo(@PathParam("tipo") String tipo, @PathParam("id") Integer id){
        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        PedidoDTO oDTO = pedidoEjbService.actualizarRecojo( id );

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay pedido con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

}
