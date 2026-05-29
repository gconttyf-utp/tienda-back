package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.TextAttributeRecord;

@StaticMetamodel(Ubigeo.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public interface _Ubigeo {

	String TXT_UBIGEO = "txtUbigeo";
	String COD_UBIGEO = "codUbigeo";
	String COD_UBIGEO_PADRE = "codUbigeoPadre";

	
	/**
	 * @see Ubigeo#txtUbigeo
	 **/
	TextAttribute<Ubigeo> txtUbigeo = new TextAttributeRecord<>(TXT_UBIGEO);
	
	/**
	 * @see Ubigeo#codUbigeo
	 **/
	TextAttribute<Ubigeo> codUbigeo = new TextAttributeRecord<>(COD_UBIGEO);
	
	/**
	 * @see Ubigeo#codUbigeoPadre
	 **/
	TextAttribute<Ubigeo> codUbigeoPadre = new TextAttributeRecord<>(COD_UBIGEO_PADRE);

}

