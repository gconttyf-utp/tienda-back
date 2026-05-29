package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Departamento.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Departamento_ {

	public static final String ESTADO = "estado";
	public static final String GRUPOS = "grupos";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Departamento#estado
	 **/
	public static volatile SingularAttribute<Departamento, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Departamento#grupos
	 **/
	public static volatile ListAttribute<Departamento, Grupo> grupos;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Departamento#id
	 **/
	public static volatile SingularAttribute<Departamento, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Departamento
	 **/
	public static volatile EntityType<Departamento> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Departamento#nombre
	 **/
	public static volatile SingularAttribute<Departamento, String> nombre;

}

