package com.mincom.gescom.ui.core.base;


import java.io.Serializable;
import java.lang.reflect.Field;

import com.mincom.gescom.be.core.base.GesComBaseEntity;

public class ExportFormatElt extends GesComBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String attributeName;
	private String attributeType;
	private String columnName;
	
	private int columnIndex;
	private Boolean selected;
	private Boolean isObject;
	
	private Field field;
	
	
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	public int getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
	
	public Boolean getIsObject() {
		return isObject;
	}
	public void setIsObject(Boolean isObject) {
		this.isObject = isObject;
	}
	
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	@Override
	public String getEntityCode() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setId(Serializable arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void validateData() {
		// TODO Auto-generated method stub
		
	}
	
	public String getElementAtIndex(int index){
		switch(index){
			case 0: return columnName;
			case 1: return attributeType;
			case 2: return attributeName;
			default: return "-1";
		}
	}
	
	
	
}
