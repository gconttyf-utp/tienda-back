package org.utp.web.back.ejb.services;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.apirest.util.LoginTypeContext;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.entities.Usuario;
import org.utp.web.back.ejb.repositories.ClienteRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.repositories.UsuarioRepository;

@Stateless
public class AutorizacionServiceImpl implements AutorizacionService{

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private LoginTypeContext loginContext;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Cliente login(String correo, Integer estado) {
        return clienteRepository.findByCorreoAndEstado(correo, estado).orElse(null);
    }

    @Override
    public Cliente registrar(Cliente cliente) {
        //return repository.save(cliente);
        return clienteRepository.insertar(cliente);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Usuario loginUsuario(String usuario, Integer estado) {
        return usuarioRepository.findByUsuarioAndEstado(usuario, estado).orElse(null);
    }

}
