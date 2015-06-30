package com.mincom.gescom.be.admin.svco.utilisateur;

import com.mincom.gescom.be.admin.entity.utilisateur.TabUsr;
import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.svco.base.IBaseSvco;

public interface ISvcoUsr extends IBaseSvco<TabUsr>{

	TabUsr authenticate(String p$login, String p$pwd) throws GesComAppException;
	
	TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd) throws GesComAppException;

}
