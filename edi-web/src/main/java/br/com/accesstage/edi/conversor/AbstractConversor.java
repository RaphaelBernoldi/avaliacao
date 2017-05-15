package br.com.accesstage.edi.conversor;

import java.text.ParseException;
import java.util.Date;

import br.com.accesstage.edi.entity.TransactionEntity;
import br.com.accesstage.edi.model.TransactionModel;

public abstract class AbstractConversor {

	 public abstract String getValueFieldString(String transaction, EnumField field);
	 public abstract Long getValueFieldLong(String transaction, EnumField field);
	 public abstract Date getValueFieldDate(String transaction, EnumField field) throws ParseException;
	 
	 public TransactionEntity toEntity(String transaction) throws ParseException{
		 TransactionEntity transactionEntity = new TransactionEntity();
		 
		 transactionEntity.setAccount( getValueFieldLong(transaction, EnumField.ACCOUNT));
		 transactionEntity.setAccountDigit( getValueFieldLong(transaction, EnumField.DIGIT_ACCOUNT));
		 transactionEntity.setAgency( getValueFieldLong(transaction, EnumField.AGENCY));
		 transactionEntity.setCpf(getValueFieldString(transaction, EnumField.CPF));
		 transactionEntity.setDateTransaction(getValueFieldDate(transaction, EnumField.DATE_TRANSACTION));
		 transactionEntity.setDecimalValueTransaction( getValueFieldLong(transaction, EnumField.VALUE_TRANSACTION_DECIMAL));
		 transactionEntity.setNameFavored(getValueFieldString(transaction, EnumField.NAME_FAVORED));
		 transactionEntity.setTypeTransaction(getValueFieldString(transaction, EnumField.TYPE_TRANSACTION));
		 transactionEntity.setValueTransaction( getValueFieldLong(transaction, EnumField.VALUE_TRANSACTION));
		 
		 return transactionEntity;
	 }
	 
	 public String toString(TransactionModel transactionModel)throws IllegalArgumentException{
		 String transactionString = "";
		 try{
			 
			 for(String transaction:transactionModel.getTransactionList()){
				 transactionString += toEntity(transaction).toString();
					
			 }
			 
		 }catch (ParseException e) {
			 throw new IllegalArgumentException(e.getMessage());
		 }
		 
		 return transactionString;
	 }
	 
}
