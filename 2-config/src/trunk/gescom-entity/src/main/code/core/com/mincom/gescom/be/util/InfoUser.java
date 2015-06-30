package com.mincom.gescom.be.util;

import java.io.Serializable;

import com.mincom.gescom.be.admin.entity.utilisateur.TabUsr;

public class InfoUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private TabUsr user;

	public void setUser(TabUsr user) {
		this.user = user;
	}

	public TabUsr getUser() {
		return user;
	}

}
