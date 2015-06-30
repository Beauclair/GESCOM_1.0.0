package com.mincom.gescom.ui.ref.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.svco.base.IBaseSvco;
import com.mincom.gescom.be.ref.entity.TabPays;
import com.mincom.gescom.ui.core.base.GesComCtrl;
import com.mincom.gescom.ui.core.base.ServiceLocatorException;
import com.mincom.gescom.ui.core.base.Traitement;
import com.mincom.gescom.ui.ref.util.RefSvcoDeleguate;
import com.mincom.gescom.ui.ref.util.RefTrt;
import com.mincom.gescom.ui.ref.vue.PaysVue;

public class PaysCtrl extends GesComCtrl<TabPays, TabPays>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "PaysCtrl";
	
	
	public PaysCtrl(){		
		defaultVue = new PaysVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabPays> getEntitySvco() throws ServiceLocatorException{	
		return RefSvcoDeleguate.getSvcoPays();
	}
	
	public Class<PaysCtrl> getMyClass() {
		return PaysCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (GesComAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "PaysDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Pays";

		System.out.println("PaysCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				RefTrt.getTrtStandards(v$codeEntite));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(RefTrt.getTrtStandards("Pays")) ;
		}	
	}

	@Override
	public List<TabPays> rechercherParCritere(TabPays p$entity)
			throws GesComAppException {
		try {
			super.setTimeOfLastSearch();
			return RefSvcoDeleguate.getSvcoPays().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (GesComAppException e) {
			GesComAppException sdr = new GesComAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	
}
