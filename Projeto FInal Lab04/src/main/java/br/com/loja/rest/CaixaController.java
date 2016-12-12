package br.com.loja.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.model.Caixa;
import br.com.loja.repository.CaixaRepository;

@RestController
public class CaixaController {

	@Autowired
	private CaixaRepository caixaRepository;

	/**
	 * Rota que faz a consulta do Caixa
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/caixa/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Caixa> getCaixaById(@PathVariable Integer id) {

		Caixa caixa = caixaRepository.findOne(id);

		if (caixa == null) {
			return new ResponseEntity<Caixa>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Caixa>(caixa, HttpStatus.OK);
	}
}
