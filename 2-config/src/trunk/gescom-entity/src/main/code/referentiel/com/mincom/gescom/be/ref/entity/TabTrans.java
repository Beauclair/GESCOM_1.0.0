package com.mincom.gescom.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.util.InfoUser;


@Entity
@Table(name="TAB_TRANS")
public class TabTrans extends GesComBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public TabTrans(){
		
	}
	
	public TabTrans(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_TRANS")
	private String codTrans;

	@Column(name = "LIB_TRANS")
	private String libTrans;
	
	@Column(name = "LIB_ADR")
	private String libAdr;
	

	@Override
	public String getEntityCode() {
		return "Trans";
	}

	@Override
	public Serializable getId() {
		return getCodTrans();
	}

	@Override
	public void setId(Serializable id) {
		setCodTrans((String) id);
	}


	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

	public void setCodTrans(String codTrans) {
		this.codTrans = codTrans;
	}

	public String getCodTrans() {
		return codTrans;
	}

	public void setLibTrans(String libTrans) {
		this.libTrans = libTrans;
	}

	public String getLibTrans() {
		return libTrans;
	}

	public void setLibAdr(String libAdr) {
		this.libAdr = libAdr;
	}

	public String getLibAdr() {
		return libAdr;
	}

}
