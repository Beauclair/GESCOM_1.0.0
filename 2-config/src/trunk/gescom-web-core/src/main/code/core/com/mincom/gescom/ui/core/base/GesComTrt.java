package com.mincom.gescom.ui.core.base;

import java.util.Map;
import java.util.TreeMap;

public class GesComTrt extends BasicTrt{
	
	/**
	 * Retourne la liste des traitements standards 
	 * 
	 * @param p$codeEntite	: Code de l'entité
	 * @return
	 */
	public static Map<String, Traitement> getTrtStandards() {
		return 	getTrtStandards("");
	}
	
	/**
	 * Retourne la liste des traitements standards pour une entité donnée
	 * 
	 * @param p$codeEntite	: Code de l'entité
	 * @return
	 */
	public static Map<String, Traitement> getTrtStandards(String p$codeEntite) {
		
		Traitement v$traitement;
		Map<String,Traitement> trtStandards = new TreeMap<String, Traitement>();
		
		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, GesComTrt.AJOUTER.getCode()), GesComTrt.AJOUTER);
		trtStandards.put(v$traitement.getKey(), v$traitement);
		
		
		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, GesComTrt.AFFICHER.getCode()), GesComTrt.AFFICHER);		
		trtStandards.put(v$traitement.getKey(), v$traitement);
	
//		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, GesComTrt.COPIER.getCode()), GesComTrt.COPIER);				
//		trtStandards.put(v$traitement.getKey(), v$traitement);

		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, GesComTrt.MODIFIER.getCode()), GesComTrt.MODIFIER);				
		trtStandards.put(v$traitement.getKey(), v$traitement);

		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, GesComTrt.SELECTIONNER.getCode()), GesComTrt.SELECTIONNER);				
		trtStandards.put(v$traitement.getKey(), v$traitement);

		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, GesComTrt.SUPPRIMER.getCode()), GesComTrt.SUPPRIMER);				
		trtStandards.put(v$traitement.getKey(), v$traitement);
		
		
		
		return trtStandards;
		
	}

}
