package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Marca.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Marca {

	String ESTADO = "estado";
	String ID = "id";
	String NOMBRE = "nombre";

	
	/**
	 * @see Marca#estado
	 **/
	SortableAttribute<Marca> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Marca#id
	 **/
	SortableAttribute<Marca> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Marca#nombre
	 **/
	TextAttribute<Marca> nombre = new TextAttributeRecord<>(NOMBRE);

}

