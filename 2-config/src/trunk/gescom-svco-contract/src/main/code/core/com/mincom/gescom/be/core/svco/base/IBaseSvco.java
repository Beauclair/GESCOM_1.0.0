package com.mincom.gescom.be.core.svco.base;

import java.io.Serializable;
import java.util.List;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.exception.BaseException;
import com.mincom.gescom.be.core.exception.GesComAppException;

public interface IBaseSvco<T extends BaseEntity> {
	
	<X extends BaseEntity> X creer(X p$entite) throws BaseException ;
	
	<X extends BaseEntity> X modifier(X p$entite) throws GesComAppException;
	
	<X extends BaseEntity> boolean supprimer(X p$entite) throws GesComAppException;
	
	<X extends BaseEntity> void retirer(X p$entite) throws GesComAppException;
	
	<X extends BaseEntity> X rechercher(X entity, Serializable p$valeur) throws GesComAppException;
	
	<X extends BaseEntity> List<X> rechercherTout(X entity) throws GesComAppException;

	<X extends BaseEntity> List<X> rechercherParCritere(X entity) throws GesComAppException;

}
