package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Rol.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Rol {

	String ESTADO = "estado";
	String DESCRIPCION = "descripcion";
	String ID = "id";

	
	/**
	 * @see Rol#estado
	 **/
	SortableAttribute<Rol> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Rol#descripcion
	 **/
	TextAttribute<Rol> descripcion = new TextAttributeRecord<>(DESCRIPCION);
	
	/**
	 * @see Rol#id
	 **/
	SortableAttribute<Rol> id = new SortableAttributeRecord<>(ID);

}

