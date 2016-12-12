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

import br.com.loja.model.Cliente;
import br.com.loja.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Rota que cadastra um novo cliente
	 * 
	 * @param cliente
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/cliente/add", method = RequestMethod.POST)
	public ResponseEntity<Cliente> add(@RequestBody Cliente cliente, UriComponentsBuilder ucBuilder) {

		cliente.setDataCadastro(new Date());
		cliente.setDataNascimento(new Date());
		clienteRepository.save(cliente);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
		return new ResponseEntity<Cliente>(header, HttpStatus.OK);
	}

	/**
	 * Atualiza um cliente passando como parametro o seu ID e o novo cliente
	 * alterado
	 * 
	 * @param id
	 * @param cliente
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/cliente/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> updateById(@PathVariable Integer id, @RequestBody Cliente cliente,
			UriComponentsBuilder ucBuilder) {

		Cliente currentCliente = clienteRepository.findOne(id);

		if (currentCliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}

		currentCliente.setNome(cliente.getNome());
		currentCliente.setSobrenome(cliente.getSobrenome());
		currentCliente.setEmail(cliente.getEmail());
		currentCliente.setEndereco(cliente.getEndereco());
		currentCliente.setRg(cliente.getRg());

		clienteRepository.save(currentCliente);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/cliente/update/{id}").buildAndExpand(cliente.getId()).toUri());
		return new ResponseEntity<Cliente>(header, HttpStatus.OK);
	}
}
