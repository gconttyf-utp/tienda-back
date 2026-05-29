package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.impl.SortableAttributeRecord;

@StaticMetamodel(Almacen.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Almacen {

	String TIENDA = "tienda";
	String FECHA_INGRESO = "fechaIngreso";
	String ID = "id";
	String PRODUCTO = "producto";
	String CANTIDAD = "cantidad";

	
	/**
	 * @see Almacen#tienda
	 **/
	SortableAttribute<Almacen> tienda = new SortableAttributeRecord<>(TIENDA);
	
	/**
	 * @see Almacen#fechaIngreso
	 **/
	SortableAttribute<Almacen> fechaIngreso = new SortableAttributeRecord<>(FECHA_INGRESO);
	
	/**
	 * @see Almacen#id
	 **/
	SortableAttribute<Almacen> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Almacen#producto
	 **/
	SortableAttribute<Almacen> producto = new SortableAttributeRecord<>(PRODUCTO);
	
	/**
	 * @see Almacen#cantidad
	 **/
	SortableAttribute<Almacen> cantidad = new SortableAttributeRecord<>(CANTIDAD);

}

