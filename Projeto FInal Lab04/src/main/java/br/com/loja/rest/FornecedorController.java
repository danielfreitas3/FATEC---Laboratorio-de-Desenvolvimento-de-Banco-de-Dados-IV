package br.com.loja.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.loja.model.Fornecedor;
import br.com.loja.repository.FornecedorRepository;

@RestController
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	/**
	 * Rota que cadastra um novo fornecedor
	 * 
	 * @param fornecedor
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/fornecedor/add", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Fornecedor fornecedor, UriComponentsBuilder ucBuilder) {

		fornecedorRepository.save(fornecedor);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/fornecedor/{id}").buildAndExpand(fornecedor.getId()).toUri());
		return new ResponseEntity<Void>(header, HttpStatus.OK);
	}
}
