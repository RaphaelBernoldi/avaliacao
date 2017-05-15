package br.com.accesstage.edi.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String typeTransaction;
	
	@Column
	private Long agency;
	
	@Column
	private Long account;
	
	@Column
	private Long accountDigit;
	
	@Column
	private String nameFavored;
	
	@Column
	private String cpf;
	
	@Column
	private Long valueTransaction;
	
	@Column
	private Long decimalValueTransaction;
	
	@Column
	private Date dateTransaction;
	
	@ManyToOne
	private InstituitionEntity instituitionEntitySent;
	
	@ManyToOne
	private InstituitionEntity instituitionEntityReceived;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the typeTransaction
	 */
	public String getTypeTransaction() {
		return typeTransaction;
	}
	/**
	 * @param typeTransaction the typeTransaction to set
	 */
	public void setTypeTransaction(String typeTransaction) {
		this.typeTransaction = typeTransaction;
	}
	/**
	 * @return the agency
	 */
	public Long getAgency() {
		return agency;
	}
	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Long agency) {
		this.agency = agency;
	}
	/**
	 * @return the account
	 */
	public Long getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Long account) {
		this.account = account;
	}
	/**
	 * @return the accountDigit
	 */
	public Long getAccountDigit() {
		return accountDigit;
	}
	/**
	 * @param accountDigit the accountDigit to set
	 */
	public void setAccountDigit(Long accountDigit) {
		this.accountDigit = accountDigit;
	}
	/**
	 * @return the nameFavored
	 */
	public String getNameFavored() {
		return nameFavored;
	}
	/**
	 * @param nameFavored the nameFavored to set
	 */
	public void setNameFavored(String nameFavored) {
		this.nameFavored = nameFavored;
	}
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the valueTransaction
	 */
	public Long getValueTransaction() {
		return valueTransaction;
	}
	/**
	 * @param valueTransaction the valueTransaction to set
	 */
	public void setValueTransaction(Long valueTransaction) {
		this.valueTransaction = valueTransaction;
	}
	/**
	 * @return the decimalValueTransaction
	 */
	public Long getDecimalValueTransaction() {
		return decimalValueTransaction;
	}
	/**
	 * @param decimalValueTransaction the decimalValueTransaction to set
	 */
	public void setDecimalValueTransaction(Long decimalValueTransaction) {
		this.decimalValueTransaction = decimalValueTransaction;
	}
	/**
	 * @return the dateTransaction
	 */
	public Date getDateTransaction() {
		return dateTransaction;
	}
	/**
	 * @param dateTransaction the dateTransaction to set
	 */
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	/**
	 * @return the instituitionEntitySent
	 */
	public InstituitionEntity getInstituitionEntitySent() {
		return instituitionEntitySent;
	}
	/**
	 * @param instituitionEntitySent the instituitionEntitySent to set
	 */
	public void setInstituitionEntitySent(InstituitionEntity instituitionEntitySent) {
		this.instituitionEntitySent = instituitionEntitySent;
	}
	/**
	 * @return the instituitionEntityReceived
	 */
	public InstituitionEntity getInstituitionEntityReceived() {
		return instituitionEntityReceived;
	}
	/**
	 * @param instituitionEntityReceived the instituitionEntityReceived to set
	 */
	public void setInstituitionEntityReceived(InstituitionEntity instituitionEntityReceived) {
		this.instituitionEntityReceived = instituitionEntityReceived;
	}
	
	@Override
	public String toString() {
		String thisString = "";
		thisString += String.format("%-11.11s", cpf);
		thisString += String.format("%-30.30s", nameFavored);
		thisString += String.format("%04d",agency);
		thisString += String.format("%05d", account);
		thisString += String.format("%01d", accountDigit);
		thisString += String.format("%05d", valueTransaction);
		thisString += String.format("%02d", decimalValueTransaction);
		thisString += String.format("%-3.3s", typeTransaction);
		SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
		thisString += String.format("%-6.6s",format.format(dateTransaction));

		return thisString;
	}
	
}
