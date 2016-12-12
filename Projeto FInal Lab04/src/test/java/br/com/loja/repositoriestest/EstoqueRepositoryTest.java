package br.com.loja.repositoriestest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.loja.model.Estoque;
import br.com.loja.model.Fornecedor;
import br.com.loja.model.Produto;
import br.com.loja.repository.EstoqueRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EstoqueRepositoryTest {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@Test
	public void cadastrar() {
		Fornecedor fornecedor = new Fornecedor();

		Produto produto = new Produto();

		Estoque estoque = new Estoque();

	}

}
