package com.mincom.gescom.be.ref.sisv;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.IBaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.BaseSisv;
import com.mincom.gescom.be.ref.dao.IDaoImp;
import com.mincom.gescom.be.ref.entity.TabImp;

@Stateless
public class SisvImp extends BaseSisv<TabImp, String> implements ISisvImp{

	private static BaseLogger logger = BaseLogger.getLogger(SisvImp.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoImp daoImp; 



	@Override
	public IBaseDao<TabImp, String> getBaseDao() {
		return daoImp;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws GesComSystemException {
		try {
			return daoImp.findById(entity, id);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws GesComSystemException {
			
		try {
			return daoImp.findAll(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws GesComSystemException {
		try {
			return daoImp.findByExample(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}
	

}
