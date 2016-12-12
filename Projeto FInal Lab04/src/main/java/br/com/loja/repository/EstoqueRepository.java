package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Integer> {

}
