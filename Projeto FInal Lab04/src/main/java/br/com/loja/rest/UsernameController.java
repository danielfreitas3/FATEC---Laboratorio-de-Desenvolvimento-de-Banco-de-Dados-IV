package br.com.loja.rest;

import java.util.List;

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

import br.com.loja.model.Username;
import br.com.loja.repository.UsernameRepository;

@RestController
public class UsernameController {

	@Autowired
	private UsernameRepository usernameRepository;

	/**
	 * Rota que busca todos os Usernames cadastrados
	 * 
	 * @return
	 */
	@RequestMapping(value = "/username/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Username>> findAll() {
		List<Username> usernameList = (List<Username>) usernameRepository.findAll();

		if (usernameList.isEmpty()) {
			return new ResponseEntity<List<Username>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Username>>(usernameList, HttpStatus.OK);
	}

	/**
	 * Rota que busca Username pelo seu ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/username/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Username> getById(@PathVariable Integer id) {
		Username username = usernameRepository.findOne(id);

		if (username == null) {
			return new ResponseEntity<Username>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Username>(username, HttpStatus.OK);
	}

	/**
	 * Rota que adiciona um Username
	 * 
	 * @param username
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/username/add", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Username username, UriComponentsBuilder ucBuilder) {
		usernameRepository.save(username);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/username/{id}").buildAndExpand(username.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * Rota que atualiza um Username
	 * 
	 * @param id
	 * @param username
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/username/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Username> update(@PathVariable Integer id, @RequestBody Username username,
			UriComponentsBuilder ucBuilder) {
		Username currentUsername = usernameRepository.findOne(id);

		if (currentUsername == null) {
			return new ResponseEntity<Username>(HttpStatus.NOT_FOUND);
		}

		currentUsername.setUsuario(username.getUsuario());
		currentUsername.setSenha(username.getSenha());

		usernameRepository.save(currentUsername);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("username/{id}").buildAndExpand(username.getId()).toUri());
		return new ResponseEntity<Username>(headers, HttpStatus.OK);
	}

	/**
	 * Rota que deleta um Username
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/username/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> remove(@PathVariable Integer id) {
		Username username = usernameRepository.findOne(id);

		if (username == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		usernameRepository.delete(username);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
