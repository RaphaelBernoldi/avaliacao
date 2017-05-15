package br.com.accesstage.edi.facade.impl;

import java.text.ParseException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.accesstage.edi.conversor.AbstractConversor;
import br.com.accesstage.edi.conversor.EnumAlgoritmsConversor;
import br.com.accesstage.edi.dao.InstituitionDAO;
import br.com.accesstage.edi.dao.TransactionDAO;
import br.com.accesstage.edi.entity.InstituitionEntity;
import br.com.accesstage.edi.entity.TransactionEntity;
import br.com.accesstage.edi.facade.TransactionFacade;
import br.com.accesstage.edi.model.TransactionModel;

@Stateless
public class TransactionFacadeImpl implements TransactionFacade {
	
	@EJB
	private InstituitionDAO instituitionDAO;
	
	@EJB
	private TransactionDAO transactionDAO;

	@Override
	public String save(TransactionModel transactionModel) throws IllegalArgumentException {
		AbstractConversor conversor = EnumAlgoritmsConversor.loadByName(transactionModel.getNameInstituitionSender()).getAlgorithm();
		InstituitionEntity instituitionSent = instituitionDAO.findByName(transactionModel.getNameInstituitionSender());
		InstituitionEntity instituitionReceived = instituitionDAO.findByName(transactionModel.getNameInstituitionReceived());

		transactionModel
			.getTransactionList()
			.forEach(
					t -> 
						{
							try {
								TransactionEntity transactionEntity = conversor.toEntity(t);
								transactionEntity.setInstituitionEntityReceived(instituitionReceived);
								transactionEntity.setInstituitionEntitySent(instituitionSent);
								
								transactionDAO.save(transactionEntity);
							} catch (ParseException e) {
								throw new IllegalArgumentException(e.getMessage());
							}
						});
		return conversor.toString(transactionModel);
	}

	@Override
	public TransactionModel findByInstituitionSent(String name) {
		TransactionModel model = new TransactionModel();
		InstituitionEntity instituitionEntity = instituitionDAO.findByName(name);
		
		for (TransactionEntity transactionEntity : instituitionEntity.getTransactionsSent()) {
			model.setNameInstituitionReceived(transactionEntity.getInstituitionEntityReceived().getName());
			model.setNameInstituitionSender(transactionEntity.getInstituitionEntitySent().getName());
			model.getTransactionList().add(transactionEntity.toString());

		}
		return model;
	}

	
}
