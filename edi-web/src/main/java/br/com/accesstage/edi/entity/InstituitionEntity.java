package br.com.accesstage.edi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INSTITUITION")
public class InstituitionEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "instituitionEntitySent")
	private List<TransactionEntity>transactionsSent;
	
	@OneToMany(mappedBy = "instituitionEntityReceived")
	private List<TransactionEntity>transactionsReceived;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the transactionsSent
	 */
	public List<TransactionEntity> getTransactionsSent() {
		return transactionsSent;
	}

	/**
	 * @param transactionsSent the transactionsSent to set
	 */
	public void setTransactionsSent(List<TransactionEntity> transactionsSent) {
		this.transactionsSent = transactionsSent;
	}

	/**
	 * @return the transactionsReceived
	 */
	public List<TransactionEntity> getTransactionsReceived() {
		return transactionsReceived;
	}

	/**
	 * @param transactionsReceived the transactionsReceived to set
	 */
	public void setTransactionsReceived(List<TransactionEntity> transactionsReceived) {
		this.transactionsReceived = transactionsReceived;
	}
	
	
	
}
