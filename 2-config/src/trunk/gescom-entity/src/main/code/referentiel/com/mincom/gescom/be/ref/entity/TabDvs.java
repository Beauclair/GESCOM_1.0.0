package com.mincom.gescom.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.util.InfoUser;


@Entity
@Table(name="TAB_DVS")
public class TabDvs extends GesComBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public TabDvs(){
		
	}
	
	public TabDvs(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_DVS")
	private String codDvs;

	@Column(name = "LIB_DVS")
	private String libDvs;
	

	@Override
	public String getEntityCode() {
		return "Dvs";
	}

	@Override
	public Serializable getId() {
		return getCodDvs();
	}

	@Override
	public void setId(Serializable id) {
		setCodDvs((String) id);
	}


	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

	public void setCodDvs(String codDvs) {
		this.codDvs = codDvs;
	}

	public String getCodDvs() {
		return codDvs;
	}

	public void setLibDvs(String libDvs) {
		this.libDvs = libDvs;
	}

	public String getLibDvs() {
		return libDvs;
	}

}
