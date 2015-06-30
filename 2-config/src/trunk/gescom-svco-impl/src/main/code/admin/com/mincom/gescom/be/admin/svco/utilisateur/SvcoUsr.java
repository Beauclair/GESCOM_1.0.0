package com.mincom.gescom.be.admin.svco.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.mincom.gescom.be.admin.entity.utilisateur.TabUsr;
import com.mincom.gescom.be.admin.sisv.utilisateur.ISisvUsr;
import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.IBaseSisv;
import com.mincom.gescom.be.core.svco.base.BaseSvco;

//@Stateless(name = "SvcoUsr", mappedName = "SvcoUsr")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoUsr extends BaseSvco<TabUsr> implements IRemoteUsr, ILocalUsr{
	
	@EJB
	ISisvUsr sisvUsr;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoUsr.class);
	
	@Override
	protected IBaseSisv<TabUsr, String> getBaseSisv() {
		return sisvUsr;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	public TabUsr authenticate(String p$login, String p$pwd) throws GesComAppException {
		try {
			return sisvUsr.authenticate(p$login, p$pwd);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	public TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd) throws GesComAppException {
		try {
			return sisvUsr.modifierPwd(p$login, p$oldPwd, p$newPwd);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws GesComAppException {
		try {
			return sisvUsr.rechercher(entity,id);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws GesComAppException {
		try {
			return sisvUsr.rechercherTout(entity);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
	throws GesComAppException {
		try {
			return sisvUsr.rechercherParCritere(entity);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

}
