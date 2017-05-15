package br.com.accesstage.edi.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.accesstage.edi.dao.TransactionDAO;
import br.com.accesstage.edi.entity.TransactionEntity;

@Stateless
public class TransactionDAOImpl implements TransactionDAO {

	
	@PersistenceContext(unitName="ediPU")
	private EntityManager em;
	
	@Override
	public void save(TransactionEntity transactionEntity) {
		em.persist(transactionEntity);
	}
}
