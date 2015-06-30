package com.mincom.gescom.ui.ref.vue;


import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.entity.TabImp;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;

public class ImpVue extends GesComVue<TabImp>{
	
	
	
	public ImpVue(){
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
	public static TabImp getTabImp (){		
		
		TabImp v$Imp = new TabImp();
		v$Imp.setInfoUser(getInfoUser());
		v$Imp.initData();
		return v$Imp ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabImp getTabImpForSearch (){		
		TabImp v$Imp = getTabImp();
		return v$Imp ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(ImpVue.class);
	}
	
	
	public TabImp getNewEntity(){
		return getTabImp();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabImp getEntityForSearch() {	
		return getTabImpForSearch();
	}	
}
