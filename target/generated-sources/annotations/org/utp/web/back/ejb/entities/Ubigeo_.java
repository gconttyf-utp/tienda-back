package org.utp.web.back.ejb.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ubigeo.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Ubigeo_ {

	public static final String TXT_UBIGEO = "txtUbigeo";
	public static final String COD_UBIGEO = "codUbigeo";
	public static final String COD_UBIGEO_PADRE = "codUbigeoPadre";

	
	/**
	 * @see org.utp.web.back.ejb.entities.Ubigeo#txtUbigeo
	 **/
	public static volatile SingularAttribute<Ubigeo, String> txtUbigeo;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Ubigeo#codUbigeo
	 **/
	public static volatile SingularAttribute<Ubigeo, String> codUbigeo;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Ubigeo
	 **/
	public static volatile EntityType<Ubigeo> class_;
	
	/**
	 * @see org.utp.web.back.ejb.entities.Ubigeo#codUbigeoPadre
	 **/
	public static volatile SingularAttribute<Ubigeo, String> codUbigeoPadre;

}

