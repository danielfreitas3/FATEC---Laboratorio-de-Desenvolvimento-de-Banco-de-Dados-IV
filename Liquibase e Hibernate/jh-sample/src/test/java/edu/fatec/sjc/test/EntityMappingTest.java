package edu.fatec.sjc.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.fatec.sjc.entity.Category;
import edu.fatec.sjc.entity.Cliente;
import edu.fatec.sjc.entity.Produto;
import edu.fatec.sjc.entity.Stock;

public class EntityMappingTest {
	private EntityManager em;

	@Before
	public void beforeEach() {
		em = Persistence.createEntityManagerFactory("stock-unit").createEntityManager();
	}

	@Test
	public void testEntityManagerGetInstance() {
		Assert.assertNotNull(em);
	}

	@Test
	public void testInsertStock() {
		Stock s1 = new Stock("ACD-345", "Estoque 1");
		Stock s2 = new Stock("ACD-346", "Estoque 2");
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(s1);
			em.persist(s2);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			Assert.fail();
		}
	}

	@Test
	public void testInsertCategory() {
		Category cat1 = new Category("Categoria 1", "Categoria de estoque para armazenamento de alimentos.");
		Category cat2 = new Category("Categoria 2", "Categoria de estoque para armazenamento de móveis.");
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(cat1);
			em.persist(cat2);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			Assert.fail();
		}
	}

	@Test
	public void testInsertCategoryWithStock() {
		Stock s = new Stock("234-SDFC", "Estoque 3");
		Category cat = em.createQuery("SELECT c FROM Category c", Category.class).getResultList().get(0);
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(s);
			cat.getStocks().add(s);
			em.merge(cat);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			Assert.fail();
		}
	}

	@Test
	public void testInsertStockWithCategory() {
		Stock s = em.createQuery("SELECT s FROM Stock s", Stock.class).getResultList().get(1);
		Category cat = new Category("Categoria 3", "Nova categoria para tabela intermediaria.");
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(cat);
			s.getCategories().add(cat);
			em.merge(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			Assert.fail();
		}
	}

	@Test
	public void testInsertCliente() {
		Cliente cliente = new Cliente();
		cliente.setCliente_nome("Daniel");
		cliente.setCliente_sobrenome("Correa");
		cliente.setCliente_telefone("(12) 3922-5259");
		cliente.setCliente_celular("(12) 98264-9907");
		Date dataNascimento = new Date();
		dataNascimento.getTime();
		cliente.setCliente_dataNascimento(dataNascimento);

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(cliente);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			Assert.fail();
		}

	}

	@Test
	public void testInsertProduto() {
		Produto produto = new Produto();
		produto.setProduto_nome("Computador");
		produto.setProduto_marca("HP");
		produto.setProduto_preco(2000.00F);
		produto.setProduto_quantidade(6);
		produto.setProduto_categoria("Informática");

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(produto);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			Assert.fail();
		}
	}

	@After
	public void afterEach() {
		em.close();
	}
}
