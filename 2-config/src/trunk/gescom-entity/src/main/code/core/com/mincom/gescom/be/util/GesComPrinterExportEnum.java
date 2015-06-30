package com.mincom.gescom.be.util;

public enum GesComPrinterExportEnum {
	
	PDF,
	EXCEL,
	EXCELX,
	DOC,
	DOCX,
	HTML,
	CSV;
	
	public static GesComPrinterExportEnum getByName(String value){
		for(GesComPrinterExportEnum prt : GesComPrinterExportEnum.class.getEnumConstants()){
			if(prt.name().equalsIgnoreCase(value))
				return prt;
		}
		return null;
	}

}
