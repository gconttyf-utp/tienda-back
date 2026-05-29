package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Categoria.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Categoria {

	String ESTADO = "estado";
	String GRUPO = "grupo";
	String ID = "id";
	String NOMBRE = "nombre";

	
	/**
	 * @see Categoria#estado
	 **/
	SortableAttribute<Categoria> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Categoria#grupo
	 **/
	SortableAttribute<Categoria> grupo = new SortableAttributeRecord<>(GRUPO);
	
	/**
	 * @see Categoria#id
	 **/
	SortableAttribute<Categoria> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Categoria#nombre
	 **/
	TextAttribute<Categoria> nombre = new TextAttributeRecord<>(NOMBRE);

}

