package com.mincom.gescom.ui.ref.vue;


import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.entity.TabFour;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;

public class FourVue extends GesComVue<TabFour>{
	
	
	
	public FourVue(){
		super();
		// Instance des propriétés génériques héritées  
		this.tableMgr = new TableManager();
		this.navigationMgr = new AbstractNavigationManager();
	}
	
	/**
	 * Retourne une nouvelle Instance de l'entité  
	 * 
	 * @return
	 */	
	public static TabFour getTabFour (){		
		
		TabFour v$Four = new TabFour();
		v$Four.setInfoUser(getInfoUser());
		v$Four.initData();
		return v$Four ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabFour getTabFourForSearch (){		
		TabFour v$Four = getTabFour();
		return v$Four ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(FourVue.class);
	}
	
	
	public TabFour getNewEntity(){
		return getTabFour();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabFour getEntityForSearch() {	
		return getTabFourForSearch();
	}	
}
