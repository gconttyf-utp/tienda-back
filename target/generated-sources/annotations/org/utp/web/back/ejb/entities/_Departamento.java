package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Departamento.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Departamento {

	String ESTADO = "estado";
	String ID = "id";
	String NOMBRE = "nombre";

	
	/**
	 * @see Departamento#estado
	 **/
	SortableAttribute<Departamento> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Departamento#id
	 **/
	SortableAttribute<Departamento> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Departamento#nombre
	 **/
	TextAttribute<Departamento> nombre = new TextAttributeRecord<>(NOMBRE);

}

