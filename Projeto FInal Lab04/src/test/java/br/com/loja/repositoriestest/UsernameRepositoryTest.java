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

import br.com.loja.model.Username;
import br.com.loja.repository.UsernameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsernameRepositoryTest {

	@Autowired
	private UsernameRepository usernameRepository;

	@Test
	public void cadastrar() {
		Username username = new Username();

		username.setUsuario("usuario01");
		username.setSenha("senha01");

		try {
			usernameRepository.save(username);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void listar() {
		List<Username> usuarios;

		try {
			usuarios = (List<Username>) usernameRepository.findAll();
			Assert.assertNotNull(usuarios);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void alterar() {
		Username username;
		try {
			username = usernameRepository.findOne(1);

			username.setUsuario("usuarioalterado");
			username.setSenha("senhaalterada");

			usernameRepository.save(username);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			usernameRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
