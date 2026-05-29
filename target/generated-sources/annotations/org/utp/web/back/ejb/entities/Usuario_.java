package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Usuario.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Usuario_ {

	public static final String APELLIDOS = "apellidos";
	public static final String CLAVE = "clave";
	public static final String ESTADO = "estado";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";
	public static final String ROL = "rol";
	public static final String NOMBRES = "nombres";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario#apellidos
	 **/
	public static volatile SingularAttribute<Usuario, String> apellidos;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario#clave
	 **/
	public static volatile SingularAttribute<Usuario, String> clave;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario#estado
	 **/
	public static volatile SingularAttribute<Usuario, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario#usuario
	 **/
	public static volatile SingularAttribute<Usuario, String> usuario;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario#id
	 **/
	public static volatile SingularAttribute<Usuario, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario
	 **/
	public static volatile EntityType<Usuario> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario#rol
	 **/
	public static volatile SingularAttribute<Usuario, Rol> rol;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Usuario#nombres
	 **/
	public static volatile SingularAttribute<Usuario, String> nombres;

}

