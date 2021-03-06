package com.mincom.gescom.ui.imp.vue;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.mincom.gescom.be.core.enums.EnuModPaie;
import com.mincom.gescom.be.core.enums.EnuModTrans;
import com.mincom.gescom.be.core.enums.EnuRelFour;
import com.mincom.gescom.be.imp.entity.TabDecImp;
import com.mincom.gescom.be.ref.entity.TabDvs;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.ui.core.base.AbstractNavigationManager;
import com.mincom.gescom.ui.core.base.GesComToolBox;
import com.mincom.gescom.ui.core.base.GesComVue;
import com.mincom.gescom.ui.core.base.TableManager;
import com.mincom.gescom.ui.ref.util.RefSvcoDeleguate;

public class DecImpVue extends GesComVue<TabDecImp>{
	
	private TabPro produit;
	
	private  Map<String, Object> listeModPaie;
	
	private  Map<String, Object> listeModTrans;
	
	private  Map<String, Object> listeRelFour;
	
	private List<SelectItem> listeDevise;
	
	//mapSitr
	private Map<String, TabDvs> mapDevise = new HashMap<String, TabDvs>();
	
	/**
	 * Gestionnaire (de la liste)des produit
	 */
	private TableManager<TabPro> produitMgr = new TableManager<TabPro>();
	
	
	public DecImpVue(){
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
	public static TabDecImp getTabDecImp (){		
		
		TabDecImp v$DecImp = new TabDecImp();
		v$DecImp.setInfoUser(getInfoUser());
		v$DecImp.initData();
		return v$DecImp ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabDecImp getTabDecImpForSearch (){		
		TabDecImp v$DecImp = getTabDecImp();
		return v$DecImp ;	
	}	
	
	public TabDecImp getNewEntity(){
		return getTabDecImp();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabDecImp getEntityForSearch() {	
		return getTabDecImpForSearch();
	}
	
	public void setProduit(TabPro produit) {
		this.produit = produit;
	}

	public TabPro getProduit() {
		return produit;
	}

	public void setProduitMgr(TableManager<TabPro> produitMgr) {
		this.produitMgr = produitMgr;
	}

	public TableManager<TabPro> getProduitMgr() {
		return produitMgr;
	}	
	
	public void setListeModPaie(Map<String, Object> listeModPaie) {
		this.listeModPaie = listeModPaie;
	}

	public Map<String, Object> getListeModPaie() {
		if(listeModPaie == null){
			listeModPaie = GesComToolBox.getComboData(EnuModPaie.getMaps());
			listeModPaie.put("", "");
		}
		return listeModPaie;
	}

	public void setListeModTrans(Map<String, Object> listeModTrans) {
		this.listeModTrans = listeModTrans;
	}

	public Map<String, Object> getListeModTrans() {
		if(listeModTrans == null){
			listeModTrans = GesComToolBox.getComboData(EnuModTrans.getMaps());
			listeModTrans.put("", "");
		}
		return listeModTrans;
	}

	public void setListeRelFour(Map<String, Object> listeRelFour) {
		this.listeRelFour = listeRelFour;
	}

	public Map<String, Object> getListeRelFour() {
		if(listeRelFour == null){
			listeRelFour = GesComToolBox.getComboData(EnuRelFour.getMaps());
			listeRelFour.put("", "");
		}
		return listeRelFour;
	}
	

	
	public List<SelectItem> getListeDevise() {

		if(listeDevise == null){
			
			listeDevise = new ArrayList<SelectItem>();
			
			List<TabDvs> v$dvs = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabDvs v$critere = new TabDvs();	
			
			// Recherche des comptes en BD 			
			try {
				v$dvs = RefSvcoDeleguate.getSvcoDvs().rechercherTout(v$critere);
				System.out.println(">>>>>>>>>>>>>>>>>> " + v$dvs);
			} 
			catch (Exception e) {
				System.out.println(">>>>>>>>>>>>>>>>>> exception >>>>>>>>>>>>>>");
				e.printStackTrace();
			} 
			
			v$dvs = (v$dvs != null)? v$dvs : new ArrayList<TabDvs>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabDvs v$courDvs: v$dvs){
				SelectItem v$item = new SelectItem(v$courDvs.getCodDvs(),v$courDvs.getCodDvs());
				listeDevise.add(v$item);
				mapDevise.put(v$courDvs.getCodDvs(), v$courDvs);
			}
		}
		return listeDevise;
	}
	
	public void updateLibDvs(ActionEvent evt){
		getEntiteCourante().setLibDvs(mapDevise.get(getEntiteCourante().getCodDvs()).getLibDvs());
	}

}
