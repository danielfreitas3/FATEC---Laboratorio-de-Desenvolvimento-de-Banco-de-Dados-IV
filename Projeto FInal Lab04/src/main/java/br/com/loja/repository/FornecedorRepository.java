package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer> {

}
