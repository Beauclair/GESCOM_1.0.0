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
import com.mincom.gescom.be.ref.entity.TabBnq;
import com.mincom.gescom.be.ref.sisv.ISisvBnq;

//@Stateless(name = "SvcoChau", mappedName = "SvcoChau")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoBnq extends BaseSvco<TabBnq> implements IRemoteBnq, ILocalBnq{
	
	@EJB
	ISisvBnq sisvBnq;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoBnq.class);
	
	@Override
	protected IBaseSisv<TabBnq, String> getBaseSisv() {
		return sisvBnq;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	


	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws GesComAppException {
		try {
			return sisvBnq.rechercher(entity,id);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws GesComAppException {
		try {
			return sisvBnq.rechercherTout(entity);
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
			return sisvBnq.rechercherParCritere(entity);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
}
