package com.mincom.gescom.ui.imp.util;

import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.imp.svco.IRemoteAutSpeImp;
import com.mincom.gescom.be.imp.svco.IRemoteDecImp;
import com.mincom.gescom.ui.core.base.GesComSvcoDeleguate;
import com.mincom.gescom.ui.core.base.ServiceLocatorException;

public class ImpSvcoDelegaute {
	
	BaseLogger logger = BaseLogger.getLogger(ImpSvcoDelegaute.class);
	/**
	 * Retourne le nom du Bean du Service compos� en fonction du nom de l'entit� (@param p$p$beanName)
	 * 
	 * @param p$beanName
	 * @return
	 */
	private static String getSvcoBeanName(String p$beanName, Class<?> p$remoteInterface){		
		return GesComSvcoDeleguate.getSvcoBeanName(p$beanName, p$remoteInterface);
	}
	
	public static IRemoteAutSpeImp getSvcoAutSpeImp() throws ServiceLocatorException{
        return (IRemoteAutSpeImp) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoAutSpeImp", IRemoteAutSpeImp.class));
    }
	
	public static IRemoteDecImp getSvcoDecImp() throws ServiceLocatorException{
        return (IRemoteDecImp) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoDecImp", IRemoteDecImp.class));
    }
			
	public BaseLogger getLogger() {
		return logger;
	}



	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
