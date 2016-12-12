package br.com.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

}
