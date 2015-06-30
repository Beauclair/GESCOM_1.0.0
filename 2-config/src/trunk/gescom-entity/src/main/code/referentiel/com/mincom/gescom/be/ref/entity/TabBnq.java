package com.mincom.gescom.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.util.InfoUser;


@Entity
@Table(name="TAB_BNQ")
public class TabBnq extends GesComBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public TabBnq(){
		
	}
	
	public TabBnq(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_BNQ")
	private String codBnq;

	@Column(name = "LIB_BNQ")
	private String libBnq;
	
	@Override
	public String getEntityCode() {
		return "Bnq";
	}

	@Override
	public Serializable getId() {
		return getCodBnq();
	}

	@Override
	public void setId(Serializable id) {
		setCodBnq((String) id);
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

	public void setCodBnq(String codBnq) {
		this.codBnq = codBnq;
	}

	public String getCodBnq() {
		return codBnq;
	}

	public void setLibBnq(String libBnq) {
		this.libBnq = libBnq;
	}

	public String getLibBnq() {
		return libBnq;
	}

}
