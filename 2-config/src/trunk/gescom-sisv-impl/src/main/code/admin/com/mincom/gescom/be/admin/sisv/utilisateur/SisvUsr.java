package com.mincom.gescom.be.admin.sisv.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mincom.gescom.be.admin.dao.utilisateur.IDaoUsr;
import com.mincom.gescom.be.admin.entity.utilisateur.TabUsr;
import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.IBaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.BaseSisv;

@Stateless
public class SisvUsr extends BaseSisv<TabUsr, String> implements ISisvUsr {

	private static BaseLogger logger = BaseLogger.getLogger(SisvUsr.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoUsr daoUsr; 

	public TabUsr authenticate(String p$login, String p$pwd)
			throws GesComSystemException {
		try {
			return daoUsr.authenticate(p$login, p$pwd);
			//Faire un controle si le mot de passe est expiré
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	public TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd)
			throws GesComSystemException {
		try {
			if(p$newPwd == null || p$newPwd.isEmpty()){
				GesComSystemException sdr = new GesComSystemException("Nouveau mot de passe vide");
				logger.error(sdr.getMessage(), sdr);
				throw sdr;
			}
			if(p$newPwd.length()>30){
				GesComSystemException sdr = new GesComSystemException("Taille du nouveau mot de passe trés longue, moins de 30 caractéres");
				logger.error(sdr.getMessage(), sdr);
				throw sdr;
			}
			if(p$oldPwd.equals(p$newPwd)){
				GesComSystemException sdr = new GesComSystemException("Ancien mot de passe identique au nouveau");
				logger.error(sdr.getMessage(), sdr);
				throw sdr;
			}
			//Récupération des informations de l'utilisateur en base de données		
			 TabUsr oldUsr = daoUsr.findById(new TabUsr(), p$login);
			 if(null != oldUsr){
				 oldUsr.setCodPwd(p$newPwd);
				 return daoUsr.update(oldUsr);
			 }
		} catch (GesComPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public IBaseDao<TabUsr, String> getBaseDao() {
		return daoUsr;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws GesComSystemException {
		try {
			return daoUsr.findById(entity, id);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws GesComSystemException {
			
		try {
			return daoUsr.findAll(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity) throws GesComSystemException {
		
		try {
			return daoUsr.findByExample(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

}
