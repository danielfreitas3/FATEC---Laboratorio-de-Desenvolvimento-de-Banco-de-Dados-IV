package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Username;

@Repository
public interface UsernameRepository extends CrudRepository<Username, Integer> {

}
