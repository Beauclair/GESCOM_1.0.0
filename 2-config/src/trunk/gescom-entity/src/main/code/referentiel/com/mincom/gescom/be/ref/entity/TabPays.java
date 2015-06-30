package com.mincom.gescom.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.util.InfoUser;


@Entity
@Table(name="TAB_PAYS")
public class TabPays extends GesComBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public TabPays(){
		
	}
	
	public TabPays(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_PAYS")
	private String codPays;

	@Column(name = "LIB_PAYS")
	private String libPays;
	
	@Override
	public String getEntityCode() {
		return "Pays";
	}

	public String getCodPays() {
		return codPays;
	}

	public void setCodPays(String codPays) {
		this.codPays = codPays;
	}


	@Override
	public Serializable getId() {
		return getCodPays();
	}

	@Override
	public void setId(Serializable id) {
		setCodPays((String) id);
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

	public void setLibPays(String libPays) {
		this.libPays = libPays;
	}

	public String getLibPays() {
		return libPays;
	}

}
