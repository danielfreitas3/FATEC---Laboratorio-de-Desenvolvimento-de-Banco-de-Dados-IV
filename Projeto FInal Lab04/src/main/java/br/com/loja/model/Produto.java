package br.com.loja.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa um Fornecedor no sistema
 * 
 * @author Daniel e Eloisa
 *
 */
@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id", nullable = false, unique = true)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "catprod_id", referencedColumnName = "catprod_id")
	private CategoriaProduto categoriaProduto;

	@Column(name = "prod_preco", precision = 5, scale = 2)
	private Double preco;

	@Column(name = "prod_nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "prod_tipo", length = 50, nullable = false)
	private String tipo;

	/**
	 * Sobrescrita do metodo toString para retornar as informacoes do objeto
	 * 
	 * @return retorna informacoes do Objeto como String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\nID: ");
		sb.append(getId() != null ? getId() : " ");
		sb.append("\nNOME DO PRODUTO: ");
		sb.append(getNome() != null ? getNome() : " ");
		sb.append("\nPRECO DO PRODUTO: ");
		sb.append(getPreco() != null ? getPreco() : " ");
		sb.append("\nTIPO DO PRODUTO: ");
		sb.append(getTipo() != null ? getTipo() : " ");

		return sb.toString();
	}

}
