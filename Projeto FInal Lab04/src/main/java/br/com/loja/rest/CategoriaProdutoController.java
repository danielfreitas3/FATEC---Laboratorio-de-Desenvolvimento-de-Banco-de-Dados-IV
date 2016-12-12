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

import br.com.loja.model.CategoriaProduto;
import br.com.loja.repository.CategoriaProdutoRepository;

@RestController
public class CategoriaProdutoController {

	@Autowired
	private CategoriaProdutoRepository categoriaProdutoRepository;

	/**
	 * Rota que cadastra uma nova Categoria de Produto
	 * 
	 * @param categoriaProduto
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/categoriaproduto/add", method = RequestMethod.POST)
	public ResponseEntity<CategoriaProduto> add(@RequestBody CategoriaProduto categoriaProduto,
			UriComponentsBuilder ucBuilder) {
		categoriaProdutoRepository.save(categoriaProduto);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/categoriaproduto/{id}").buildAndExpand(categoriaProduto.getId()).toUri());
		return new ResponseEntity<CategoriaProduto>(header, HttpStatus.OK);
	}
}
