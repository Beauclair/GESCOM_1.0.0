package com.mincom.gescom.be.ref.sisv;

import javax.ejb.Local;

import com.mincom.gescom.be.core.sisv.base.IBaseSisv;
import com.mincom.gescom.be.ref.entity.TabImp;

@Local
public interface ISisvImp extends IBaseSisv<TabImp, String>{

}
