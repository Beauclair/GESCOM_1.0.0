package com.mincom.gescom.be.ref.svco;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.IBaseSisv;
import com.mincom.gescom.be.core.svco.base.BaseSvco;
import com.mincom.gescom.be.ref.entity.TabTrans;
import com.mincom.gescom.be.ref.sisv.ISisvTrans;

//@Stateless(name = "SvcoChau", mappedName = "SvcoChau")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoTrans extends BaseSvco<TabTrans> implements IRemoteTrans, ILocalTrans{
	
	@EJB
	ISisvTrans sisvTrans;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoTrans.class);
	
	@Override
	protected IBaseSisv<TabTrans, String> getBaseSisv() {
		return sisvTrans;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	


	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws GesComAppException {
		try {
			return sisvTrans.rechercher(entity,id);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws GesComAppException {
		try {
			return sisvTrans.rechercherTout(entity);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws GesComAppException {
		try {
			return sisvTrans.rechercherParCritere(entity);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
}
