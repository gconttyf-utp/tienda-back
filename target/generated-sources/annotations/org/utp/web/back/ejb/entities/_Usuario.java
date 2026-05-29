package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Usuario.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Usuario {

	String APELLIDOS = "apellidos";
	String ESTADO = "estado";
	String CLAVE = "clave";
	String ID = "id";
	String USUARIO = "usuario";
	String ROL = "rol";
	String NOMBRES = "nombres";

	
	/**
	 * @see Usuario#apellidos
	 **/
	TextAttribute<Usuario> apellidos = new TextAttributeRecord<>(APELLIDOS);
	
	/**
	 * @see Usuario#estado
	 **/
	SortableAttribute<Usuario> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Usuario#clave
	 **/
	TextAttribute<Usuario> clave = new TextAttributeRecord<>(CLAVE);
	
	/**
	 * @see Usuario#id
	 **/
	SortableAttribute<Usuario> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Usuario#usuario
	 **/
	TextAttribute<Usuario> usuario = new TextAttributeRecord<>(USUARIO);
	
	/**
	 * @see Usuario#rol
	 **/
	SortableAttribute<Usuario> rol = new SortableAttributeRecord<>(ROL);
	
	/**
	 * @see Usuario#nombres
	 **/
	TextAttribute<Usuario> nombres = new TextAttributeRecord<>(NOMBRES);

}

