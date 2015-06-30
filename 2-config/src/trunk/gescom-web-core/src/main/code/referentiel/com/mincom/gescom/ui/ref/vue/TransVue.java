package com.mincom.gescom.ui.ref.vue;


import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.entity.TabTrans;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;

public class TransVue extends GesComVue<TabTrans>{
	
	
	
	public TransVue(){
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
	public static TabTrans getTabTrans (){		
		
		TabTrans v$Trans = new TabTrans();
		v$Trans.setInfoUser(getInfoUser());
		v$Trans.initData();
		return v$Trans ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabTrans getTabTransForSearch (){		
		TabTrans v$Trans = getTabTrans();
		return v$Trans ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(TransVue.class);
	}
	
	
	public TabTrans getNewEntity(){
		return getTabTrans();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabTrans getEntityForSearch() {	
		return getTabTransForSearch();
	}	
}
