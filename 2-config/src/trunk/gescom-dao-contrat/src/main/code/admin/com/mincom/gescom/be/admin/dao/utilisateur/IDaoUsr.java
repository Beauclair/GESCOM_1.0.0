package com.mincom.gescom.be.admin.dao.utilisateur;

import javax.ejb.Local;

import com.mincom.gescom.be.admin.entity.utilisateur.TabUsr;
import com.mincom.gescom.be.core.dao.base.IBaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;

@Local
public interface IDaoUsr extends IBaseDao<TabUsr, String>{
	
	TabUsr authenticate(String p$login, String p$pwd) throws GesComPersistenceException;
	
}
