package com.mincom.gescom.ui.ref.vue;


import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.entity.TabDvs;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;

public class DvsVue extends GesComVue<TabDvs>{
	
	
	
	public DvsVue(){
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
	public static TabDvs getTabDvs (){		
		
		TabDvs v$Dvs = new TabDvs();
		v$Dvs.setInfoUser(getInfoUser());
		v$Dvs.initData();
		return v$Dvs ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabDvs getTabDvsForSearch (){		
		TabDvs v$Dvs = getTabDvs();
		return v$Dvs ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(DvsVue.class);
	}
	
	
	public TabDvs getNewEntity(){
		return getTabDvs();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabDvs getEntityForSearch() {	
		return getTabDvsForSearch();
	}	
}
