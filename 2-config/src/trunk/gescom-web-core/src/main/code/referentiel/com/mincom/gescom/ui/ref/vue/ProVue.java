package com.mincom.gescom.ui.ref.vue;


import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;

public class ProVue extends GesComVue<TabPro>{
	
	
	
	public ProVue(){
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
	public static TabPro getTabPro (){		
		
		TabPro v$Pro = new TabPro();
		v$Pro.setInfoUser(getInfoUser());
		v$Pro.initData();
		return v$Pro ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabPro getTabProForSearch (){		
		TabPro v$Pro = getTabPro();
		return v$Pro ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(ProVue.class);
	}
	
	
	public TabPro getNewEntity(){
		return getTabPro();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabPro getEntityForSearch() {	
		return getTabProForSearch();
	}	
}
