package com.mincom.gescom.be.ref.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.BaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.ref.entity.TabFour;

@Stateless
public class DaoFour extends BaseDao<TabFour, String> implements IDaoFour{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoFour.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codFour='" + id + "' ";
			
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
			" ORDER BY o.codFour ";
			
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
		TabFour currentFour = (TabFour)entity;
		if(currentFour.getCodFour()!= null && !currentFour.getCodFour().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codFour) like '%"+currentFour.getCodFour()+"%'";
		}
		if(currentFour.getLibFour()!= null && !currentFour.getLibFour().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libFour) like '%"+currentFour.getLibFour()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codFour ";

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
}
