package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utp.web.back.apirest.models.dto.PedidoDTO;
import org.utp.web.back.apirest.models.mappers.PedidoMapper;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.entities.Pedido;
import org.utp.web.back.ejb.entities.Producto;
import org.utp.web.back.ejb.entities.Tienda;
import org.utp.web.back.ejb.entities.enums.EstadoPedido;
import org.utp.web.back.ejb.repositories.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Stateless
public class PedidoEjbServiceImpl implements PedidoEjbService {

    @Inject
    private PedidoRepository repository;

    @Inject
    private PedidoDetalleRepository detalleRepository;

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private TiendaRepository tiendaRepository;

    @Inject
    private ProductoRepository productoRepository;

    @Inject
    private PedidoMapper mapper;

    @Override
    public PedidoDTO nuevo(PedidoDTO oDTO) {
        System.out.println("Pedido DTO entrante= " + oDTO);

        // 1. Convertir el DTO a una entidad Pedido (aún con referencias transient)
        Pedido pedidoEntity = mapper.toEntity(oDTO);

        // 2. Reemplazar las entidades 'stub' con entidades 'managed' de la BD
        Cliente cliente = clienteRepository.findById(oDTO.getClienteID())
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado con ID: " + oDTO.getClienteID()));
        Tienda tienda = tiendaRepository.findById(oDTO.getTiendaID())
                .orElseThrow(() -> new NoSuchElementException("Tienda no encontrada con ID: " + oDTO.getTiendaID()));

        pedidoEntity.setCliente(cliente);
        pedidoEntity.setTienda(tienda);

        pedidoEntity.setEstado(EstadoPedido.PENDIENTE_PAGO);
        pedidoEntity.setFechaCreacion(LocalDateTime.now());

        System.out.println("pedidoEntity a guardar= " + pedidoEntity);

        // 3. Guardar la entidad Pedido principal PRIMERO
        Pedido pedidoGuardado = repository.save(pedidoEntity);

        // 4. Sincronizar y guardar manualmente cada detalle
        if (pedidoEntity.getDetalles() != null) {
            for (int i = 0; i < pedidoEntity.getDetalles().size(); i++) {
                var detalleEntity = pedidoEntity.getDetalles().get(i);
                var detalleDTO = oDTO.getDetalles().get(i);

                Producto producto = productoRepository.findById(detalleDTO.getProductoID())
                        .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + detalleDTO.getProductoID()));

                detalleEntity.setProducto(producto);
                detalleEntity.setPedido(pedidoGuardado); // Sincronización con el pedido YA guardado

                detalleRepository.save(detalleEntity); // Guardado manual del detalle
            }
        }

        // 5. Convertir la entidad guardada de nuevo a DTO para devolverla
        return mapper.toDTO(pedidoGuardado);

    }

    @Override
    public PedidoDTO actualizarPago(Integer id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("El ID del pedido es requerido para actualizar el pago.");
        }
        
        int n = repository.confirmarPago( id, EstadoPedido.PENDIENTE_DESPACHO, LocalDateTime.now() );

        if ( n <= 0 ){
            return null;
        }

        PedidoDTO pedido = mapper.toDTO( repository.encontrarID( id ) );

        return pedido;
    }

    @Override
    public PedidoDTO actualizarDespacho(Integer id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("El ID del pedido es requerido para actualizar el pago.");
        }

        int n = repository.confirmarDespacho( id, EstadoPedido.PENDIENTE_ENTREGA, LocalDateTime.now() );

        if ( n <= 0 ){
            return null;
        }

        PedidoDTO pedido = mapper.toDTO( repository.encontrarID( id ) );

        return pedido;
    }

    @Override
    public PedidoDTO actualizarRecojo(Integer id) {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("El ID del pedido es requerido para actualizar el pago.");
        }

        int n = repository.confirmarRecojo( id, EstadoPedido.ENTREGADO, LocalDateTime.now() );

        if ( n <= 0 ){
            return null;
        }

        PedidoDTO pedido = mapper.toDTO( repository.encontrarID( id ) );

        return pedido;
    }

    @Override
    public List<PedidoDTO> listarTodos() {
        return mapper.toDTOList(repository.findAll().toList());
    }

    @Override
    public PedidoDTO encontrarID(Integer id) {
        return mapper.toDTO(repository.findById(id).orElse(null));
    }

    @Override
    public List<PedidoDTO> listarPorCliente(Integer clienteId) {
        return mapper.toDTOList(repository.findByClienteId(clienteId));
    }

    @Override
    public List<PedidoDTO> listarPorTienda(Integer tiendaId) {
        return mapper.toDTOList(repository.findByTiendaId(tiendaId));
    }

    @Override
    public List<PedidoDTO> listarPorEstado(EstadoPedido estado) {
        return mapper.toDTOList(repository.findByEstado(estado));
    }

    @Override
    public List<PedidoDTO> listarPendientePago() {
        return mapper.toDTOList(repository.findPendientesDePago());
    }

    @Override
    public List<PedidoDTO> listarTodosConDetalle() {
        return mapper.toDTOList(repository.findAllWithDetalles());
    }

    @Override
    public List<PedidoDTO> listarPorClienteAndEstado(Integer clienteId, EstadoPedido estado) {
        return mapper.toDTOList(repository.findByClienteAndEstado(clienteId, estado));
    }
}
