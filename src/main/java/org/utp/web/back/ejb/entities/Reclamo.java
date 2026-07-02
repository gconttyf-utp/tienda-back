package org.utp.web.back.ejb.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.utp.web.back.ejb.entities.enums.EstadoReclamo;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reclamos")
public class Reclamo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación con Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    // Relación con Pedido
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = false)
    private Pedido pedido;

    // Auditoría: Se llena automáticamente al crear el reclamo
    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_atencion")
    private LocalDateTime fechaAtencion;

    // columnDefinition garantiza que se trate como TEXT y no como VARCHAR(255)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "comentario_respuesta", columnDefinition = "TEXT")
    private String comentarioRespuesta;

    // Enum mappeado como String, con valor por defecto
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReclamo estado = EstadoReclamo.PENDIENTE;

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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDateTime fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentarioRespuesta() {
        return comentarioRespuesta;
    }

    public void setComentarioRespuesta(String comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }

    public EstadoReclamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoReclamo estado) {
        this.estado = estado;
    }
    // --- FIN GETTERS Y SETTERS ---

    @Override
    public String toString() {
        return "Reclamo{" +
                "id=" + id +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaAtencion=" + fechaAtencion +
                ", comentario='" + comentario + '\'' +
                ", comentarioRespuesta='" + comentarioRespuesta + '\'' +
                ", estado=" + estado +
                '}';
    }
}
