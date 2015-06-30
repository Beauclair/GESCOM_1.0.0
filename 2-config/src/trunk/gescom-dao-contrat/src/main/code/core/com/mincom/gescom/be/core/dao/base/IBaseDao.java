package com.mincom.gescom.be.core.dao.base;

import java.io.Serializable;
import java.util.List;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.exception.BaseException;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;


public interface IBaseDao <T extends BaseEntity, ID extends Serializable>{

	public <X extends BaseEntity> X save(X entity) throws BaseException;
	
	public <X extends BaseEntity> X update(X entity) throws GesComPersistenceException;
	
	public <X extends BaseEntity> boolean delete(X entity) throws GesComPersistenceException;
	
	<X extends BaseEntity> void remove(X entity) throws GesComPersistenceException;
	
	<X extends BaseEntity> X findById(X entity, Serializable id) throws GesComPersistenceException;

	<X extends BaseEntity> List<X> findAll(X entity) throws GesComPersistenceException;

	<X extends BaseEntity> List<X> findByExample(X entity) throws GesComPersistenceException;
	
}
