package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Caixa;

@Repository
public interface CaixaRepository extends CrudRepository<Caixa, Integer> {

}
