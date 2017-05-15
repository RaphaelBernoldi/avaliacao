package br.com.accesstage.edi.dao;

import javax.persistence.NoResultException;

import br.com.accesstage.edi.entity.InstituitionEntity;

public interface InstituitionDAO {

	 InstituitionEntity findByName(String name) throws NoResultException;
}
