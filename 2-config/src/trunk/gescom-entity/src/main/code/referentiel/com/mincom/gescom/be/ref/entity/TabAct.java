package com.mincom.gescom.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.util.InfoUser;


@Entity
@Table(name="TAB_ACT")
public class TabAct extends GesComBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public TabAct(){
		
	}
	
	public TabAct(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "NUM_COD_ACT")
	private String numCodAct;

	@Column(name = "LIB_NAT_ACT_DEC")
	private String libNatActDec;
	
	@Override
	public String getEntityCode() {
		return "Act";
	}

	@Override
	public Serializable getId() {
		return getNumCodAct();
	}

	@Override
	public void setId(Serializable id) {
		setNumCodAct((String) id);
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

	public String getLibNatActDec() {
		return libNatActDec;
	}

	public void setLibNatActDec(String libNatActDec) {
		this.libNatActDec = libNatActDec;
	}

	public String getNumCodAct() {
		return numCodAct;
	}

	public void setNumCodAct(String numCodAct) {
		this.numCodAct = numCodAct;
	}

}
