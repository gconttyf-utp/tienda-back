package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Tienda.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Tienda_ {

	public static final String LATITUD = "latitud";
	public static final String LONGITUD = "longitud";
	public static final String ESTADO = "estado";
	public static final String HORARIO = "horario";
	public static final String ALMACENES = "almacenes";
	public static final String DIRECCION = "direccion";
	public static final String UBIGEO = "ubigeo";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String IMAGEN_URL = "imagenUrl";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#latitud
	 **/
	public static volatile SingularAttribute<Tienda, Double> latitud;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#longitud
	 **/
	public static volatile SingularAttribute<Tienda, Double> longitud;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#estado
	 **/
	public static volatile SingularAttribute<Tienda, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#horario
	 **/
	public static volatile SingularAttribute<Tienda, String> horario;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#almacenes
	 **/
	public static volatile ListAttribute<Tienda, Almacen> almacenes;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#direccion
	 **/
	public static volatile SingularAttribute<Tienda, String> direccion;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#ubigeo
	 **/
	public static volatile SingularAttribute<Tienda, Ubigeo> ubigeo;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#id
	 **/
	public static volatile SingularAttribute<Tienda, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#telefono
	 **/
	public static volatile SingularAttribute<Tienda, String> telefono;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda
	 **/
	public static volatile EntityType<Tienda> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#nombre
	 **/
	public static volatile SingularAttribute<Tienda, String> nombre;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Tienda#imagenUrl
	 **/
	public static volatile SingularAttribute<Tienda, String> imagenUrl;

}

