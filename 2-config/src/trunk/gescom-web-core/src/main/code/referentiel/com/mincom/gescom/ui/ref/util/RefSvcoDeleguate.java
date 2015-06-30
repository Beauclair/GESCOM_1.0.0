package com.mincom.gescom.ui.ref.util;

import com.mincom.gescom.be.admin.svco.utilisateur.IRemoteUsr;
import com.mincom.gescom.be.core.base.BaseLogger;
import com.mincom.gescom.be.ref.svco.IRemoteAct;
import com.mincom.gescom.be.ref.svco.IRemoteBnq;
import com.mincom.gescom.be.ref.svco.IRemoteDvs;
import com.mincom.gescom.be.ref.svco.IRemoteFour;
import com.mincom.gescom.be.ref.svco.IRemoteImp;
import com.mincom.gescom.be.ref.svco.IRemotePays;
import com.mincom.gescom.be.ref.svco.IRemotePro;
import com.mincom.gescom.be.ref.svco.IRemoteTrans;
import com.mincom.gescom.ui.core.base.GesComSvcoDeleguate;
import com.mincom.gescom.ui.core.base.ServiceLocatorException;

public class RefSvcoDeleguate {
	
	BaseLogger logger = BaseLogger.getLogger(RefSvcoDeleguate.class);
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
	public static IRemoteBnq getSvcoBnq() throws ServiceLocatorException{
        return (IRemoteBnq) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoBnq", IRemoteBnq.class));
    }
	
	public static IRemoteDvs getSvcoDvs() throws ServiceLocatorException{
        return (IRemoteDvs) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoDvs", IRemoteDvs.class));
    }
	
	public static IRemoteAct getSvcoAct() throws ServiceLocatorException{
        return (IRemoteAct) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoAct", IRemoteAct.class));
    }
	
	public static IRemotePays getSvcoPays() throws ServiceLocatorException{
        return (IRemotePays) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoPays", IRemotePays.class));
    }
	
	public static IRemotePro getSvcoPro() throws ServiceLocatorException{
        return (IRemotePro) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoPro", IRemotePro.class));
    }
	
	public static IRemoteFour getSvcoFour() throws ServiceLocatorException{
        return (IRemoteFour) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoFour", IRemoteFour.class));
    }
	
	public static IRemoteImp getSvcoImp() throws ServiceLocatorException{
        return (IRemoteImp) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoImp", IRemoteImp.class));
    }
	
	public static IRemoteTrans getSvcoTrans() throws ServiceLocatorException{
        return (IRemoteTrans) GesComSvcoDeleguate.getCachingServiceLocator().lookup(getSvcoBeanName("SvcoTrans", IRemoteTrans.class));
    }

	public BaseLogger getLogger() {
		return logger;
	}



	public void setLogger(BaseLogger logger) {
		this.logger = logger;
	}	

}
