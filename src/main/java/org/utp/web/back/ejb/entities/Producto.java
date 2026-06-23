package org.utp.web.back.ejb.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 15632541258L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    private String sku;

    @Column(name = "precio_lista")
    private BigDecimal precioLista;

    @Column(name = "precio_online")
    private BigDecimal precioOnline;

    private Integer stock;

    @Column(name = "ruta_img")
    private String rutaImg;

    private Integer estado;

    private String slug;

    private String unidad;

    @Column(name = "color_placeholder")
    private String colorPlaceholder;

    @Column(name = "descripcion_larga")
    private String descripcionLarga;

    private Integer oferta;

    private Integer destacado;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)    
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", referencedColumnName = "id", nullable = false)
    private Marca marca;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(BigDecimal precioLista) {
        this.precioLista = precioLista;
    }

    public BigDecimal getPrecioOnline() {
        return precioOnline;
    }

    public void setPrecioOnline(BigDecimal precioOnline) {
        this.precioOnline = precioOnline;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getColorPlaceholder() {
        return colorPlaceholder;
    }

    public void setColorPlaceholder(String colorPlaceholder) {
        this.colorPlaceholder = colorPlaceholder;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public Integer getOferta() {
        return oferta;
    }

    public void setOferta(Integer oferta) {
        this.oferta = oferta;
    }

    public Integer getDestacado() {
        return destacado;
    }

    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        if (createdAt != null) {
            this.createdAt = createdAt;
        } else if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", sku='" + sku + '\'' +
                ", precioLista=" + precioLista +
                ", precioOnline=" + precioOnline +
                ", stock=" + stock +
                ", rutaImg='" + rutaImg + '\'' +
                ", estado=" + estado +
                ", slug='" + slug + '\'' +
                ", unidad='" + unidad + '\'' +
                ", colorPlaceholder='" + colorPlaceholder + '\'' +
                ", descripcionLarga='" + descripcionLarga + '\'' +
                ", oferta=" + oferta +
                ", destacado=" + destacado +
                ", createdAt=" + createdAt +
                '}';
    }
}
