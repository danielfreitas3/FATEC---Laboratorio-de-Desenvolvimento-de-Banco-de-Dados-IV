package br.com.loja.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa um Funcionario no sistema
 * 
 * @author Daniel e Eloisa
 *
 */
@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "func_matricula", nullable = false, unique = true)
	private Integer matricula;

	@OneToOne(optional = false, fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.DETACH)
	@JoinColumn(name = "user_id", nullable = false)
	private Username userName;

	@Column(name = "func_nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "func_sobrenome", nullable = false, length = 50)
	private String sobrenome;

	@Column(name = "func_email", length = 150)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "func_datacadastro", nullable = false)
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name = "func_datanascimento")
	private Date dataNascimento;

	@Column(name = "func_rg", length = 12, unique = true)
	private String rg;

	@Column(name = "func_endereco", length = 100)
	private String endereco;

	@Column(name = "func_salario", precision = 6, scale = 2)
	private Double salario;

	/**
	 * Sobrescrita do metodo toString para retornar as informacoes do objeto
	 * 
	 * @return retorna informacoes do Objeto como String
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\nMATRICULA: ");
		sb.append(getMatricula() != null ? getMatricula() : " ");
		sb.append("\nNOME: ");
		sb.append(getNome() != null ? getNome() : " ");
		sb.append("\nSOBRENOME : ");
		sb.append(getSobrenome() != null ? getSobrenome() : " ");
		sb.append("\nUSUARIO: ");
		sb.append(getUserName().getUsuario() != null ? getUserName().getUsuario() : " ");
		sb.append("\nSENHA: ");
		sb.append(getUserName().getSenha() != null ? getUserName().getSenha() : " ");
		sb.append("\nEMAIL: ");
		sb.append(getEmail() != null ? getEmail() : " ");
		sb.append("\nDATA DE CADASTRO: ");
		sb.append(getDataCadastro() != null ? getDataCadastro().toString() : " ");
		sb.append("\nDATA DE NASCIMENTO: ");
		sb.append(getDataNascimento() != null ? getDataNascimento().toString() : " ");
		sb.append("\nRG: ");
		sb.append(getRg() != null ? getRg() : " ");
		sb.append("\nENDERECO: ");
		sb.append(getEndereco() != null ? getEndereco() : " ");
		sb.append("\nSALARIO: ");
		sb.append(getSalario() != null ? getSalario() : " ");

		return sb.toString();
	}

}
