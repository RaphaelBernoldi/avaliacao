package br.com.accesstage.edi.facade;

import javax.ejb.Local;

import br.com.accesstage.edi.model.TransactionModel;

@Local
public interface TransactionFacade {

	String save(TransactionModel transactionModel) throws Exception;
	
	TransactionModel findByInstituitionSent(String name)throws Exception;
}
