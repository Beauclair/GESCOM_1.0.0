package com.mincom.gescom.be.imp.serialiaze;

import com.mincom.gescom.be.imp.entity.TabAutSpeImp;
import com.mincom.gescom.be.imp.entity.TabDecImp;
import com.mincom.gescom.be.ref.entity.TabPro;

public class SrlImportationElt {
	
	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";

	private String cNumAutSpeImpt;
	private String lNomSteImpt;
	private String lAdrImpt;
	private String cBpImpt;
	private String cNumFaxImpt;
	private String cNumTelImpt;
	private String lPaysImpt; 
	private String lNtrActDecla;
	private String cNumCodeAct;
	private String cNiu;
	private String lNomSteFour;
	private String lAdrFour;
	private String lBpFour;
	private String cNumFaxFour;
	private String cNumTelFour;
	private String lPaysFour ;
	private String lTransAgre ;
	private String lBnq ;
	private String lDevis;
	private String zTaux;
	private String vMntDevis;
	private String vMntCfa ;
	private String lMotifImpt;
	private String lPaysOrig;
	private String lPaysProv;
	private String eModPaie;
	private String eModTrspt;
	private String eRltAvecFour;
	private String lBureauDouane;
	private String lEmailImpt;
	private String lEmailFour;
	private String lNtrProduit;
	private String lArt;
	private String cPosTarif;
	private String lColis;
	private String zQte;
	private String zPoids;
	
	public SrlImportationElt(){
		
	}
	
	public SrlImportationElt(TabAutSpeImp aut, TabPro pro){
		
		try {this.cNumAutSpeImpt = aut.getNumAut();
		}catch (Exception e) { this.cNumAutSpeImpt=ERROR_VALUE ;
		}
		
		try {this.lNomSteImpt = aut.getTabImp().getLibImp();
		}catch (Exception e) { this.lNomSteImpt=ERROR_VALUE ;
		}
		
		try {this.lAdrImpt = aut.getTabImp().getLibAdr();
		}catch (Exception e) { this.lAdrImpt=ERROR_VALUE ;
		}
		
		try {this.cBpImpt = aut.getTabImp().getLibBoiPos();
		}catch (Exception e) { this.cBpImpt=ERROR_VALUE ;
		}
		
		try {this.cNumFaxImpt = aut.getTabImp().getLibFax();
		}catch (Exception e) { this.cNumFaxImpt=ERROR_VALUE ;
		}
		
		try {this.cNumTelImpt = aut.getTabImp().getLibTel();
		}catch (Exception e) { this.cNumTelImpt=ERROR_VALUE ;
		}
		
		try {this.lPaysImpt = "";
		}catch (Exception e) { this.lPaysImpt=ERROR_VALUE ;
		}
		
		try {this.lNtrActDecla = aut.getTabAct().getLibNatActDec();
		}catch (Exception e) { this.lNtrActDecla=ERROR_VALUE ;
		}
		
		try {this.cNumCodeAct = aut.getTabAct().getNumCodAct();
		}catch (Exception e) { this.cNumCodeAct=ERROR_VALUE ;
		}
		
		try {this.cNiu = aut.getTabImp().getCodNiu();
		}catch (Exception e) { this.cNiu=ERROR_VALUE ;
		}
		
		try {this.lNomSteFour = aut.getTabFour().getLibFour();
		}catch (Exception e) { this.lNomSteFour=ERROR_VALUE ;
		}
		
		try {this.lAdrFour = aut.getTabFour().getLibAdr();
		}catch (Exception e) { this.cNumCodeAct=ERROR_VALUE ;
		}
		
		try {this.lBpFour = aut.getTabFour().getLibBoiPos();
		}catch (Exception e) { this.lBpFour=ERROR_VALUE ;
		}
		
		try {this.cNumFaxFour = aut.getTabFour().getLibFax();
		}catch (Exception e) { this.cNumFaxFour=ERROR_VALUE ;
		}
		
		try {this.cNumTelFour = aut.getTabFour().getLibTel();
		}catch (Exception e) { this.cNumTelFour=ERROR_VALUE ;
		}
		
		try {this.lPaysFour = aut.getTabFour().getTabPays().getLibPays();
		}catch (Exception e) { this.lPaysFour=ERROR_VALUE ;
		}
		
		try {this.lTransAgre = aut.getTabTrans().getLibTrans();
		}catch (Exception e) { this.lTransAgre=ERROR_VALUE ;
		}
		
		try {this.lBnq = aut.getTabBnq().getLibBnq();
		}catch (Exception e) { this.lBnq=ERROR_VALUE ;
		}
		
		try {this.lDevis = aut.getLibDvs();
		}catch (Exception e) { this.lDevis=ERROR_VALUE ;
		}
		
		try {this.zTaux = aut.getTauxDvs().toString();
		}catch (Exception e) { this.zTaux=ERROR_VALUE ;
		}
		
		try {this.vMntDevis = pro.getValPrixDvs().toString();
		}catch (Exception e) { this.zTaux=ERROR_VALUE ;
		}
		
		try {this.vMntCfa = pro.getValPrixCfa().toString();
		}catch (Exception e) { this.zTaux=ERROR_VALUE ;
		}
		
		try {this.lMotifImpt = aut.getLibMotif();
		}catch (Exception e) { this.lMotifImpt=ERROR_VALUE ;
		}
		
		try {this.lPaysOrig = aut.getTabPaysOri().getLibPays();
		}catch (Exception e) { this.lPaysOrig=ERROR_VALUE ;
		}
		
		try {this.lPaysProv = aut.getTabPaysPro().getLibPays();
		}catch (Exception e) { this.lPaysProv=ERROR_VALUE ;
		}
		
		try {this.eModPaie = aut.getEnuModPaie();
		}catch (Exception e) { this.eModPaie=ERROR_VALUE ;
		}
		
		try {this.eModTrspt = aut.getEnuModTrans();
		}catch (Exception e) { this.eModTrspt=ERROR_VALUE ;
		}
		
		try {this.eRltAvecFour = aut.getEnuRelFour();
		}catch (Exception e) { this.eModTrspt=ERROR_VALUE ;
		}
		
		try {this.lBureauDouane = aut.getLibBurDed();
		}catch (Exception e) { this.lBureauDouane=ERROR_VALUE ;
		}
		
		try {this.lEmailImpt = aut.getTabImp().getLibEmail();
		}catch (Exception e) { this.lEmailImpt=ERROR_VALUE ;
		}
		
		try {this.lEmailFour = aut.getTabFour().getLibEmail();
		}catch (Exception e) { this.lEmailFour=ERROR_VALUE ;
		}
		
		try {this.lNtrProduit = aut.getLibInt();
		}catch (Exception e) { this.lEmailFour=ERROR_VALUE ;
		}
		
		try {this.lArt = pro.getLibPro();
		}catch (Exception e) { this.lArt=ERROR_VALUE ;
		}
		
		try {this.cPosTarif = pro.getLibPosiTarif();
		}catch (Exception e) { this.cPosTarif=ERROR_VALUE ;
		}
		
		try {this.lColis = pro.getLibColi();
		}catch (Exception e) { this.lColis=ERROR_VALUE ;
		}
		
		try {this.zQte = pro.getValQte().toString();
		}catch (Exception e) { this.lColis=ERROR_VALUE ;
		}
		
		try {this.zPoids = pro.getLibPoiNet();
		}catch (Exception e) { this.zPoids=ERROR_VALUE ;
		}
		
	}
	
	public SrlImportationElt(TabDecImp dec, TabPro pro){
		
		try {this.cNumAutSpeImpt = dec.getNumDec();
		}catch (Exception e) { this.cNumAutSpeImpt=ERROR_VALUE ;
		}
		
		try {this.lNomSteImpt = dec.getTabImp().getLibImp();
		}catch (Exception e) { this.lNomSteImpt=ERROR_VALUE ;
		}
		
		try {this.lAdrImpt = dec.getTabImp().getLibAdr();
		}catch (Exception e) { this.lAdrImpt=ERROR_VALUE ;
		}
		
		try {this.cBpImpt = dec.getTabImp().getLibBoiPos();
		}catch (Exception e) { this.cBpImpt=ERROR_VALUE ;
		}
		
		try {this.cNumFaxImpt = dec.getTabImp().getLibFax();
		}catch (Exception e) { this.cNumFaxImpt=ERROR_VALUE ;
		}
		
		try {this.cNumTelImpt = dec.getTabImp().getLibTel();
		}catch (Exception e) { this.cNumTelImpt=ERROR_VALUE ;
		}
		
		try {this.lPaysImpt = "";
		}catch (Exception e) { this.lPaysImpt=ERROR_VALUE ;
		}
		
		try {this.lNtrActDecla = dec.getTabAct().getLibNatActDec();
		}catch (Exception e) { this.lNtrActDecla=ERROR_VALUE ;
		}
		
		try {this.cNumCodeAct = dec.getTabAct().getNumCodAct();
		}catch (Exception e) { this.cNumCodeAct=ERROR_VALUE ;
		}
		
		try {this.cNiu = dec.getTabImp().getCodNiu();
		}catch (Exception e) { this.cNiu=ERROR_VALUE ;
		}
		
		try {this.lNomSteFour = dec.getTabFour().getLibFour();
		}catch (Exception e) { this.lNomSteFour=ERROR_VALUE ;
		}
		
		try {this.lAdrFour = dec.getTabFour().getLibAdr();
		}catch (Exception e) { this.cNumCodeAct=ERROR_VALUE ;
		}
		
		try {this.lBpFour = dec.getTabFour().getLibBoiPos();
		}catch (Exception e) { this.lBpFour=ERROR_VALUE ;
		}
		
		try {this.cNumFaxFour = dec.getTabFour().getLibFax();
		}catch (Exception e) { this.cNumFaxFour=ERROR_VALUE ;
		}
		
		try {this.cNumTelFour = dec.getTabFour().getLibTel();
		}catch (Exception e) { this.cNumTelFour=ERROR_VALUE ;
		}
		
		try {this.lPaysFour = dec.getTabFour().getTabPays().getLibPays();
		}catch (Exception e) { this.lPaysFour=ERROR_VALUE ;
		}
		
		try {this.lTransAgre = dec.getTabTrans().getLibTrans();
		}catch (Exception e) { this.lTransAgre=ERROR_VALUE ;
		}
		
		try {this.lBnq = dec.getTabBnq().getLibBnq();
		}catch (Exception e) { this.lBnq=ERROR_VALUE ;
		}
		
		try {this.lDevis = dec.getLibDvs();
		}catch (Exception e) { this.lDevis=ERROR_VALUE ;
		}
		
		try {this.zTaux = dec.getTauxDvs().toString();
		}catch (Exception e) { this.zTaux=ERROR_VALUE ;
		}
		
		try {this.vMntDevis = pro.getValPrixDvs().toString();
		}catch (Exception e) { this.zTaux=ERROR_VALUE ;
		}
		
		try {this.vMntCfa = pro.getValPrixCfa().toString();
		}catch (Exception e) { this.zTaux=ERROR_VALUE ;
		}
		
		try {this.lMotifImpt = dec.getLibMotif();
		}catch (Exception e) { this.lMotifImpt=ERROR_VALUE ;
		}
		
		try {this.lPaysOrig = dec.getTabPaysOri().getLibPays();
		}catch (Exception e) { this.lPaysOrig=ERROR_VALUE ;
		}
		
		try {this.lPaysProv = dec.getTabPaysPro().getLibPays();
		}catch (Exception e) { this.lPaysProv=ERROR_VALUE ;
		}
		
		try {this.eModPaie = dec.getEnuModPaie();
		}catch (Exception e) { this.eModPaie=ERROR_VALUE ;
		}
		
		try {this.eModTrspt = dec.getEnuModTrans();
		}catch (Exception e) { this.eModTrspt=ERROR_VALUE ;
		}
		
		try {this.eRltAvecFour = dec.getEnuRelFour();
		}catch (Exception e) { this.eModTrspt=ERROR_VALUE ;
		}
		
		try {this.lBureauDouane = dec.getLibBurDed();
		}catch (Exception e) { this.lBureauDouane=ERROR_VALUE ;
		}
		
		try {this.lEmailImpt = dec.getTabImp().getLibEmail();
		}catch (Exception e) { this.lEmailImpt=ERROR_VALUE ;
		}
		
		try {this.lEmailFour = dec.getTabFour().getLibEmail();
		}catch (Exception e) { this.lEmailFour=ERROR_VALUE ;
		}
		
		try {this.lNtrProduit = dec.getLibInt();
		}catch (Exception e) { this.lEmailFour=ERROR_VALUE ;
		}
		
		try {this.lArt = pro.getLibPro();
		}catch (Exception e) { this.lArt=ERROR_VALUE ;
		}
		
		try {this.cPosTarif = pro.getLibPosiTarif();
		}catch (Exception e) { this.cPosTarif=ERROR_VALUE ;
		}
		
		try {this.lColis = pro.getLibColi();
		}catch (Exception e) { this.lColis=ERROR_VALUE ;
		}
		
		try {this.zQte = pro.getValQte().toString();
		}catch (Exception e) { this.lColis=ERROR_VALUE ;
		}
		
		try {this.zPoids = pro.getLibPoiNet();
		}catch (Exception e) { this.zPoids=ERROR_VALUE ;
		}
		
	}

	public String getNumdi() {
		return cNumAutSpeImpt;
	}

	public void setNumdi(String cNumAutSpeImpt) {
		this.cNumAutSpeImpt = cNumAutSpeImpt;
	}

	public String getImportateur() {
		return lNomSteImpt;
	}

	public void setImportateur(String lNomSteImpt) {
		this.lNomSteImpt = lNomSteImpt;
	}

	public String getAdrImport() {
		return lAdrImpt;
	}

	public void setAdrImport(String lAdrImpt) {
		this.lAdrImpt = lAdrImpt;
	}

	public String getBpImport() {
		return cBpImpt;
	}

	public void setBpImport(String cBpImpt) {
		this.cBpImpt = cBpImpt;
	}

	public String getFaxImport() {
		return cNumFaxImpt;
	}

	public void setFaxImport(String cNumFaxImpt) {
		this.cNumFaxImpt = cNumFaxImpt;
	}

	public String getTelImport() {
		return cNumTelImpt;
	}

	public void setTelImport(String cNumTelImpt) {
		this.cNumTelImpt = cNumTelImpt;
	}

	public String getPaysImport() {
		return lPaysImpt;
	}

	public void setPaysImport(String lPaysImpt) {
		this.lPaysImpt = lPaysImpt;
	}

	public String getNtrActiviteDeclare() {
		return lNtrActDecla;
	}

	public void setNtrActiviteDeclare(String lNtrActDecla) {
		this.lNtrActDecla = lNtrActDecla;
	}

	public String getcActivite() {
		return cNumCodeAct;
	}

	public void setcActivite(String cNumCodeAct) {
		this.cNumCodeAct = cNumCodeAct;
	}

	public String getCniu() {
		return cNiu;
	}

	public void setCniu(String cNiu) {
		this.cNiu = cNiu;
	}

	public String getFournisseur() {
		return lNomSteFour;
	}

	public void setFournisseur(String lNomSteFour) {
		this.lNomSteFour = lNomSteFour;
	}

	public String getAdrfour() {
		return lAdrFour;
	}

	public void setAdrfour(String lAdrFour) {
		this.lAdrFour = lAdrFour;
	}

	public String getBpfour() {
		return lBpFour;
	}

	public void setBpfour(String lBpFour) {
		this.lBpFour = lBpFour;
	}

	public String getFaxfour() {
		return cNumFaxFour;
	}

	public void setFaxfour(String cNumFaxFour) {
		this.cNumFaxFour = cNumFaxFour;
	}

	public String getTelfour() {
		return cNumTelFour;
	}

	public void setTelfour(String cNumTelFour) {
		this.cNumTelFour = cNumTelFour;
	}

	public String getPaysfour() {
		return lPaysFour;
	}

	public void setPaysfour(String lPaysFour) {
		this.lPaysFour = lPaysFour;
	}

	public String getTransitaire() {
		return lTransAgre;
	}

	public void setTransitaire(String lTransAgre) {
		this.lTransAgre = lTransAgre;
	}

	public String getDomiciliation() {
		return lBnq;
	}

	public void setDomiciliation(String lBnq) {
		this.lBnq = lBnq;
	}

	public String getDevise() {
		return lDevis;
	}

	public void setDevise(String lDevis) {
		this.lDevis = lDevis;
	}

	public String getTaux() {
		return zTaux;
	}

	public void setTaux(String zTaux) {
		this.zTaux = zTaux;
	}

	public String getvMntDevis() {
		return vMntDevis;
	}

	public void setvMntDevis(String vMntDevis) {
		this.vMntDevis = vMntDevis;
	}

	public String getvMntCfa() {
		return vMntCfa;
	}

	public void setvMntCfa(String vMntCfa) {
		this.vMntCfa = vMntCfa;
	}

	public String getMotifImport() {
		return lMotifImpt;
	}

	public void setMotifImport(String lMotifImpt) {
		this.lMotifImpt = lMotifImpt;
	}

	public String getPaysOrigine() {
		return lPaysOrig;
	}

	public void setPaysOrigine(String lPaysOrig) {
		this.lPaysOrig = lPaysOrig;
	}

	public String getPaysProvenance() {
		return lPaysProv;
	}

	public void setPaysProvenance(String lPaysProv) {
		this.lPaysProv = lPaysProv;
	}

	public String getModalitePaie() {
		return eModPaie;
	}

	public void setModalitePaie(String eModPaie) {
		this.eModPaie = eModPaie;
	}

	public String getModeTransport() {
		return eModTrspt;
	}

	public void setModeTransport(String eModTrspt) {
		this.eModTrspt = eModTrspt;
	}

	public String getRelationFournisseur() {
		return eRltAvecFour;
	}

	public void setRelationFournisseur(String eRltAvecFour) {
		this.eRltAvecFour = eRltAvecFour;
	}

	public String getBureauDouane() {
		return lBureauDouane;
	}

	public void setBureauDouane(String lBureauDouane) {
		this.lBureauDouane = lBureauDouane;
	}

	public String getEmailImport() {
		return lEmailImpt;
	}

	public void setEmailImport(String lEmailImpt) {
		this.lEmailImpt = lEmailImpt;
	}

	public String getEmailFour() {
		return lEmailFour;
	}

	public void setEmailFour(String lEmailFour) {
		this.lEmailFour = lEmailFour;
	}

	public String getNtrProduit() {
		return lNtrProduit;
	}

	public void setNtrProduit(String lNtrProduit) {
		this.lNtrProduit = lNtrProduit;
	}

	public String getLmarchan() {
		return lArt;
	}

	public void setLmarchan(String lArt) {
		this.lArt = lArt;
	}

	public String getcPosTarifaire() {
		return cPosTarif;
	}

	public void setcPosTarifaire(String cPosTarif) {
		this.cPosTarif = cPosTarif;
	}

	public String getColisage() {
		return lColis;
	}

	public void setColisage(String lColis) {
		this.lColis = lColis;
	}

	public String getQte() {
		return zQte;
	}

	public void setQte(String zQte) {
		this.zQte = zQte;
	}

	public String getPoids() {
		return zPoids;
	}

	public void setPoids(String zPoids) {
		this.zPoids = zPoids;
	}	


}
