package com.mincom.gescom.be.admin.dao.utilisateur;

import javax.ejb.Local;

import com.mincom.gescom.be.admin.entity.utilisateur.TabSite;
import com.mincom.gescom.be.core.dao.base.IBaseDao;

@Local
public interface IDaoSite extends IBaseDao<TabSite, String>{

}
