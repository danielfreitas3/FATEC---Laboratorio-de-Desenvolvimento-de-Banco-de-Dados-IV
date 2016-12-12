package br.com.loja.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.loja.model.Produto;
import br.com.loja.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	/**
	 * Rota que cadastra um produto
	 * 
	 * @param produto
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/produto/add", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Produto produto, UriComponentsBuilder ucBuilder) {

		produtoRepository.save(produto);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Rota que busca um produto pelo seu ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> getById(@PathVariable Integer id) {
		Produto produto = produtoRepository.findOne(id);

		if (produto == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	/**
	 * Busca um produto pelo seu nome
	 * 
	 * @param nomeProduto
	 * @return
	 */
	@RequestMapping(value = "/produto/nome/{nomeProduto}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> getByName(@PathVariable String nomeProduto) {
		Produto produto = produtoRepository.searchByProdName(nomeProduto);

		if (produto == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	/**
	 * Rota que atualiza um produto a partir de seu ID
	 * 
	 * @param id
	 * @param produto
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/produto/update/id/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto produto,
			UriComponentsBuilder ucBuilder) {

		Produto currentProduto = produtoRepository.findOne(id);

		if (currentProduto == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}

		currentProduto.setNome(produto.getNome());
		currentProduto.setPreco(produto.getPreco());
		currentProduto.setTipo(produto.getTipo());
		currentProduto.setCategoriaProduto(produto.getCategoriaProduto());

		produtoRepository.save(currentProduto);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/produto/update/id/{id}").buildAndExpand(produto.getId()).toUri());
		return new ResponseEntity<Produto>(header, HttpStatus.OK);
	}

	/**
	 * Rota que atualiza um produto a partir de seu nome
	 * 
	 * @param nomeProduto
	 * @param produto
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/produto/update/nome/{nomeProduto}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> updateByName(@PathVariable String nomeProduto, @RequestBody Produto produto,
			UriComponentsBuilder ucBuilder) {

		Produto currentProduto = produtoRepository.searchByProdName(nomeProduto);

		if (currentProduto == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}

		currentProduto.setNome(produto.getNome());
		currentProduto.setPreco(produto.getPreco());
		currentProduto.setTipo(produto.getTipo());
		currentProduto.setCategoriaProduto(produto.getCategoriaProduto());

		produtoRepository.save(currentProduto);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(
				ucBuilder.path("/produto/update/nome/{nomeProduto}").buildAndExpand(produto.getNome()).toUri());
		return new ResponseEntity<Produto>(header, HttpStatus.OK);
	}
}
