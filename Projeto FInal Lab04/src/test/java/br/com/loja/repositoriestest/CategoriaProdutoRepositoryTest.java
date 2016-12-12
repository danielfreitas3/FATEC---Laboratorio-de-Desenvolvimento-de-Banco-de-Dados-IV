package br.com.loja.repositoriestest;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.loja.model.CategoriaProduto;
import br.com.loja.repository.CategoriaProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoriaProdutoRepositoryTest {

	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;

	@Test
	public void cadastrar() {
		CategoriaProduto categoriaProduto = new CategoriaProduto();

		categoriaProduto.setNome("Blusa de Frio");
		categoriaProduto.setDescricao("Tamanho G");

		try {
			categoriaProdutoRepository.save(categoriaProduto);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void listar() {
		List<CategoriaProduto> categoriaProdutos;

		try {
			categoriaProdutos = (List<CategoriaProduto>) categoriaProdutoRepository.findAll();
			Assert.assertNotNull(categoriaProdutos);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void alterar() {
		CategoriaProduto categoriaProduto;

		try {
			categoriaProduto = categoriaProdutoRepository.findOne(1);
			categoriaProduto.setNome("Camisa Comprida");
			categoriaProduto.setDescricao("Tamanho GG");

			categoriaProdutoRepository.save(categoriaProduto);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			categoriaProdutoRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
