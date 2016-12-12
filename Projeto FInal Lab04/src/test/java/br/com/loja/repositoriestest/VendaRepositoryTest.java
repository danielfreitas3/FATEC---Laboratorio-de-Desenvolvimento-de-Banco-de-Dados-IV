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

import br.com.loja.model.CategoriaProduto;
import br.com.loja.model.Cliente;
import br.com.loja.model.FormaDePagamento;
import br.com.loja.model.Funcionario;
import br.com.loja.model.Produto;
import br.com.loja.model.Username;
import br.com.loja.model.Venda;
import br.com.loja.repository.CategoriaProdutoRepository;
import br.com.loja.repository.ClienteRepository;
import br.com.loja.repository.FuncionarioRepository;
import br.com.loja.repository.ProdutoRepository;
import br.com.loja.repository.UsernameRepository;
import br.com.loja.repository.VendaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/beans.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendaRepositoryTest {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;

	@Autowired
	private UsernameRepository usernameRepository;

	@Test
	@Ignore
	public void cadastrar() {
		Cliente cliente = new Cliente();
		cliente.setNome("Marcos");
		cliente.setSobrenome("Antonio");
		cliente.setEmail("marcos@contato.com.br");
		cliente.setRg("12.127.235-1");
		cliente.setEndereco("Rua 1 de setembro, 11");
		cliente.setDataCadastro(new Date());
		cliente.setDataNascimento(new Date());

		Username username = new Username();
		username.setUsuario("walterjose");
		username.setSenha("12341234");

		Funcionario funcionario = new Funcionario();
		funcionario.setDataCadastro(new Date());
		funcionario.setDataNascimento(new Date());
		funcionario.setEmail("walter@contato.com.br");
		funcionario.setEndereco("Rua cantidio miragaia, 13");
		funcionario.setNome("Walter");
		funcionario.setRg("72.231.123-3");
		funcionario.setSalario(1500.00);
		funcionario.setSobrenome("José");
		funcionario.setUserName(username);

		Produto produto = new Produto();
		produto.setNome("Meia");
		produto.setPreco(9.90);
		produto.setTipo("Meia 42");

		CategoriaProduto categoriaProduto = new CategoriaProduto();
		categoriaProduto.setNome("Meia Masculina");
		categoriaProduto.setDescricao("Meia de algodao");

		produto.setCategoriaProduto(categoriaProduto);

		Venda venda = new Venda();
		venda.setFormaDePagamento(FormaDePagamento.CHEQUE);
		venda.setVenda(new Date());
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setProduto(produto);

		try {
			categoriaProdutoRepository.save(categoriaProduto);
			usernameRepository.save(username);
			produtoRepository.save(produto);
			clienteRepository.save(cliente);
			funcionarioRepository.save(funcionario);
			vendaRepository.save(venda);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	@Ignore
	public void listar() {
		List<Venda> vendas;

		try {
			vendas = (List<Venda>) vendaRepository.findAll();
			Assert.assertNotNull(vendas);

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void alterar() {
		Venda venda;

		try {
			venda = vendaRepository.findOne(1);
			venda.setFormaDePagamento(FormaDePagamento.CHEQUE);
			vendaRepository.save(venda);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void deletar() {
		try {
			vendaRepository.delete(1);
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
