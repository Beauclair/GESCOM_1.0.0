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
import com.mincom.gescom.be.imp.entity.TabAutSpeImp;
import com.mincom.gescom.be.imp.sisv.ISisvAutSpeImp;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.be.util.EntFichier;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoAutSpeImp extends BaseSvco<TabAutSpeImp> implements IRemoteAutSpeImp, ILocalAutSpeImp{
	
	@EJB
	ISisvAutSpeImp sisvAut;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoAutSpeImp.class);
	
	@Override
	protected IBaseSisv<TabAutSpeImp, String> getBaseSisv() {
		return sisvAut;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
	throws GesComAppException {
		try {
			return sisvAut.rechercher(entity,id);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
	throws GesComAppException {
		try {
			return sisvAut.rechercherTout(entity);
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
			return sisvAut.rechercherParCritere(entity);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabAutSpeImp rechercherParNumAut(String numAut)
	throws GesComAppException {
		try {
			return sisvAut.rechercherParNumAut(numAut);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public List<TabPro> rechercherProduitParCodAut(String codAut)
	throws GesComAppException {
		try {
			return sisvAut.rechercherProduitParCodAut(codAut);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public EntFichier  genererAutSpeImp(TabAutSpeImp aut)
	throws GesComAppException {
		try {
			return sisvAut.genererAutSpeImp(aut);
		} catch (GesComSystemException e) {
			e.printStackTrace();
			GesComAppException sdr = new GesComAppException(e);
			throw sdr;
		}
	}


}
