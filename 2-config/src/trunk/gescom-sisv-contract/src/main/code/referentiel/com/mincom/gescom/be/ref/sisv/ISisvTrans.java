package com.mincom.gescom.be.ref.sisv;

import javax.ejb.Local;

import com.mincom.gescom.be.core.sisv.base.IBaseSisv;
import com.mincom.gescom.be.ref.entity.TabTrans;

@Local
public interface ISisvTrans extends IBaseSisv<TabTrans, String>{

}
