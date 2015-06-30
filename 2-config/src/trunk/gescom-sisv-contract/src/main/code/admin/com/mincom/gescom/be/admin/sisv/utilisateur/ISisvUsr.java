package com.mincom.gescom.be.admin.sisv.utilisateur;

import javax.ejb.Local;

import com.mincom.gescom.be.admin.entity.utilisateur.TabUsr;
import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.IBaseSisv;

@Local
public interface ISisvUsr extends IBaseSisv<TabUsr, String>{
	
	TabUsr authenticate(String p$login, String p$pwd) throws GesComSystemException;
	
	TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd) throws GesComSystemException;

}
