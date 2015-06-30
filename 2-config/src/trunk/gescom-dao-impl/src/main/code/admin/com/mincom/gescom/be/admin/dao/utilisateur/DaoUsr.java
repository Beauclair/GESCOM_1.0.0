package com.mincom.gescom.be.admin.dao.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.mincom.gescom.be.admin.entity.utilisateur.TabUsr;
import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.BaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;

@Stateless
public class DaoUsr extends BaseDao<TabUsr, String> implements IDaoUsr{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoUsr.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	public TabUsr authenticate(String p$login, String p$pwd) throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM " + TabUsr.class.getSimpleName() + " o " + 
			" WHERE o.codUsr='" + p$login + "' AND o.codPwd='" + p$pwd + "' ";

			logger.debug("Requete <" + query + ">");

			List v$list = getManager().createQuery(query).getResultList();
			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return (TabUsr)v$list.get(0);
		}catch(GesComPersistenceException sdr){
			throw sdr; 
		}
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codUsr='" + id + "' ";
			
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
			" ORDER BY o.codUsr ";
			
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
	
	public <X extends BaseEntity> List<X> findByExample(X entity)
	throws GesComPersistenceException {
		String clauseWhere = "1=1 AND o.etatEnt != '2001'";
		TabUsr currentUsr = (TabUsr)entity;
		if(currentUsr.getCodUsr() != null && !currentUsr.getCodUsr().equals("")){
			clauseWhere = clauseWhere + " AND upper(o.codUsr) like '%"+currentUsr.getCodUsr()+"%'";
		}
		if(currentUsr.getLibNom() != null && !currentUsr.getLibNom().equals("")){
			clauseWhere = clauseWhere + " AND upper(o.libNom) like '%"+currentUsr.getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codUsr ";

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
