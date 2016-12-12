package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.CategoriaProduto;

@Repository
public interface CategoriaProdutoRepository extends CrudRepository<CategoriaProduto, Integer> {

}
