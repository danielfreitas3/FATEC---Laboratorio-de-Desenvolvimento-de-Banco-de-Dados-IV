package br.com.loja.mappingtest;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.loja.util.HibernateUtil;

public class EntityMappingTest {

	@Test
	public void testaMapeamento() {
		EntityManager entityManager = new HibernateUtil().criarGerenciadorDeTabelas();
		entityManager.close();
	}

}
