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

import br.com.loja.model.Fornecedor;
import br.com.loja.repository.FornecedorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FornecedorRepositoryTest {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Test
	public void cadastrar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Pride");
		fornecedor.setEmail("pride@contato.com.br");
		fornecedor.setEndereco("Avenida Brasil");
		fornecedor.setTelefone("(12) 3655-8548");

		try {
			fornecedorRepository.save(fornecedor);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void listar() {
		List<Fornecedor> fornecedores;

		try {
			fornecedores = (List<Fornecedor>) fornecedorRepository.findAll();
			Assert.assertNotNull(fornecedores);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void alterar() {
		Fornecedor fornecedor;

		try {
			fornecedor = fornecedorRepository.findOne(1);
			fornecedor.setNome("Forn");

			fornecedorRepository.save(fornecedor);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			fornecedorRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
