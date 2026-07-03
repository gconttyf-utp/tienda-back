package org.utp.web.back.ejb.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.utp.web.back.ejb.entities.enums.EstadoPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación con el Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    // Relación con la Tienda
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tienda_id", referencedColumnName = "id", nullable = false)
    private Tienda tienda;

    // DECIMAL(11,2) se mapea con BigDecimal para precisión financiera
    @Column(nullable = false, precision = 11, scale = 2)
    private BigDecimal total;

    // JPA mapeará el nombre del Enum como un String directamente a MySQL
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estado = EstadoPedido.PENDIENTE_PAGO;

    // Auditoría: Hibernate llena esto automáticamente en el INSERT
    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "fecha_despacho")
    private LocalDateTime fechaDespacho;

    @Column(name = "fecha_recojo")
    private LocalDateTime fechaRecojo;

    // mappedBy = "pedido" indica que el control de la llave foránea lo tiene PedidoDetalle
    // CascadeType.ALL permite que al guardar un Pedido, se guarden automáticamente sus detalles
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PedidoDetalle> detalles = new ArrayList<>();

    public void agregarDetalle(PedidoDetalle detalle){
        detalles.add(detalle);
        detalle.setPedido(this);
    }

    public void eliminarDetalle(PedidoDetalle detalle){
        detalles.remove(detalle);
        detalle.setPedido(null);
    }

    // --- GETTERS Y SETTERS ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalDateTime getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDateTime fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public LocalDateTime getFechaRecojo() {
        return fechaRecojo;
    }

    public void setFechaRecojo(LocalDateTime fechaRecojo) {
        this.fechaRecojo = fechaRecojo;
    }

    public List<PedidoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PedidoDetalle> detalles) {
        this.detalles = detalles;
    }
    // --- FIN GETTERS Y SETTERS ---

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", total=" + total +
                ", estado=" + estado +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaPago=" + fechaPago +
                ", fechaDespacho=" + fechaDespacho +
                ", fechaRecojo=" + fechaRecojo +
                ", detalles.size=" + (detalles != null ? detalles.size() : "null") +
                '}';
    }
}
