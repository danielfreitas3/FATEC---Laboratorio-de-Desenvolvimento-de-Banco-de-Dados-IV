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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa um Estoque no sistema
 * 
 * @author Daniel e Eloisa
 *
 */

@Entity
@Table(name = "estoque")
@Getter
@Setter
@NoArgsConstructor
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estoq_id", nullable = false, unique = true)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "forn_id", referencedColumnName = "forn_id")
	private Fornecedor fornecedor;

	@Column(name = "estoq_quantidade", nullable = false)
	private Integer quantidade;

	/**
	 * Sobrescrita do metodo toString para retornar as informacoes do objeto
	 * 
	 * @return retorna informacoes do Objeto como String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\nID: ");
		sb.append(getId() != null ? getId() : " ");
		sb.append("\nQUANTIDADE: ");
		sb.append(getQuantidade() != null ? getQuantidade() : " ");

		return sb.toString();
	}

}
