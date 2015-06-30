package com.mincom.gescom.be.imp.sisv;

import java.util.List;

import javax.ejb.Local;

import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.IBaseSisv;
import com.mincom.gescom.be.imp.entity.TabAutSpeImp;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.be.util.EntFichier;

@Local
public interface ISisvAutSpeImp extends IBaseSisv<TabAutSpeImp, String>{

	TabAutSpeImp rechercherParNumAut(String numAut)
			throws GesComSystemException;

	List<TabPro> rechercherProduitParCodAut(String codAut)
			throws GesComSystemException;

	EntFichier genererAutSpeImp(TabAutSpeImp $vtabAut)
			throws GesComSystemException;


}
