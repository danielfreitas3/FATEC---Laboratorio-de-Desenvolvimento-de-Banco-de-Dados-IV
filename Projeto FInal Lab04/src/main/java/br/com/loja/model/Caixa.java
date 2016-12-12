package br.com.loja.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa o Caixa no sistema
 * 
 * @author Daniel e Eloisa
 *
 */
@Entity
@Table(name = "caixa")
@Getter
@Setter
@NoArgsConstructor
public class Caixa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "caixa_id", nullable = false, unique = true)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "caixa_data")
	private Date data;

	@Column(name = "caixa_movimento", precision = 7, scale = 2)
	private Double movimentoDeDinheiro;

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
		sb.append("\nDATA DO CAIXA: ");
		sb.append(getData() != null ? getData().toString() : " ");
		sb.append("\nMOVIMENTACAO: ");
		sb.append(getMovimentoDeDinheiro() != null ? getMovimentoDeDinheiro() : " ");

		return sb.toString();
	}
	
}
