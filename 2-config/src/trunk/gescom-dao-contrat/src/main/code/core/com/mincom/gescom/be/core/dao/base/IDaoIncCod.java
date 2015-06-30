package com.mincom.gescom.be.core.dao.base;

import javax.ejb.Local;

import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.core.base.TabIncCod;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;

@Local
public interface IDaoIncCod extends IBaseDao<TabIncCod, String>{

	TabIncCod findNextIncCod(GesComBaseEntity object) throws GesComPersistenceException;

	TabIncCod findInc(TabIncCod compteur) throws GesComPersistenceException;

}
