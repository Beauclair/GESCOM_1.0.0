package com.mincom.gescom.ui.ref.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.svco.base.IBaseSvco;
import com.mincom.gescom.be.ref.entity.TabImp;
import com.mincom.gescom.ui.core.base.GesComCtrl;
import com.mincom.gescom.ui.core.base.ServiceLocatorException;
import com.mincom.gescom.ui.core.base.Traitement;
import com.mincom.gescom.ui.ref.util.RefSvcoDeleguate;
import com.mincom.gescom.ui.ref.util.RefTrt;
import com.mincom.gescom.ui.ref.vue.ImpVue;

public class ImpCtrl extends GesComCtrl<TabImp, TabImp>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "ImpCtrl";
	
	private boolean isFiltreSpecify;
	
	public ImpCtrl(){		
		defaultVue = new ImpVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabImp> getEntitySvco() throws ServiceLocatorException{	
		return RefSvcoDeleguate.getSvcoImp();
	}
	
	public Class<ImpCtrl> getMyClass() {
		return ImpCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (GesComAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "ImpDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Imp";

		System.out.println("ImpCtrl.getListeTraitements() ici il vaut : "
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
			setMapTraitements(RefTrt.getTrtStandards("Imp")) ;
		}	
	}

	@Override
	public List<TabImp> rechercherParCritere(TabImp p$entity)
			throws GesComAppException {
		try {
			super.setTimeOfLastSearch();
			return RefSvcoDeleguate.getSvcoImp().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (GesComAppException e) {
			GesComAppException sdr = new GesComAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	
}
