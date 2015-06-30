package com.mincom.gescom.ui.imp.controleur;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.svco.base.IBaseSvco;
import com.mincom.gescom.be.imp.entity.TabDecImp;
import com.mincom.gescom.be.ref.entity.TabAct;
import com.mincom.gescom.be.ref.entity.TabBnq;
import com.mincom.gescom.be.ref.entity.TabFour;
import com.mincom.gescom.be.ref.entity.TabImp;
import com.mincom.gescom.be.ref.entity.TabPays;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.be.ref.entity.TabTrans;
import com.mincom.gescom.be.util.EntFichier;
import com.mincom.gescom.be.util.OutputType;
import com.mincom.gescom.ui.core.base.CoreConstants;
import com.mincom.gescom.ui.core.base.FacesUtil;
import com.mincom.gescom.ui.core.base.GesComCtrl;
import com.mincom.gescom.ui.core.base.GesComToolBox;
import com.mincom.gescom.ui.core.base.ServiceLocatorException;
import com.mincom.gescom.ui.core.base.Traitement;
import com.mincom.gescom.ui.imp.util.ImpSvcoDelegaute;
import com.mincom.gescom.ui.imp.util.ImpTrt;
import com.mincom.gescom.ui.imp.vue.DecImpVue;

public class DecImpCtrl extends GesComCtrl<TabDecImp, TabDecImp>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "decImpCtrl";
	
	private TabPro produit;
	
	private Map<String, TabPro> mapPro;
	
	private BigDecimal totalDvs = BigDecimal.ZERO;
	private BigDecimal totalCfa = BigDecimal.ZERO;
	
	public DecImpCtrl(){		
		defaultVue = new DecImpVue();	
		setProduit(new TabPro());
		mapPro = new HashMap<String, TabPro>();
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "DecImp";

		System.out.println("DecImpCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				ImpTrt.getTrtStandards(v$codeEntite));
		
		// generer l'ordre de transport
		Traitement v$traitement1 = new Traitement(
				ImpTrt.GENERER_AUT_IMP);
		v$traitement1.setModalType(Traitement.MODAL_SPECIAL);
		v$traitement1.setMethode("genererDecImp");
		v$mapTrt.put(v$traitement1.getKey(), v$traitement1);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public Class<?> getMyClass() {
		return DecImpCtrl.class;
	}

	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(ImpTrt.getTrtStandards("DecImp")) ;
		}
	}

	@Override
	public List<TabDecImp> rechercherParCritere(TabDecImp p$entity)
			throws GesComAppException {
		try {
			super.setTimeOfLastSearch();
			return ImpSvcoDelegaute.getSvcoDecImp().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (GesComAppException e) {
			GesComAppException sdr = new GesComAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}

	@Override
	public IBaseSvco<TabDecImp> getEntitySvco() throws ServiceLocatorException {
		return ImpSvcoDelegaute.getSvcoDecImp();
	}

	public static String getNomManagedBean() {
		return nomManagedBean;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propri�t� � mettre � jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabImp")) {
			TabImp v$entite = (TabImp) p$entite;
			defaultVue.getEntiteCourante().setTabImp(v$entite);
		}
	
		if (v$propriete.equals("tabAct")) {

			TabAct v$entite = (TabAct) p$entite;
			defaultVue.getEntiteCourante().setTabAct(v$entite);
		}
		
		if (v$propriete.equals("tabFour")) {

			TabFour v$entite = (TabFour) p$entite;
			defaultVue.getEntiteCourante().setTabFour(v$entite);
		}
		
		if (v$propriete.equals("tabTrans")) {
			TabTrans v$entite = (TabTrans) p$entite;
			defaultVue.getEntiteCourante().setTabTrans(v$entite);
		}
		
		if (v$propriete.equals("tabBnq")) {
			TabBnq v$entite = (TabBnq) p$entite;
			defaultVue.getEntiteCourante().setTabBnq(v$entite);
		}
		
		if (v$propriete.equals("tabPaysOri")) {
			TabPays v$entite = (TabPays) p$entite;
			defaultVue.getEntiteCourante().setTabPaysOri(v$entite);
		}
		
		if (v$propriete.equals("tabPaysPro")) {
			TabPays v$entite = (TabPays) p$entite;
			defaultVue.getEntiteCourante().setTabPaysPro(v$entite);
		}
		
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public String gotoRelatedEntity() {
			
		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = super.gotoRelatedEntity();
		/*
		 * Recuperation du controleur 
		 * NB: 
		 * 	1-Cette m�thode suppose que le controleur est bel et bien dans le Scope Session
		 * 	2-Par ailleurs il devrait normalement d�ja exist� du fait du passage de param�tres dans la page web
		 */
		GesComCtrl<BaseEntity, BaseEntity> v$controleur  =  (GesComCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(GesComToolBox.getManagedBeanName(v$navigation));

		return v$navigation;
	}

	public void setProduit(TabPro produit) {
		this.produit = produit;
	}

	public TabPro getProduit() {
		return produit;
	}	
		
	public String ajouterProduit(){
		
		totalDvs = totalDvs.add(produit.getValPrixDvs());
		totalCfa = totalCfa.add(produit.getValPrixCfa());
		
		produit.setValTotalPrixDev(totalDvs);
		produit.setValTotalPrixCfa(totalCfa);
		
		System.out.println("DecImpCtrl.ValTotalPrixDev : "+totalDvs);
		System.out.println("DecImpCtrl.ValTotalPrixCfa : "+produit.getValTotalPrixCfa());
		
		System.out.println("DecImpCtrl.ajouterProduit produit : "+produit.getLibPro());
		((DecImpVue)getDefaultVue()).getProduitMgr().add(produit);
		System.out.println("DecImpCtrl.ajouterProduit() taille : "+((DecImpVue)defaultVue).getProduitMgr().getListeRecherche().size());
		mapPro.put(produit.getLibPro(), produit);
		
		System.out.println("DecImpCtrl.ValTotalPrixDev : "+totalDvs);
		System.out.println("DecImpCtrl.ValTotalPrixCfa : "+produit.getValTotalPrixCfa());
		
		initialiserProduit();
		return null;
	}

	public String supprimerProduit() {
        
		DecImpVue v$vue = (DecImpVue) defaultVue;
		TabPro produit =  v$vue.getProduitMgr().getEntiteSelectionne();
		System.out.println("je suis ici"+produit.getLibPro());
		
		totalDvs = totalDvs.subtract(produit.getValPrixDvs());
		totalCfa = totalCfa.subtract(produit.getValPrixDvs());
		
		produit.setValTotalPrixDev(totalDvs);
		produit.setValTotalPrixCfa(totalCfa);
		
		v$vue.getProduitMgr().remove(produit);
		mapPro.remove(produit.getLibPro());
		
		return null;
	}
	
	
	
	public void initialiserProduit(){
		  produit = new TabPro();
	}
	
	public String effacerPiece(){
		initialiserProduit();
		return "ok";
	}

	/**
	 * Permet de naviguer vers le formulaire de Consultaton afin de consulter  les informations relatives � une entit� 
	 * 
	 * @return
	 */
	public String afficher(){
		
		String v$navigation = null;
		try {	
		// L'entit� selectionn� devient l'objet courant; Cela suppose que le Contexte de page est Liste
		defaultVue.setEntiteCourante(defaultVue.getTableMgr().getEntiteSelectionne());
		
		// Par simple Prudence, on dira si l'entite existe
		if(defaultVue.getEntiteCourante() != null){
			
			// Mise � jour de la navigation : Vers le formulaire de Details
			v$navigation =  getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_DETAILS);
			
			// MAJ de l'ID � display
			setIdEntityToDisplay(defaultVue.getEntiteCourante().getId());
		}
		
		// Recherche des produits de l'ordre
		List<TabPro> liste = ImpSvcoDelegaute.getSvcoDecImp().rechercherProduitParCodDec(defaultVue.getEntiteCourante().getCodDec());
		((DecImpVue)defaultVue).getProduitMgr().clear();
		((DecImpVue)defaultVue).getProduitMgr().add(liste);
		
		// Mise en coh�rence des IMH
		coherenceIHM();
		
	}	
	catch (Exception e) {	
		e.printStackTrace();
		//Message utilisateur
		FacesUtil.addWarnMessage("TRAITEMENT_ALL_ECHEC", "TRAITEMENT_ALL_ECHEC_INCONNU");
		getLogger().error(e.getMessage(), e);
	}		
		// Retour � la page ad�quate
		return v$navigation;
	}
	
	
	/***
	 * Enregistre la cr�ation ou la modification d'une entit� 
	 * 
	 * @return
	 */
	
	@SuppressWarnings("finally")
	@Override
	public String enregistrer(){
		
		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;
				
		getLogger().debug("DEBUG m�thode enregistrer!");
		
		try {
			
			// Si nous sommes en Cr�ation sur le Formulaire d'Edition
			if(! defaultVue.getNavigationMgr().getEnModification()){
				// Set la liste des produits de l'ordre de transport
				defaultVue.getEntiteCourante().setListPro(((DecImpVue)defaultVue).getProduitMgr().getListeRecherche());
				// Consommation de l'EJB distant pour la cr�ation
				defaultVue.setEntiteCourante((TabDecImp) getEntitySvco().creer(defaultVue.getEntiteCourante()));
								
				// Raffra�chissement de l'entit� courante pour des besoins de mises � jour des entit�s li�s s'il y'en a				
				defaultVue.setEntiteCourante((TabDecImp) getEntitySvco().rechercher(defaultVue.getEntiteCourante(), defaultVue.getEntiteCourante().getId()));
				
				getLogger().debug("DEBUG rechercher");
				
				// MAJ de la liste de Recherche
				defaultVue.getTableMgr().add(defaultVue.getEntiteCourante());					
				
				// Apr�s un enregistrement nous retournons toujours en consultation 
				v$navigation = getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_DETAILS);
				
				FacesUtil.addInfoMessage("","CREATION_SUCCESS");
											
			}
			
			// Par contre Si nous sommes en modification sur le Formulaire d'Edition
			else{
				//R�cup�re la liste de tous les produits en modification
				List<TabPro> listPro = ((DecImpVue)defaultVue).getProduitMgr().getListeRecherche();
				//Charge la liste dans un map
				Map<String, TabPro> mapProMod = new HashMap<String, TabPro>();
				for(TabPro proCurrent : listPro){
					mapProMod.put(proCurrent.getLibPro(), proCurrent);
				}
				// Recherche des produits de l'ordre d�j� exixtant
				List<TabPro> liste = ImpSvcoDelegaute.getSvcoDecImp().rechercherProduitParCodDec(defaultVue.getEntiteCourante().getCodDec());
				//On parcour la liste des produits exixtant et on les retire du map
				for(TabPro proToRemove : liste){
					if(mapProMod.containsKey(proToRemove.getLibPro())){
						mapProMod.remove(proToRemove.getLibPro());
					}
				}
				List<TabPro> newPro = new ArrayList<TabPro>(mapProMod.values());
				defaultVue.getEntiteCourante().setListPro(newPro);
				
				// Set la liste des produits de l'ordre de transport
//				defaultVue.getEntiteCourante().setListCon(((DecImpVue)defaultVue).getproduitMgr().getListeRecherche());
				
				// Consommation de l'EJB distant pour la cr�ation 
				defaultVue.setEntiteCourante((TabDecImp) getEntitySvco().modifier(defaultVue.getEntiteCourante()));
				
				// Raffra�chissement de l'entit� courante pour des besoins de mises � jour des entit�s li�s s'il y'en a				
				defaultVue.setEntiteCourante((TabDecImp) getEntitySvco().rechercher(defaultVue.getEntiteCourante(), defaultVue.getEntiteCourante().getId()));
			
				// MAJ de la liste de Recherche
				defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(), defaultVue.getEntiteCourante());
				
				
				// Apr�s un enregistrement nous retournons toujours en consultation 
				v$navigation = getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_DETAILS);
						
				FacesUtil.addInfoMessage("", "MODIFICATION_SUCCESS");
			
			}	
			// Recherche des produits de l'ordre
			List<TabPro> liste = ImpSvcoDelegaute.getSvcoDecImp().rechercherProduitParCodDec(defaultVue.getEntiteCourante().getCodDec());
			getLogger().debug("DEBUG enregistrer : liste = " + liste.size());
			((DecImpVue)defaultVue).getProduitMgr().clear();
			((DecImpVue)defaultVue).getProduitMgr().add(liste);
			
			mapPro.clear();

			// Coherence IHM avant affichage du formulaire de consultation
//			coherenceIHM();
		}	
		
		catch (Exception e) {	
			
			e.printStackTrace();
			// Aucune navigation possible
			v$navigation = null;
			
			//Message utilisateur
			FacesUtil.addWarnMessage("TRAITEMENT_ALL_ECHEC", "TRAITEMENT_ALL_ECHEC_INCONNU");
			getLogger().error(e.getMessage(), e);
		}		
				
		finally{
			
			// Retour � la page ad�quate	
			return v$navigation;
		}	
		
	}	
	
	/**
	 * Permet de naviguer vers le formulaire d'Edition afin de creer une nouvelle entit�
	 * 
	 * @return
	 */
	public String ajouter(){
		
		((DecImpVue)defaultVue).getProduitMgr().clear();
		mapPro.clear();
		
		// Determine vers quelle page ou formulaire l'on doit se diriger
		String v$navigation = null;
		
		// Mise � jour de l'entit� courante selon le contexte du Formulaire 
		if(defaultVue.getNavigationMgr().isFromListe())
			defaultVue.setEntiteCourante(defaultVue.getTableMgr().getEntiteSelectionne());		
		
		// Sauvegarde de l'entit� courante 
		defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
		
		// L'entit� courante devient vierge afin qu'aucunes donn�es ne s'affichent sur l'interface graphique 
		defaultVue.setEntiteCourante(defaultVue.getNewEntity());
		
		// Mise � jour du Contexte : En cr�ation 
		defaultVue.getNavigationMgr().setEnModification(false);
		
		// Mise � jour de la navigation : Vers le formulaire d'Edition
		v$navigation =  getMemoEntite().concat("Edition");
		
		// Retour � la page ad�quate
		return v$navigation;
	}	
	
	/***
	 * Annule la modification ou la cr�ation d'une entit� 
	 * 
	 * @return
	 */
	public String annulerEdition(){
		try {
			mapPro.clear();
			// Determine vers quelle page ou Formulaire l'on doit se diriger
			String v$navigation = null;
			
			// Restauration de l'entit� temporairement sauvegard�
			defaultVue.setEntiteCourante(defaultVue.getEntiteTemporaire());
			
			// Si nous sommes parti du Formulaire Details vers le Formulaire d'Edition
			if(defaultVue.getNavigationMgr().isFromDetails()){
				
				// Alors nous retournons vers le formulaire Details
				v$navigation = getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_DETAILS);
				// Recherche des produits de l'ordre
				List<TabPro>	liste = ImpSvcoDelegaute.getSvcoDecImp().rechercherProduitParCodDec(defaultVue.getEntiteCourante().getCodDec());
				getLogger().debug("DEBUG enregistrer : liste = " + liste.size());
				((DecImpVue)defaultVue).getProduitMgr().clear();
				((DecImpVue)defaultVue).getProduitMgr().add(liste);
				
				//Mise en Coh�rence des IHMs avant de retourner sur le formulaire de Consultation
			}	
			
			// Sinon nous retournons vers le formulaire Liste 
			else {
				
				// Alors nous retournons vers le formulaire Liste
				v$navigation = getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_LISTE);
				
			}
			
			// Retour � la page ad�quate	
			return v$navigation;
		
		} catch (GesComAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Permet de Naviguer vers le formulaire d'Edition afin de pouvoir modifier une entit� 
	 * 	
	 * @return
	 */
	public String modifier(){
		
		mapPro.clear();
		// Determine vers quelle page ou formulaire l'on doit se diriger
		String v$navigation = null;
			
		// Mise � jour du Contexte : En Modification 
		defaultVue.getNavigationMgr().setEnModification(true);
		
		// Mise � jour de l'entit� courante selon le contexte du Formulaire 
		if(defaultVue.getNavigationMgr().isFromListe())
			defaultVue.setEntiteCourante(defaultVue.getTableMgr().getEntiteSelectionne());
		
		
		// Sauvegarde de l'entit� courante 
		defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
		
		// Clone de l'Entit� courante avant Modification
		defaultVue.setEntiteCourante(defaultVue.clone(defaultVue.getEntiteCourante()));
		
							
		// Si nous sommes en Consultation ==> sur le formulaire Details
		// Donc l'entit� courante est d�ja connue
		if(defaultVue.getNavigationMgr().isFromDetails()){
									
			// Mise � jour de la navigation : Vers le formulaire d'Edition
			v$navigation =  getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_EDITION);			
		}
		
		// Par contre si nous sommes sur le formulaire Liste 
		else if(defaultVue.getNavigationMgr().isFromListe()){
						
			// Par simple Prudence, on dit si l'entite existe
			if(defaultVue.getEntiteCourante() != null){
												
				// Mise � jour de la navigation : Vers le formulaire d'Edition
				v$navigation =  getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_EDITION);				
			}
		}
		// Recherche des produits de l'ordre
		try {
			List<TabPro> liste = ImpSvcoDelegaute.getSvcoDecImp().rechercherProduitParCodDec(defaultVue.getEntiteCourante().getCodDec());
			getLogger().debug("DEBUG enregistrer : liste = " + liste.size());
			((DecImpVue)defaultVue).getProduitMgr().clear();
			((DecImpVue)defaultVue).getProduitMgr().add(liste);
		} catch (GesComAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		
		
		// Retour � la page ad�quate
		return v$navigation;
	}	
	
	public BigDecimal getTotalDvs() {
		return totalDvs;
	}

	public void setTotalDvs(BigDecimal totalDvs) {
		this.totalDvs = totalDvs;
	}

	public BigDecimal getTotalCfa() {
		return totalCfa;
	}

	public void setTotalCfa(BigDecimal totalCfa) {
		this.totalCfa = totalCfa;
	}
	
	/**
	 * G�n�re une autorisation d'importation
	 * 
	 * @return un message  sur l'�tat de l'op�ration
	 */
	@SuppressWarnings("finally")
	public String genererDecImp() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "GENERATION_SUCCES";

		try {
			DecImpVue v$vue = (DecImpVue) defaultVue;

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			defaultVue.setEntiteCouranteOfPageContext();

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Sp�cification du type de g�n�ration du fichier
			OutputType outputType = OutputType.PDF;

			// Consommation du service distant
			TabDecImp autCourant = defaultVue.getEntiteCourante();
			EntFichier v$fichier = ImpSvcoDelegaute.getSvcoDecImp().genererDecImp(autCourant);

			// cr�ation de dossier et fichiers temporaires et affichage de
			// l'�tat g�n�r�
			v$navigation = preview(v$fichier, outputType.getExtension());
			
			// L'on remplace l'ancienne entit� de la liste par la nouvelle issue
			// du r�sultat du traitement sp�cifiques
			 defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					 defaultVue.getEntiteCourante());

			// Si nous sommes en Consultation ==> sur le formulaire Details
			if (defaultVue.getNavigationMgr().isFromDetails()) {
				// Traitements particuliers
			}

			// Par contre si nous sommes sur le formulaire Liste
			else if (defaultVue.getNavigationMgr().isFromListe()) {
				// Traitements particuliers
			}
			FacesUtil.addInfoMessage("GENERATION_SUCCES", v$msgDetails);

		} catch (GesComAppException e) {
			// Aucune navigation possible
			v$navigation = null;

			// Message utilisateur
			FacesUtil
					.addWarnMessage("TRAITEMENT_ALL_ECHEC", e.getMessage());
			getLogger().error(e.getMessage(), e);
		} catch (Exception e) {
			// Aucune navigation possible
			e.printStackTrace();
			v$navigation = null;
			// Message utilisateur
			FacesUtil
					.addWarnMessage(
							"TRAITEMENT_ALL_ECHEC","TRAITEMENT_ALL_ECHEC_INCONNU");
			getLogger().error(e.getMessage(), e);
		} finally {
			// Retour � la page ad�quate
			return v$navigation;
		}

	}
	
}
