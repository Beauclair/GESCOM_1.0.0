package com.mincom.gescom.be.imp.dao;

import java.util.List;

import javax.ejb.Local;

import com.mincom.gescom.be.core.dao.base.IBaseDao;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.imp.entity.TabAutSpeImp;
import com.mincom.gescom.be.ref.entity.TabPro;

@Local
public interface IDaoAutSpeImp extends IBaseDao<TabAutSpeImp, String>{

	TabAutSpeImp findByNumAut(String numAut) throws GesComPersistenceException;

	List<TabPro> findProductByCodAut(String codAut)
			throws GesComPersistenceException;

}
