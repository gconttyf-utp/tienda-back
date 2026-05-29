package org.utp.web.back.ejb.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tiendas")
public class Tienda implements Serializable {
    private static final long serialVersionUID = 16523152L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String direccion;

    private String horario;

    private String telefono;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "lat")
    private Double latitud;

    @Column(name = "lng")
    private Double longitud;

    private Integer estado;

    @OneToMany(mappedBy = "tienda", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Almacen> almacenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_ubigeo", referencedColumnName = "cod_ubigeo", nullable = false)
    private Ubigeo ubigeo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", horario='" + horario + '\'' +
                ", telefono='" + telefono + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", estado=" + estado +
                '}';
    }
}
