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
import br.com.loja.model.Produto;
import br.com.loja.repository.CategoriaProdutoRepository;
import br.com.loja.repository.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;

	@Test
	public void cadastrar() {
		Produto produto = new Produto();
		produto.setNome("Camiseta masculina");
		produto.setPreco(19.90);
		produto.setTipo("Camisa");

		CategoriaProduto categoriaProduto = new CategoriaProduto();
		categoriaProduto.setNome("Camisa M");
		categoriaProduto.setDescricao("Camiseta manga longa");

		produto.setCategoriaProduto(categoriaProduto);

		try {
			categoriaProdutoRepository.save(categoriaProduto);
			produtoRepository.save(produto);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void listar() {
		List<Produto> produtos;

		try {
			produtos = (List<Produto>) produtoRepository.findAll();
			Assert.assertNotNull(produtos);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void atualizar() {
		Produto produto;

		try {
			produto = produtoRepository.findOne(1);
			produto.setNome("Blusa");
			produto.setPreco(150.00);

			produtoRepository.save(produto);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			produtoRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void buscarPorNome() {
		try {
			Produto produto = produtoRepository.searchByProdName("Meia");
			Assert.assertNotNull(produto);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
