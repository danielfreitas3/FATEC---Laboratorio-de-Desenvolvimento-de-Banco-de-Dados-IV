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

import br.com.loja.model.Funcionario;
import br.com.loja.model.Username;
import br.com.loja.repository.FuncionarioRepository;
import br.com.loja.repository.UsernameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private UsernameRepository usernameRepository;

	@Test
	public void cadastrar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setDataCadastro(new Date());
		funcionario.setDataNascimento(new Date());
		funcionario.setEmail("funcionario@contato.com.br");
		funcionario.setEndereco("Rua 1 janeiro, 123");
		funcionario.setNome("Roberval");
		funcionario.setRg("65.658.698-3");
		funcionario.setSalario(2500.00);
		funcionario.setSobrenome("Aparecido");

		Username username = new Username();
		username.setId(null);
		username.setUsuario("robervalaparecido");
		username.setSenha("123456789");

		funcionario.setUserName(username);

		try {
			usernameRepository.save(username);
			funcionarioRepository.save(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void listar() {
		List<Funcionario> funcionarios;

		try {
			funcionarios = (List<Funcionario>) funcionarioRepository.findAll();
			Assert.assertNotNull(funcionarios);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void atualizar() {
		Funcionario funcionario;

		try {
			funcionario = funcionarioRepository.findOne(1);
			funcionario.setNome("Hiago");
			funcionarioRepository.save(funcionario);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			funcionarioRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
