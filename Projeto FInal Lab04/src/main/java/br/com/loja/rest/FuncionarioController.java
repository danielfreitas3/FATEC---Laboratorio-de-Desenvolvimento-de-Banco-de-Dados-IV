package br.com.loja.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.loja.model.Funcionario;
import br.com.loja.repository.FuncionarioRepository;

@RestController
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	/**
	 * Rota que adiciona um novo Funcionario
	 * 
	 * @param funcionario
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/funcionario/add", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Funcionario funcionario, UriComponentsBuilder ucBuilder) {

		funcionario.setDataCadastro(new Date());
		funcionario.setDataNascimento(new Date());

		funcionarioRepository.save(funcionario);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getMatricula()).toUri());
		return new ResponseEntity<Void>(header, HttpStatus.OK);
	}

	/**
	 * Rota que atualiza um funcionario a partir de seu ID
	 * 
	 * @param id
	 * @param funcionario
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/funcionario/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Funcionario> update(@PathVariable Integer id, @RequestBody Funcionario funcionario,
			UriComponentsBuilder ucBuilder) {
		Funcionario currentFuncionario = funcionarioRepository.findOne(id);

		if (currentFuncionario == null) {
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}

		currentFuncionario.setEmail(funcionario.getEmail());
		currentFuncionario.setEndereco(funcionario.getEndereco());
		currentFuncionario.setNome(funcionario.getNome());
		currentFuncionario.setRg(funcionario.getRg());
		currentFuncionario.setSalario(funcionario.getSalario());
		currentFuncionario.setSobrenome(funcionario.getSobrenome());
		currentFuncionario.setUserName(funcionario.getUserName());

		funcionarioRepository.save(currentFuncionario);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(
				ucBuilder.path("/funcionario/update/{id}").buildAndExpand(currentFuncionario.getMatricula()).toUri());
		return new ResponseEntity<Funcionario>(header, HttpStatus.OK);
	}
}
