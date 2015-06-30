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
import com.mincom.gescom.be.ref.dao.IDaoPays;
import com.mincom.gescom.be.ref.entity.TabPays;

@Stateless
public class SisvPays extends BaseSisv<TabPays, String> implements ISisvPays{

	private static BaseLogger logger = BaseLogger.getLogger(SisvPays.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoPays daoPays; 



	@Override
	public IBaseDao<TabPays, String> getBaseDao() {
		return daoPays;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws GesComSystemException {
		try {
			return daoPays.findById(entity, id);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws GesComSystemException {
			
		try {
			return daoPays.findAll(entity);
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
			return daoPays.findByExample(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}
	

}
