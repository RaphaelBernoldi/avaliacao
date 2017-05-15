package br.com.accesstage.edi.conversor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorInstituitionX extends AbstractConversor{

	@Override
	public String getValueFieldString(String transaction, EnumField field) {
		String substring = transaction.substring(field.getAddressInit(), field.getAddressEnd());
		return substring; 
	}

	@Override
	public Long getValueFieldLong(String transaction, EnumField field) {
		Long long1 = Long.valueOf(getValueFieldString(transaction, field));
		return long1;
	}

	@Override
	public Date getValueFieldDate(String transaction, EnumField field) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		Date parse = format.parse( getValueFieldString(transaction, field));
		return parse;
	}

	

	
}
