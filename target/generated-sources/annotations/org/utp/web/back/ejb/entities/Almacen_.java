package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Almacen.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Almacen_ {

	public static final String FECHA_INGRESO = "fechaIngreso";
	public static final String TIENDA = "tienda";
	public static final String ID = "id";
	public static final String PRODUCTO = "producto";
	public static final String CANTIDAD = "cantidad";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Almacen#fechaIngreso
	 **/
	public static volatile SingularAttribute<Almacen, LocalDateTime> fechaIngreso;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Almacen#tienda
	 **/
	public static volatile SingularAttribute<Almacen, Tienda> tienda;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Almacen#id
	 **/
	public static volatile SingularAttribute<Almacen, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Almacen#producto
	 **/
	public static volatile SingularAttribute<Almacen, Producto> producto;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Almacen#cantidad
	 **/
	public static volatile SingularAttribute<Almacen, Integer> cantidad;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Almacen
	 **/
	public static volatile EntityType<Almacen> class_;

}

