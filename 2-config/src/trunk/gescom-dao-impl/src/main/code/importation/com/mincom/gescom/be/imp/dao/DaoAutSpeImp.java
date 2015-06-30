package com.mincom.gescom.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.BaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.imp.entity.TabAutSpeImp;
import com.mincom.gescom.be.ref.entity.TabPro;

@Stateless
public class DaoAutSpeImp extends BaseDao<TabAutSpeImp, String> implements IDaoAutSpeImp{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoAutSpeImp.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codAut ='" + id + "' ";
			
			logger.debug("Requete <" + query + ">");
			
			List<X> v$list = getManager().createQuery(query).getResultList();
			
			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return v$list.get(0);
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> findAll(X entity)
			throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" ORDER BY o.codAut ";
			
			logger.debug("Requete <" + query + ">");
			
			List<X> v$list = getManager().createQuery(query).getResultList();
			
			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}


	@Override
	public <X extends BaseEntity> List<X> findByExample(X entity)
			throws GesComPersistenceException {
		String clauseWhere = "1=1 AND o.etatEnt != '2001'";
		TabAutSpeImp currentAut = (TabAutSpeImp)entity;
		if(currentAut.getNumAut()!= null && !currentAut.getNumAut().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.numAut) like '%"+currentAut.getNumAut()+"%'";
		}
		if(currentAut.getTabImp().getLibImp() != null && !currentAut.getTabImp().getLibImp().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabImp.libImp) like '%"+currentAut.getTabImp().getLibImp()+"%'";
		}
		if(currentAut.getTabFour().getLibFour() != null && !currentAut.getTabFour().getLibFour().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabFour.libFour) like '%"+currentAut.getTabFour().getLibFour()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.numAut ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}
	
	@Override
	public TabAutSpeImp findByNumAut(String numAut)
	throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM TabAutSpeImp o WHERE o.numAut ='" + numAut + "' ";

			logger.debug("Requete <" + query + ">");

			List<TabAutSpeImp> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return v$list.get(0);
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}
	
	@Override
	public List<TabPro> findProductByCodAut(String codAut)
	throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM TabPro o WHERE o.codGenImp ='" + codAut + "' ";

			logger.debug("Requete <" + query + ">");

			List<TabPro> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return v$list;
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}
	

}
