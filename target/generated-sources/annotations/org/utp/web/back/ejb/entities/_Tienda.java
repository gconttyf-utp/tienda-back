package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Tienda.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Tienda {

	String LATITUD = "latitud";
	String ESTADO = "estado";
	String HORARIO = "horario";
	String DIRECCION = "direccion";
	String IMAGEN_URL = "imagenUrl";
	String UBIGEO = "ubigeo";
	String ID = "id";
	String NOMBRE = "nombre";
	String LONGITUD = "longitud";
	String TELEFONO = "telefono";

	
	/**
	 * @see Tienda#latitud
	 **/
	SortableAttribute<Tienda> latitud = new SortableAttributeRecord<>(LATITUD);
	
	/**
	 * @see Tienda#estado
	 **/
	SortableAttribute<Tienda> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Tienda#horario
	 **/
	TextAttribute<Tienda> horario = new TextAttributeRecord<>(HORARIO);
	
	/**
	 * @see Tienda#direccion
	 **/
	TextAttribute<Tienda> direccion = new TextAttributeRecord<>(DIRECCION);
	
	/**
	 * @see Tienda#imagenUrl
	 **/
	TextAttribute<Tienda> imagenUrl = new TextAttributeRecord<>(IMAGEN_URL);
	
	/**
	 * @see Tienda#ubigeo
	 **/
	SortableAttribute<Tienda> ubigeo = new SortableAttributeRecord<>(UBIGEO);
	
	/**
	 * @see Tienda#id
	 **/
	SortableAttribute<Tienda> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Tienda#nombre
	 **/
	TextAttribute<Tienda> nombre = new TextAttributeRecord<>(NOMBRE);
	
	/**
	 * @see Tienda#longitud
	 **/
	SortableAttribute<Tienda> longitud = new SortableAttributeRecord<>(LONGITUD);
	
	/**
	 * @see Tienda#telefono
	 **/
	TextAttribute<Tienda> telefono = new TextAttributeRecord<>(TELEFONO);

}

