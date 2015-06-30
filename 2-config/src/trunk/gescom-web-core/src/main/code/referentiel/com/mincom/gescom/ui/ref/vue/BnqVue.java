package com.mincom.gescom.ui.ref.vue;


import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.entity.TabBnq;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;

public class BnqVue extends GesComVue<TabBnq>{
	
	
	
	public BnqVue(){
		super();
		// Instance des propri�t�s g�n�riques h�rit�es  
		this.tableMgr = new TableManager();
		this.navigationMgr = new AbstractNavigationManager();
	}
	
	/**
	 * Retourne une nouvelle Instance de l'entit�  
	 * 
	 * @return
	 */	
	public static TabBnq getTabBnq (){		
		
		TabBnq v$Bnq = new TabBnq();
		v$Bnq.setInfoUser(getInfoUser());
		v$Bnq.initData();
		return v$Bnq ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabBnq getTabBnqForSearch (){		
		TabBnq v$Bnq = getTabBnq();
		return v$Bnq ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(BnqVue.class);
	}
	
	
	public TabBnq getNewEntity(){
		return getTabBnq();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabBnq getEntityForSearch() {	
		return getTabBnqForSearch();
	}	
}
