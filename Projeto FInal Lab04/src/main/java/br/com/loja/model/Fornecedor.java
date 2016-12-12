package br.com.loja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "fornecedor")
@Getter
@Setter
@NoArgsConstructor
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "forn_id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "forn_nome", nullable = false)
	private String nome;

	@Column(name = "forn_email", length = 150)
	private String email;

	@Column(name = "forn_telefone", length = 15)
	private String telefone;

	@Column(name = "forn_endereco", length = 100)
	private String endereco;

	/**
	 * Sobrescrita do metodo toString para retornar as informacoes do objeto
	 * 
	 * @return retorna informacoes do Objeto como String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\nID: ");
		sb.append(getId() != null ? getId() : " ");
		sb.append("\nNOME: ");
		sb.append(getNome() != null ? getNome() : " ");
		sb.append("\nEMAIL: ");
		sb.append(getEmail() != null ? getEmail() : " ");
		sb.append("\nTELEFONE: ");
		sb.append(getTelefone() != null ? getTelefone() : " ");
		sb.append("\nENDERECO: ");
		sb.append(getEndereco() != null ? getEndereco() : " ");
		return sb.toString();
	}
}
