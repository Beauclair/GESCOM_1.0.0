package com.mincom.gescom.be.admin.sisv.utilisateur;

import javax.ejb.Local;

import com.mincom.gescom.be.admin.entity.utilisateur.TabSite;
import com.mincom.gescom.be.core.sisv.base.IBaseSisv;

@Local
public interface ISisvSite extends IBaseSisv<TabSite, String>{

}