package br.com.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que representa um gerenciador de tabelas
 * 
 * @author Daniel
 *
 */
public class HibernateUtil {

	public EntityManager criarGerenciadorDeTabelas() {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja-unit");
			return entityManagerFactory.createEntityManager();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
}
