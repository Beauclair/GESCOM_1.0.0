package com.mincom.gescom.be.admin.sisv.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mincom.gescom.be.admin.dao.utilisateur.IDaoSite;
import com.mincom.gescom.be.admin.entity.utilisateur.TabSite;
import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.IBaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.BaseSisv;

@Stateless
public class SisvSite extends BaseSisv<TabSite, String> implements ISisvSite{

	private static BaseLogger logger = BaseLogger.getLogger(SisvSite.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoSite daoSite; 



	@Override
	public IBaseDao<TabSite, String> getBaseDao() {
		return daoSite;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws GesComSystemException {
		try {
			return daoSite.findById(entity, id);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws GesComSystemException {
			
		try {
			return daoSite.findAll(entity);
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
			return daoSite.findByExample(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}
	

}
