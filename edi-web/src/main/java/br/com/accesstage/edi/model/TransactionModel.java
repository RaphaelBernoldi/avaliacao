package br.com.accesstage.edi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TransactionModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("nameInstituitionSender")
	private String nameInstituitionSender;
	@JsonProperty("nameInstituitionReceived")
	private String nameInstituitionReceived;
	@JsonProperty("transactionList")
	private List<String>transactionList;
	
	/**
	 * @return the nameInstituitionSender
	 */
	public String getNameInstituitionSender() {
		return nameInstituitionSender;
	}
	/**
	 * @param nameInstituitionSender the nameInstituitionSender to set
	 */
	public void setNameInstituitionSender(String nameInstituitionSender) {
		this.nameInstituitionSender = nameInstituitionSender;
	}
	/**
	 * @return the nameInstituitionReceived
	 */
	public String getNameInstituitionReceived() {
		return nameInstituitionReceived;
	}
	/**
	 * @param nameInstituitionReceived the nameInstituitionReceived to set
	 */
	public void setNameInstituitionReceived(String nameInstituitionReceived) {
		this.nameInstituitionReceived = nameInstituitionReceived;
	}
	/**
	 * @return the transactionList
	 */
	public List<String> getTransactionList() {
		if(transactionList == null){
			transactionList = new ArrayList<>();
		}
		return transactionList;
	}
	/**
	 * @param transactionList the transactionList to set
	 */
	public void setTransactionList(List<String> transactionList) {
		this.transactionList = transactionList;
	}
	
	
	
	
}
