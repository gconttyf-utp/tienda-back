package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@StaticMetamodel(Producto.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Producto_ {

	public static final String DESCRIPCION = "descripcion";
	public static final String ESTADO = "estado";
	public static final String PRECIO_ONLINE = "precioOnline";
	public static final String OFERTA = "oferta";
	public static final String CATEGORIA = "categoria";
	public static final String COLOR_PLACEHOLDER = "colorPlaceholder";
	public static final String RUTA_IMG = "rutaImg";
	public static final String UNIDAD = "unidad";
	public static final String DESCRIPCION_LARGA = "descripcionLarga";
	public static final String CREATED_AT = "createdAt";
	public static final String MARCA = "marca";
	public static final String PRECIO_LISTA = "precioLista";
	public static final String ID = "id";
	public static final String SKU = "sku";
	public static final String STOCK = "stock";
	public static final String SLUG = "slug";
	public static final String DESTACADO = "destacado";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#descripcion
	 **/
	public static volatile SingularAttribute<Producto, String> descripcion;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#estado
	 **/
	public static volatile SingularAttribute<Producto, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#precioOnline
	 **/
	public static volatile SingularAttribute<Producto, BigDecimal> precioOnline;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#oferta
	 **/
	public static volatile SingularAttribute<Producto, Integer> oferta;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#categoria
	 **/
	public static volatile SingularAttribute<Producto, Categoria> categoria;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#colorPlaceholder
	 **/
	public static volatile SingularAttribute<Producto, String> colorPlaceholder;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#rutaImg
	 **/
	public static volatile SingularAttribute<Producto, String> rutaImg;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#unidad
	 **/
	public static volatile SingularAttribute<Producto, String> unidad;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#descripcionLarga
	 **/
	public static volatile SingularAttribute<Producto, String> descripcionLarga;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#createdAt
	 **/
	public static volatile SingularAttribute<Producto, LocalDateTime> createdAt;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#marca
	 **/
	public static volatile SingularAttribute<Producto, Marca> marca;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#precioLista
	 **/
	public static volatile SingularAttribute<Producto, BigDecimal> precioLista;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#id
	 **/
	public static volatile SingularAttribute<Producto, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#sku
	 **/
	public static volatile SingularAttribute<Producto, String> sku;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#stock
	 **/
	public static volatile SingularAttribute<Producto, Integer> stock;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto
	 **/
	public static volatile EntityType<Producto> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#slug
	 **/
	public static volatile SingularAttribute<Producto, String> slug;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Producto#destacado
	 **/
	public static volatile SingularAttribute<Producto, Integer> destacado;

}

