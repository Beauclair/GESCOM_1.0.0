package com.mincom.gescom.be.imp.svco;

import java.util.List;

import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.svco.base.IBaseSvco;
import com.mincom.gescom.be.imp.entity.TabAutSpeImp;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.be.util.EntFichier;

public interface ISvcoAutSpeImp extends IBaseSvco<TabAutSpeImp>{

	TabAutSpeImp rechercherParNumAut(String numAut) throws GesComAppException;

	List<TabPro> rechercherProduitParCodAut(String codAut)
			throws GesComAppException;

	EntFichier genererAutSpeImp(TabAutSpeImp aut) throws GesComAppException;

}
