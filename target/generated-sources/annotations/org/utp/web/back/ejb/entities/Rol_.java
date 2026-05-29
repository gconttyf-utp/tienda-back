package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rol.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Rol_ {

	public static final String DESCRIPCION = "descripcion";
	public static final String ESTADO = "estado";
	public static final String ID = "id";
	public static final String USUARIOS = "usuarios";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Rol#descripcion
	 **/
	public static volatile SingularAttribute<Rol, String> descripcion;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Rol#estado
	 **/
	public static volatile SingularAttribute<Rol, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Rol#id
	 **/
	public static volatile SingularAttribute<Rol, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Rol#usuarios
	 **/
	public static volatile ListAttribute<Rol, Usuario> usuarios;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Rol
	 **/
	public static volatile EntityType<Rol> class_;

}

