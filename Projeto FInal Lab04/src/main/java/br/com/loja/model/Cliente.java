package br.com.loja.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa um Cliente no sistema
 * 
 * @author Daniel e Eloisa
 *
 */
@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "cli_nome", length = 50)
	private String nome;

	@Column(name = "cli_sobrenome", length = 50)
	private String sobrenome;

	@Column(name = "cli_email", length = 150, unique = true)
	private String email;

	@Column(name = "cli_rg", length = 12, unique = true)
	private String rg;

	@Column(name = "cli_endereco", length = 100, nullable = false)
	private String endereco;

	@Temporal(TemporalType.DATE)
	@Column(name = "cli_dataCadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name = "cli_dataNascimento")
	private Date dataNascimento;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Venda> listaDeVendas;

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
		sb.append("\nNOME DO CLIENTE: ");
		sb.append(getNome() != null ? getNome() : " ");
		sb.append("\nSOBRENOME DO CLIENTE: ");
		sb.append(getSobrenome() != null ? getSobrenome() : " ");
		sb.append("\nEMAIL DO CLIENTE: ");
		sb.append(getEmail() != null ? getEmail() : " ");
		sb.append("\nRG DO CLIENTE: ");
		sb.append(getRg() != null ? getRg() : " ");
		sb.append("\nENDERECO DO CLIENTE: ");
		sb.append(getEndereco() != null ? getEndereco() : " ");
		sb.append("\nDATA DE CADASTRO: ");
		sb.append(getDataCadastro().toString() != null ? getDataCadastro().toString() : " ");
		sb.append("\nDATA DE NASCIMENTO: ");
		sb.append(getDataNascimento().toString() != null ? getDataNascimento().toString() : " ");

		return sb.toString();
	}

}
