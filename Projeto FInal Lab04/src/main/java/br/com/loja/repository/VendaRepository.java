package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer> {

}
