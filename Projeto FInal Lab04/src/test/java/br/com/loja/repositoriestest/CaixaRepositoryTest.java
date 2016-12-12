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

import br.com.loja.model.Caixa;
import br.com.loja.repository.CaixaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaixaRepositoryTest {

	@Autowired
	private CaixaRepository caixaRepository;

	@Test
	public void cadastrar() {
		Caixa caixa = new Caixa();

		caixa.setMovimentoDeDinheiro(80000.00);
		caixa.setData(new Date());

		try {
			caixaRepository.save(caixa);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void listar() {
		List<Caixa> caixas;

		try {
			caixas = (List<Caixa>) caixaRepository.findAll();
			Assert.assertNotNull(caixas);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void alterar() {
		Caixa caixa;

		try {
			caixa = caixaRepository.findOne(1);

			caixa.setMovimentoDeDinheiro(65000.00);
			caixa.setData(new Date());

			caixaRepository.save(caixa);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			caixaRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
