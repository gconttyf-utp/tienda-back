package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Cliente.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Cliente {

	String APELLIDOS = "apellidos";
	String ESTADO = "estado";
	String CORREO = "correo";
	String CLAVE = "clave";
	String ID = "id";
	String NOMBRES = "nombres";

	
	/**
	 * @see Cliente#apellidos
	 **/
	TextAttribute<Cliente> apellidos = new TextAttributeRecord<>(APELLIDOS);
	
	/**
	 * @see Cliente#estado
	 **/
	SortableAttribute<Cliente> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Cliente#correo
	 **/
	TextAttribute<Cliente> correo = new TextAttributeRecord<>(CORREO);
	
	/**
	 * @see Cliente#clave
	 **/
	TextAttribute<Cliente> clave = new TextAttributeRecord<>(CLAVE);
	
	/**
	 * @see Cliente#id
	 **/
	SortableAttribute<Cliente> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Cliente#nombres
	 **/
	TextAttribute<Cliente> nombres = new TextAttributeRecord<>(NOMBRES);

}

