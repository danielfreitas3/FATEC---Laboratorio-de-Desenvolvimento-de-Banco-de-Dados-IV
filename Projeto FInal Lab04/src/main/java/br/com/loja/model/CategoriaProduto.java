package br.com.loja.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa uma Categoria no sistema
 * 
 * @author Aluno
 *
 */
@Entity
@Table(name = "categoriaproduto")
@Getter
@Setter
@NoArgsConstructor
public class CategoriaProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catprod_id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "catprod_nome", length = 50)
	private String nome;

	@Column(name = "catprod_descricao", length = 150)
	private String descricao;

	@OneToMany(mappedBy = "categoriaProduto", fetch = FetchType.EAGER, cascade = { CascadeType.DETACH })
	private List<Produto> listaDeProdutos;

	/**
	 * Sobrescrita do metodo toString para retornar as informacoes do objeto
	 * 
	 * @return retorna informacoes do Objeto como String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\nID: ");
		sb.append(getId() != null ? getId() : " ");
		sb.append("\nNOME DA CATEGORIA: ");
		sb.append(getNome() != null ? getNome() : " ");
		sb.append("\nDESCRICAO DA CATEGORIA: ");
		sb.append(getDescricao() != null ? getDescricao() : " ");
		return sb.toString();
	}

}