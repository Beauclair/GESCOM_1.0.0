package com.mincom.gescom.ui.ref.vue;


import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.entity.TabPays;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;

public class PaysVue extends GesComVue<TabPays>{
	
	
	
	public PaysVue(){
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
	public static TabPays getTabPays (){		
		
		TabPays v$Pays = new TabPays();
		v$Pays.setInfoUser(getInfoUser());
		v$Pays.initData();
		return v$Pays ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabPays getTabPaysForSearch (){		
		TabPays v$Pays = getTabPays();
		return v$Pays ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(PaysVue.class);
	}
	
	
	public TabPays getNewEntity(){
		return getTabPays();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabPays getEntityForSearch() {	
		return getTabPaysForSearch();
	}	
}
