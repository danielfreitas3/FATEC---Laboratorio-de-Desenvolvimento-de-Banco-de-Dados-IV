package br.com.loja.repositoriestest;

import java.util.Date;
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

import br.com.loja.model.Cliente;
import br.com.loja.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteRepositoryTest {

	@Autowired
	ClienteRepository clienteRepository;

	@Test
	public void cadastrar() {
		Cliente cliente = new Cliente();

		cliente.setNome("Rogério");
		cliente.setSobrenome("Vinicius");
		cliente.setEmail("rogerio@contato.com.br");
		cliente.setRg("69.657.365-1");
		cliente.setEndereco("Rua 7 de setembro, 231");
		cliente.setDataCadastro(new Date());
		cliente.setDataNascimento(new Date());

		try {
			clienteRepository.save(cliente);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		List<Cliente> clientes;

		try {
			clientes = (List<Cliente>) clienteRepository.findAll();
			Assert.assertNotNull(clientes);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void alterar() {
		Cliente cliente;

		try {
			cliente = clienteRepository.findOne(1);
			cliente.setNome("Beatriz");
			cliente.setSobrenome("Flores");

			clienteRepository.save(cliente);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			clienteRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
