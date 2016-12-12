package br.com.loja.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	@Query("SELECT p FROM Produto p WHERE prod_nome = :nomeProduto")
	public Produto searchByProdName(@Param("nomeProduto") String produto);

}
