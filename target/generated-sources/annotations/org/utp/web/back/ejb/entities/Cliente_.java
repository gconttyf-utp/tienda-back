package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cliente.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Cliente_ {

	public static final String APELLIDOS = "apellidos";
	public static final String CLAVE = "clave";
	public static final String ESTADO = "estado";
	public static final String CORREO = "correo";
	public static final String ID = "id";
	public static final String NOMBRES = "nombres";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Cliente#apellidos
	 **/
	public static volatile SingularAttribute<Cliente, String> apellidos;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Cliente#clave
	 **/
	public static volatile SingularAttribute<Cliente, String> clave;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Cliente#estado
	 **/
	public static volatile SingularAttribute<Cliente, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Cliente#correo
	 **/
	public static volatile SingularAttribute<Cliente, String> correo;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Cliente#id
	 **/
	public static volatile SingularAttribute<Cliente, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Cliente
	 **/
	public static volatile EntityType<Cliente> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Cliente#nombres
	 **/
	public static volatile SingularAttribute<Cliente, String> nombres;

}

