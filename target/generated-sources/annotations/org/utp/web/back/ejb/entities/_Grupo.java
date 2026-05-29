package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Grupo.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Grupo {

	String ESTADO = "estado";
	String ID = "id";
	String NOMBRE = "nombre";
	String DEPARTAMENTO = "departamento";

	
	/**
	 * @see Grupo#estado
	 **/
	SortableAttribute<Grupo> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Grupo#id
	 **/
	SortableAttribute<Grupo> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Grupo#nombre
	 **/
	TextAttribute<Grupo> nombre = new TextAttributeRecord<>(NOMBRE);
	
	/**
	 * @see Grupo#departamento
	 **/
	SortableAttribute<Grupo> departamento = new SortableAttributeRecord<>(DEPARTAMENTO);

}

