package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Producto.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Producto {

	String UNIDAD = "unidad";
	String CATEGORIA = "categoria";
	String PRECIO_LISTA = "precioLista";
	String PRECIO_ONLINE = "precioOnline";
	String COLOR_PLACEHOLDER = "colorPlaceholder";
	String DESCRIPCION_LARGA = "descripcionLarga";
	String STOCK = "stock";
	String ESTADO = "estado";
	String SKU = "sku";
	String DESCRIPCION = "descripcion";
	String OFERTA = "oferta";
	String CREATED_AT = "createdAt";
	String MARCA = "marca";
	String RUTA_IMG = "rutaImg";
	String SLUG = "slug";
	String ID = "id";
	String DESTACADO = "destacado";

	
	/**
	 * @see Producto#unidad
	 **/
	TextAttribute<Producto> unidad = new TextAttributeRecord<>(UNIDAD);
	
	/**
	 * @see Producto#categoria
	 **/
	SortableAttribute<Producto> categoria = new SortableAttributeRecord<>(CATEGORIA);
	
	/**
	 * @see Producto#precioLista
	 **/
	SortableAttribute<Producto> precioLista = new SortableAttributeRecord<>(PRECIO_LISTA);
	
	/**
	 * @see Producto#precioOnline
	 **/
	SortableAttribute<Producto> precioOnline = new SortableAttributeRecord<>(PRECIO_ONLINE);
	
	/**
	 * @see Producto#colorPlaceholder
	 **/
	TextAttribute<Producto> colorPlaceholder = new TextAttributeRecord<>(COLOR_PLACEHOLDER);
	
	/**
	 * @see Producto#descripcionLarga
	 **/
	TextAttribute<Producto> descripcionLarga = new TextAttributeRecord<>(DESCRIPCION_LARGA);
	
	/**
	 * @see Producto#stock
	 **/
	SortableAttribute<Producto> stock = new SortableAttributeRecord<>(STOCK);
	
	/**
	 * @see Producto#estado
	 **/
	SortableAttribute<Producto> estado = new SortableAttributeRecord<>(ESTADO);
	
	/**
	 * @see Producto#sku
	 **/
	TextAttribute<Producto> sku = new TextAttributeRecord<>(SKU);
	
	/**
	 * @see Producto#descripcion
	 **/
	TextAttribute<Producto> descripcion = new TextAttributeRecord<>(DESCRIPCION);
	
	/**
	 * @see Producto#oferta
	 **/
	SortableAttribute<Producto> oferta = new SortableAttributeRecord<>(OFERTA);
	
	/**
	 * @see Producto#createdAt
	 **/
	SortableAttribute<Producto> createdAt = new SortableAttributeRecord<>(CREATED_AT);
	
	/**
	 * @see Producto#marca
	 **/
	SortableAttribute<Producto> marca = new SortableAttributeRecord<>(MARCA);
	
	/**
	 * @see Producto#rutaImg
	 **/
	TextAttribute<Producto> rutaImg = new TextAttributeRecord<>(RUTA_IMG);
	
	/**
	 * @see Producto#slug
	 **/
	TextAttribute<Producto> slug = new TextAttributeRecord<>(SLUG);
	
	/**
	 * @see Producto#id
	 **/
	SortableAttribute<Producto> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * @see Producto#destacado
	 **/
	SortableAttribute<Producto> destacado = new SortableAttributeRecord<>(DESTACADO);

}

