package com.mincom.gescom.ui.core.controleur;

import com.mincom.gescom.ui.core.base.FacesUtil;




public class RequestCtrl {
	
	public RequestCtrl() {
								
	}

	public String pageBeforePreview(){
		return FacesUtil.getSessionMapValue("pageBeforePreview").toString();
	}
	

}
