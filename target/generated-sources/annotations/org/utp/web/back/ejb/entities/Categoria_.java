package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Categoria.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Categoria_ {

	public static final String ESTADO = "estado";
	public static final String GRUPO = "grupo";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String PRODUCTOS = "productos";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Categoria#estado
	 **/
	public static volatile SingularAttribute<Categoria, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Categoria#grupo
	 **/
	public static volatile SingularAttribute<Categoria, Grupo> grupo;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Categoria#id
	 **/
	public static volatile SingularAttribute<Categoria, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Categoria
	 **/
	public static volatile EntityType<Categoria> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Categoria#nombre
	 **/
	public static volatile SingularAttribute<Categoria, String> nombre;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Categoria#productos
	 **/
	public static volatile ListAttribute<Categoria, Producto> productos;

}

