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

import br.com.loja.model.Estoque;
import br.com.loja.repository.EstoqueRepository;

@RestController
public class EstoqueController {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@RequestMapping(value = "/estoque/add", method = RequestMethod.POST)
	public ResponseEntity<Estoque> add(@RequestBody Estoque estoque, UriComponentsBuilder ucBuilder) {

		estoqueRepository.save(estoque);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/estoque/{id}").buildAndExpand(estoque.getId()).toUri());
		return new ResponseEntity<Estoque>(header, HttpStatus.OK);

	}
}
