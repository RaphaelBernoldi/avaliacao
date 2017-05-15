package br.com.accesstage.edi.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.accesstage.edi.dao.InstituitionDAO;
import br.com.accesstage.edi.entity.InstituitionEntity;

@Stateless
public class InstituitionDAOImpl implements InstituitionDAO {

	@PersistenceContext(unitName="ediPU")
	private EntityManager em;
	
	@Override
	public InstituitionEntity findByName(String name) throws NoResultException {
		String jpql = "SELECT i from InstituitionEntity i"
					+ " WHERE i.name=:name";
		
		return em.createQuery(jpql, InstituitionEntity.class)
				.setParameter("name", name.toUpperCase())
				.getSingleResult();
	}

}
