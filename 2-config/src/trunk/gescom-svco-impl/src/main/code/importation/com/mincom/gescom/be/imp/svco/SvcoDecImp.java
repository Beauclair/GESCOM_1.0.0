package com.mincom.gescom.be.imp.svco;

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
import com.mincom.gescom.be.imp.entity.TabDecImp;
import com.mincom.gescom.be.imp.sisv.ISisvDecImp;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.be.util.EntFichier;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoDecImp extends BaseSvco<TabDecImp> implements IRemoteDecImp, ILocalDecImp{
	
	@EJB
	ISisvDecImp sisvDec;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoDecImp.class);
	
	@Override
	protected IBaseSisv<TabDecImp, String> getBaseSisv() {
		return sisvDec;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
	throws GesComAppException {
		try {
			return sisvDec.rechercher(entity,id);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
	throws GesComAppException {
		try {
			return sisvDec.rechercherTout(entity);
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
			return sisvDec.rechercherParCritere(entity);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabDecImp rechercherParNumDec(String numDec)
	throws GesComAppException {
		try {
			return sisvDec.rechercherParNumDec(numDec);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public List<TabPro> rechercherProduitParCodDec(String numDec)
	throws GesComAppException {
		try {
			return sisvDec.rechercherProduitParCodDec(numDec);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public EntFichier  genererDecImp(TabDecImp dec)
	throws GesComAppException {
		try {
			return sisvDec.genererDecImp(dec);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}


}
