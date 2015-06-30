package com.mincom.gescom.ui.admin.util;

/**
 * 
 */

import com.mincom.gescom.be.admin.svco.utilisateur.IRemoteSite;
import com.mincom.gescom.be.admin.svco.utilisateur.IRemoteUsr;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.ui.core.base.GesComSvcoDeleguate;
import com.mincom.gescom.ui.core.base.ServiceLocatorException;

public class AdminSvcoDeleguate {

	BaseLogger logger = BaseLogger.getLogger(AdminSvcoDeleguate.class);
	/**
	 * Retourne le nom du Bean du Service composé en fonction du nom de l'entité (@param p$p$beanName)
	 * 
	 * @param p$beanName
	 * @return
	 */
	private static String getSvcoBeanName(String p$beanName, Class<?> p$remoteInterface){		
		
		return GesComSvcoDeleguate.getSvcoBeanName(p$beanName, p$remoteInterface);
	}
				
	
			
	/*================================== Services composés de la Partie Technique =================================*/
	
	/**
	 * Retourne le service composé pour la gestion des Utilisateurs
	 * 
	 * @return
	 * @throws ServiceLocatorException
	 */
	public static IRemoteUsr getSvcoUsr() throws ServiceLocatorException{
        return (IRemoteUsr) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoUsr", IRemoteUsr.class));
    }
	
	public static IRemoteSite getSvcoSite() throws ServiceLocatorException{
        return (IRemoteSite) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoSite", IRemoteSite.class));
    }



	public BaseLogger getLogger() {
		return logger;
	}



	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	
	
}
