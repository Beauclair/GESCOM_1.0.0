package com.mincom.gescom.be.imp.sisv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mincom.gescom.be.core.base.BaseEntity;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.core.base.DateTools;
import com.mincom.gescom.be.core.dao.base.IBaseDao;
import com.mincom.gescom.be.core.dao.base.IDaoIncCod;
import com.mincom.gescom.be.core.exception.BaseException;
import com.mincom.gescom.be.core.exception.GesComAppException;
import com.mincom.gescom.be.core.exception.GesComPersistenceException;
import com.mincom.gescom.be.core.exception.GesComSystemException;
import com.mincom.gescom.be.core.sisv.base.BaseSisv;
import com.mincom.gescom.be.core.util.locator.ResourceLocator;
import com.mincom.gescom.be.imp.dao.IDaoDecImp;
import com.mincom.gescom.be.imp.entity.TabDecImp;
import com.mincom.gescom.be.imp.serialiaze.SrlImportation;
import com.mincom.gescom.be.imp.serialiaze.SrlImportationElt;
import com.mincom.gescom.be.ref.dao.IDaoPro;
import com.mincom.gescom.be.ref.entity.TabPro;
import com.mincom.gescom.be.util.EntFichier;
import com.mincom.gescom.be.util.GesComOutput;
import com.mincom.gescom.be.util.GesComPrinterExportEnum;
import com.mincom.gescom.be.util.InfoUser;
import com.mincom.gescom.be.util.ReportNames;

@Stateless
public class SisvDecImp extends BaseSisv<TabDecImp, String> implements ISisvDecImp{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvDecImp.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoDecImp daoDecSpe; 
	
	@EJB
	IDaoIncCod daoIncCod;
	
	@EJB
	IDaoPro daoPro;




	@Override
	public IBaseDao<TabDecImp, String> getBaseDao() {
		return daoDecSpe;
	}
	
	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException {
		try {
			InfoUser infUsr = p$entite.getInfoUser();
			TabDecImp impToSave = (TabDecImp)p$entite;
			String numDec = genererNumDec(impToSave);
			//On fabrique le code de l'autorisation = Année+numDec+codSite 
			String codDec =  DateTools.getYear(DateTools.formatDate(new Date()))+"DI" + numDec + infUsr.getUser().getCodSite();
			//On enregistre l'autorisation
			impToSave.setNumDec(numDec);
			impToSave.setCodDec(codDec);
			
			TabDecImp autSave = (TabDecImp) daoDecSpe.save(impToSave);
			//Récupére la liste des produit
			List<TabPro> listePro = impToSave.getListPro();
			if(listePro != null && listePro.size() > 0){
				//On parcour la liste des produit, on fixe le code du produit puis on l'enregistre
				for(TabPro proCour : listePro){
					proCour.setInfoUser(infUsr);
					String codPro = numDec +"_"+ genererCodPro(proCour);
					proCour.setCodPro(codPro);
					proCour.setCodGenImp(codDec);
					daoPro.save(proCour);
				}
			}
			return (X) autSave;			
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			String message =  e.getMessage();
			GesComAppException sysEx =  new GesComAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
		}
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws GesComSystemException {
		try {
			return daoDecSpe.findById(entity, id);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws GesComSystemException {
			
		try {
			return daoDecSpe.findAll(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws GesComSystemException {
		try {
			return daoDecSpe.findByExample(entity);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public  TabDecImp rechercherParNumDec(String numDec)
			throws GesComSystemException {
		try {
			return daoDecSpe.findByNumDec(numDec);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public  List<TabPro> rechercherProduitParCodDec(String numDec)
			throws GesComSystemException {
		try {
			return daoDecSpe.findProductByCodDec(numDec);
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			GesComSystemException sbr = new GesComSystemException(e);
			throw sbr;
		}
	}
	
	private String genererNumDec(TabDecImp tabDec) throws GesComSystemException{
		
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabDec).getValIncCod();
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			throw new GesComSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
//		 numero = DateTools.getYear(DateTools.formatDate(new Date())) + numero;
		return numero;
	}
	
	private String genererCodPro(TabPro tabPro) throws GesComSystemException{
		
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabPro).getValIncCod();
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			throw new GesComSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		return numero;
	}
	
	@Override
	public EntFichier genererDecImp(TabDecImp $vtabDec) throws GesComSystemException{
		
		try{
			SrlImportation etatImp = getEtatImportation($vtabDec);
			getLogger().debug("SisvDecImp.genererDecImp Serialisation ...");
			GesComOutput result = fillAndExport(etatImp,
					ResourceLocator.getReportModel(ReportNames.ETAT_DEC_IMP),
					GesComPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_DEC_IMP).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvDecImp.genererDecImp Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier généré " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new GesComSystemException(e.getMessage());
		}
		
	}
	
	private SrlImportation getEtatImportation(TabDecImp v$TabDecImp) throws GesComSystemException {
		SrlImportation srlImportation = new SrlImportation();
		try {
			//Recherche tous les produits 
			List<TabPro> listPro = daoDecSpe.findProductByCodDec(v$TabDecImp.getCodDec());
			if(listPro != null && listPro.size() > 0){
				//On parcour la liste des produits obtenus et on construit la sérialization  
				for(TabPro proCour : listPro){
					srlImportation.addElement(new SrlImportationElt(v$TabDecImp, proCour));
				}
			}else{
				srlImportation.addElement(new SrlImportationElt(v$TabDecImp, null));
			}
		} catch (GesComPersistenceException e) {
			e.printStackTrace();
			throw new GesComSystemException(e.getMessage());
		}
		return srlImportation;
	}
	

}
