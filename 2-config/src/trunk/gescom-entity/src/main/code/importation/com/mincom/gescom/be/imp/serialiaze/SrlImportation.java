package com.mincom.gescom.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

public class SrlImportation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlImportation() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlImportationElt> srlImportation;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlImportationElt> getSrlImportation() {
		return srlImportation;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlImportation(ArrayList<SrlImportationElt> srlImportation) {
		this.srlImportation = srlImportation;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlImportationElt p$elt) {

		if (srlImportation == null)
			srlImportation = new ArrayList<SrlImportationElt>();
		srlImportation.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		srlImportation = new ArrayList<SrlImportationElt>();
	}


}
