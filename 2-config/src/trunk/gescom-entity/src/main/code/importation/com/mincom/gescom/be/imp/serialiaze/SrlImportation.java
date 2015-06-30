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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlImportationElt> srlImportation;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlImportationElt> getSrlImportation() {
		return srlImportation;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlImportation(ArrayList<SrlImportationElt> srlImportation) {
		this.srlImportation = srlImportation;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlImportationElt p$elt) {

		if (srlImportation == null)
			srlImportation = new ArrayList<SrlImportationElt>();
		srlImportation.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		srlImportation = new ArrayList<SrlImportationElt>();
	}


}
