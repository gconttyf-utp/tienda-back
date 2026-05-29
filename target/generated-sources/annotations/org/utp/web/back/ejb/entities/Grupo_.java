package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Grupo.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Grupo_ {

	public static final String ESTADO = "estado";
	public static final String CATEGORIAS = "categorias";
	public static final String DEPARTAMENTO = "departamento";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Grupo#estado
	 **/
	public static volatile SingularAttribute<Grupo, Integer> estado;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Grupo#categorias
	 **/
	public static volatile ListAttribute<Grupo, Categoria> categorias;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Grupo#departamento
	 **/
	public static volatile SingularAttribute<Grupo, Departamento> departamento;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Grupo#id
	 **/
	public static volatile SingularAttribute<Grupo, Integer> id;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Grupo
	 **/
	public static volatile EntityType<Grupo> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Grupo#nombre
	 **/
	public static volatile SingularAttribute<Grupo, String> nombre;

}

