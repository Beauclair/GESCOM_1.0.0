package com.mincom.gescom.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mincom.gescom.be.core.base.GesComBaseEntity;
import com.mincom.gescom.be.util.InfoUser;


@Entity
@Table(name="TAB_FOUR")
public class TabFour extends GesComBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public TabFour(){
		
	}
	
	public TabFour(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_FOUR")
	private String codFour;

	@Column(name = "LIB_FOUR")
	private String libFour;
	
	@Column(name = "LIB_ADR")
	private String libAdr;
	
	@Column(name = "LIB_BOI_POS")
	private String libBoiPos;
	
	@Column(name = "LIB_EMAIL")
	private String libEmail;
	
	@Column(name = "LIB_Fax")
	private String libFax;
	
	@Column(name = "LIB_TEL")
	private String libTel;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAYS")
	private TabPays tabPays;

	@Override
	public String getEntityCode() {
		return "Four";
	}

	@Override
	public Serializable getId() {
		return getCodFour();
	}

	@Override
	public void setId(Serializable id) {
		setCodFour((String) id);
	}


	@Override
	public void validateData() {
		
		try {
			if (this.getTabPays() != null
					&& (this.getTabPays().getCodPays() == null || this
							.getTabPays().getCodPays().trim().isEmpty()))
				this.setTabPays(null);
		} catch (Exception e) {
		}
	}

	@Override
	public void initData() {
		
		this.tabPays = (this.tabPays == null) ? new TabPays()
		: this.tabPays;
	}

	public void setCodFour(String codFour) {
		this.codFour = codFour;
	}

	public String getCodFour() {
		return codFour;
	}

	public void setLibFour(String libFour) {
		this.libFour = libFour;
	}

	public String getLibFour() {
		return libFour;
	}

	public void setTabPays(TabPays tabPays) {
		this.tabPays = tabPays;
	}

	public TabPays getTabPays() {
		return tabPays;
	}

	public String getLibAdr() {
		return libAdr;
	}

	public void setLibAdr(String libAdr) {
		this.libAdr = libAdr;
	}

	public String getLibBoiPos() {
		return libBoiPos;
	}

	public void setLibBoiPos(String libBoiPos) {
		this.libBoiPos = libBoiPos;
	}

	public String getLibEmail() {
		return libEmail;
	}

	public void setLibEmail(String libEmail) {
		this.libEmail = libEmail;
	}

	public String getLibFax() {
		return libFax;
	}

	public void setLibFax(String libFax) {
		this.libFax = libFax;
	}

	public String getLibTel() {
		return libTel;
	}

	public void setLibTel(String libTel) {
		this.libTel = libTel;
	}

}
