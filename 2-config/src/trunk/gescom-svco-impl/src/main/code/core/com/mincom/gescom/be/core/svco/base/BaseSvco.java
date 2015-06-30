package com.mincom.gescom.be.core.svco.base;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.ejb.SessionContext;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.core.exception.BaseException;
import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.core.sisv.base.IBaseSisv;

public abstract class BaseSvco <T extends BaseEntity> implements IBaseSvco<T>{
	
	protected abstract IBaseSisv<T, ? extends Serializable> getBaseSisv();

	public abstract BaseLogger getLogger();

	@Resource
	private SessionContext sessionContext;
	
	public SessionContext getSessionContext(){
		return sessionContext;
	}
	protected void rollbackTransactionContext(){
		try {
			getSessionContext().setRollbackOnly();
		} catch (Exception e) {
			getLogger().warn("Erreur de récupération du Session Context : Vérifier sa redéfinition!", e);
			e.printStackTrace();
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException {
		try {
			
			return getBaseSisv().creer(p$entite);			
		} catch (BaseException e) {
			rollbackTransactionContext();
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			rollbackTransactionContext();
			String message =  e.getMessage();
			GesComAppException sysEx =  new GesComAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
		}
	}
	
	public <X extends BaseEntity> X modifier(X p$entite) throws GesComAppException {
		try {
			return getBaseSisv().modifier(p$entite);
		} catch (GesComPersistenceException sdr) {
			sdr.printStackTrace();
			rollbackTransactionContext();
			GesComAppException sbr = new GesComAppException(sdr);
			throw sbr;
		} catch (Exception e) {
			
			rollbackTransactionContext();
			String message = e.getMessage() + " !";
			GesComAppException sysEx =  new GesComAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
			
		}
	}
	
	public <X extends BaseEntity> boolean supprimer(X p$entite) throws GesComAppException {
		try {
			((GesComBaseEntity) p$entite).setBooAct(BigDecimal.ZERO);
			 return getBaseSisv().supprimer(p$entite);
		} catch (GesComPersistenceException sdr) {
			sdr.printStackTrace();
			rollbackTransactionContext();
			GesComAppException sbr = new GesComAppException(sdr);
			throw sbr;
		} catch (Exception e) {
			
			rollbackTransactionContext();
			String message = e.getMessage() + " !";
			GesComAppException sysEx =  new GesComAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
			
		}
	}
	
	public <X extends BaseEntity> void retirer(X p$entite) throws GesComAppException {
		try {
			 getBaseSisv().retirer(p$entite);
		} catch (GesComPersistenceException sdr) {
			sdr.printStackTrace();
			rollbackTransactionContext();
			GesComAppException sbr = new GesComAppException(sdr);
			throw sbr;
		} catch (Exception e) {
			
			rollbackTransactionContext();
			String message = e.getMessage() + " !";
			GesComAppException sysEx =  new GesComAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
			
		}
	}


}
