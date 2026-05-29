package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Marca.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Marca_ {

	public static final String ESTADO = "estado";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String PRODUCTOS = "productos";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Marca#estado
	 **/
	public static volatile SingularAttribute<Marca, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Marca#id
	 **/
	public static volatile SingularAttribute<Marca, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Marca
	 **/
	public static volatile EntityType<Marca> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Marca#nombre
	 **/
	public static volatile SingularAttribute<Marca, String> nombre;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Marca#productos
	 **/
	public static volatile ListAttribute<Marca, Producto> productos;

}

