package br.com.loja.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa uma Venda no sistema
 * 
 * @author Daniel e Eloisa
 *
 */
@Entity
@Table(name = "venda")
@Getter
@Setter
@NoArgsConstructor
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venda_id", nullable = false, unique = true)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cli_id", referencedColumnName = "cli_id")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "func_id", referencedColumnName = "func_matricula")
	private Funcionario funcionario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
	private Produto produto;

	@Enumerated(EnumType.STRING)
	@Column(name = "venda_formapagamento", length = 20, nullable = false)
	private FormaDePagamento formaDePagamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "venda_data")
	private Date venda;

	/**
	 * Sobrescrita do metodo toString para retornar as informacoes do objeto
	 * 
	 * @return retorna informacoes do Objeto como String
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\nID: ");
		sb.append(getId() != null ? getId() : " ");
		sb.append("\nFORMA DE PAGAMENTO: ");
		sb.append(getFormaDePagamento() != null ? getFormaDePagamento().toString() : " ");
		sb.append("\nDATA DE VENDA: ");
		sb.append(getVenda() != null ? getVenda().toString() : " ");

		return sb.toString();
	}

}
