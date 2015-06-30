package com.mincom.gescom.be.imp.sisv;

import java.util.List;

import javax.ejb.Local;

import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.IBaseSisv;
import com.mincom.gescom.be.imp.entity.TabDecImp;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.be.util.EntFichier;

@Local
public interface ISisvDecImp extends IBaseSisv<TabDecImp, String>{

	TabDecImp rechercherParNumDec(String numDec)
			throws GesComSystemException;

	List<TabPro> rechercherProduitParCodDec(String codDec)
			throws GesComSystemException;

	EntFichier genererDecImp(TabDecImp $vtabDec)
			throws GesComSystemException;


}
