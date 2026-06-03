package org.utp.web.back.apirest.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.apirest.models.dto.LoginDTO;
import org.utp.web.back.apirest.services.LoginService;
import org.utp.web.back.apirest.util.LoginTypeContext;

@Path("/autorizacion/login")
@RequestScoped
public class LoginController {

    @Inject
    private LoginService service;

    @Inject
    private LoginTypeContext loginContext;

    @POST
    @Path("/cliente")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@BeanParam LoginDTO loginDTO){
        System.out.println("LoginController.acceder");
        System.out.println("Usuario: " + loginDTO.getUsuario());
        System.out.println("Clave: " + loginDTO.getClave());
        System.out.println("Grant type: " + loginDTO.getGrant_type());
        if ( "acceso_web".equals(loginDTO.getGrant_type()) ){
            loginContext.setUsuarioLogin(false);
            return Response.status(Response.Status.ACCEPTED)
                    .entity(service.loginClienteJWT(loginDTO))
                    .build();
        }else{
            throw new NotAuthorizedException("Las credenciales proporcionadas no son válidas en el sistema.");
        }
    }

    @POST
    @Path("/cliente/registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registro(ClienteDTO clienteDTO){
        ClienteDTO clienteDTODB = service.registrarCliente(clienteDTO);
        if ( clienteDTODB != null ){
            return Response.status(Response.Status.CREATED)
                    .entity(clienteDTODB)
                    .build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("/usuario")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUsuario(@BeanParam LoginDTO loginDTO) {
        System.out.println("LoginController.accederUsuario");
        System.out.println("Usuario: " + loginDTO.getUsuario());
        System.out.println("Clave: " + loginDTO.getClave());
        System.out.println("Grant type: " + loginDTO.getGrant_type());
        
        if ( "acceso_web".equals(loginDTO.getGrant_type()) ){
            loginContext.setUsuarioLogin(true);
            return Response.status(Response.Status.ACCEPTED)
                    .entity(service.loginUsuarioJWT(loginDTO))
                    .build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
