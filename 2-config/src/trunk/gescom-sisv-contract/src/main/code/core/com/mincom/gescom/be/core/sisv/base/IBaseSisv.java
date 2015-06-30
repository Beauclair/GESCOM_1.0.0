package com.mincom.gescom.be.core.sisv.base;

import java.io.Serializable;
import java.util.List;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.exception.BaseException;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.core.exception.GesComSystemException;

public interface IBaseSisv<T extends BaseEntity, ID extends Serializable> {
	
	<X extends BaseEntity> X creer(X p$entite) throws BaseException ;
	
	<X extends BaseEntity> X modifier(X p$entite) throws GesComPersistenceException;
	
	<X extends BaseEntity> boolean supprimer(X p$entite) throws GesComPersistenceException;
	
	<X extends BaseEntity> void retirer(X p$entite) throws GesComSystemException, GesComPersistenceException;
	
	<X extends BaseEntity> X rechercher(X entity, Serializable p$valeur) throws GesComSystemException;
	
	<X extends BaseEntity> List<X> rechercherTout(X entity) throws GesComSystemException;

	<X extends BaseEntity> List<X> rechercherParCritere(X entity) throws GesComSystemException;
}
