package com.mincom.gescom.ui.ref.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.svco.base.IBaseSvco;
import com.mincom.gescom.be.ref.entity.TabDvs;
import com.mincom.gescom.ui.core.base.GesComCtrl;
import com.mincom.gescom.ui.core.base.ServiceLocatorException;
import com.mincom.gescom.ui.core.base.Traitement;
import com.mincom.gescom.ui.ref.util.RefSvcoDeleguate;
import com.mincom.gescom.ui.ref.util.RefTrt;
import com.mincom.gescom.ui.ref.vue.DvsVue;

public class DvsCtrl extends GesComCtrl<TabDvs, TabDvs>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "DvsCtrl";
	
	private boolean isFiltreSpecify;
	
	public DvsCtrl(){		
		defaultVue = new DvsVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabDvs> getEntitySvco() throws ServiceLocatorException{	
		return RefSvcoDeleguate.getSvcoDvs();
	}
	
	public Class<DvsCtrl> getMyClass() {
		return DvsCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (GesComAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "DvsDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Dvs";

		System.out.println("DvsCtrl.getListeTraitements() ici il vaut : "
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
			setMapTraitements(RefTrt.getTrtStandards("Dvs")) ;
		}	
	}

	@Override
	public List<TabDvs> rechercherParCritere(TabDvs p$entity)
			throws GesComAppException {
		try {
			super.setTimeOfLastSearch();
			return RefSvcoDeleguate.getSvcoDvs().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (GesComAppException e) {
			GesComAppException sdr = new GesComAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	
}
