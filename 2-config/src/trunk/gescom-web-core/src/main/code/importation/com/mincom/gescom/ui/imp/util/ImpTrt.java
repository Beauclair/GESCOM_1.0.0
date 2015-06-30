package com.mincom.gescom.ui.imp.util;

import com.mincom.gescom.ui.core.base.GesComTrt;
import com.mincom.gescom.ui.core.base.Traitement;

public class ImpTrt extends GesComTrt{
	
	public static Traitement GENERER_AUT_IMP;	
	static{
		
		GENERER_AUT_IMP = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_aut_imp" , /* Libellé */ "Générer document" , /* Commentaire */ "" , /* Méthode */ "genererAutImp",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "000",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "11", /* reRender */ "", /* image */ "" );
	}
	
	
	
}
