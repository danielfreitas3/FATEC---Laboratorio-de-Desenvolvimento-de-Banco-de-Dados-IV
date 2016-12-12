package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
