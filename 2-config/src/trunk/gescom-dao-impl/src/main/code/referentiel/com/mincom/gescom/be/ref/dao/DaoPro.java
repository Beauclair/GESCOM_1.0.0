package com.mincom.gescom.be.ref.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.dao.base.BaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.ref.entity.TabPro;

@Stateless
public class DaoPro extends BaseDao<TabPro, String> implements IDaoPro{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoPro.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws GesComPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codPro='" + id + "' ";
			
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
			" ORDER BY o.codPro ";
			
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
		TabPro currentPro = (TabPro)entity;
		if(currentPro.getCodPro()!= null && !currentPro.getCodPro().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codPro) like '%"+currentPro.getCodPro()+"%'";
		}
		if(currentPro.getLibPro()!= null && !currentPro.getLibPro().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libPro) like '%"+currentPro.getLibPro()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codPro ";

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
