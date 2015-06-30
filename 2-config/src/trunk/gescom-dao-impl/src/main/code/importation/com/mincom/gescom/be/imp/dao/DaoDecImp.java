package com.mincom.gescom.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.BaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.imp.entity.TabDecImp;
import com.mincom.gescom.be.ref.entity.TabPro;

@Stateless
public class DaoDecImp extends BaseDao<TabDecImp, String> implements IDaoDecImp{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoDecImp.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codDec ='" + id + "' ";
			
			logger.debug("Requete <" + query + ">");
			
			List<X> v$list = getManager().createQuery(query).getResultList();
			
			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
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
			" ORDER BY o.codDec ";
			
			logger.debug("Requete <" + query + ">");
			
			List<X> v$list = getManager().createQuery(query).getResultList();
			
			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
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
		TabDecImp currentDec = (TabDecImp)entity;
		if(currentDec.getNumDec()!= null && !currentDec.getNumDec().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.numDec) like '%"+currentDec.getNumDec()+"%'";
		}
		if(currentDec.getTabImp().getLibImp() != null && !currentDec.getTabImp().getLibImp().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabImp.libImp) like '%"+currentDec.getTabImp().getLibImp()+"%'";
		}
		if(currentDec.getTabFour().getLibFour() != null && !currentDec.getTabFour().getLibFour().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabFour.libFour) like '%"+currentDec.getTabFour().getLibFour()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.numDec ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}
	
	@Override
	public TabDecImp findByNumDec(String numDec)
	throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM TabDecImp o WHERE o.numDec ='" + numDec + "' ";

			logger.debug("Requete <" + query + ">");

			List<TabDecImp> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return v$list.get(0);
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}
	
	@Override
	public List<TabPro> findProductByCodDec(String codDec)
	throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM TabPro o WHERE o.codGenImp ='" + codDec + "' ";

			logger.debug("Requete <" + query + ">");

			List<TabPro> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return v$list;
		}catch(GesComPersistenceException sdr){
			throw sdr;
		}
	}
	

}
