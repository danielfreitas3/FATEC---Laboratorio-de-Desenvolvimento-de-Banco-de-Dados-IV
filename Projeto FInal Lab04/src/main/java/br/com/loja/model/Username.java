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
 * Classe que representa um Username no sistema
 * 
 * @author Daniel e Eloisa
 *
 */
@Entity
@Table(name = "username")
@Getter
@Setter
@NoArgsConstructor
public class Username implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "user_nomeusuario", nullable = false, unique = true, length = 50)
	private String usuario;

	@Column(name = "user_senha", nullable = false, length = 50)
	private String senha;

	/**
	 * Sobrescrita do metodo toString para retornar as informacoes do objeto
	 * 
	 * @return retorna informacoes do Objeto como String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\nID: ");
		sb.append(getId() != null ? getId() : " ");
		sb.append("\nUSUARIO: ");
		sb.append(getUsuario() != null ? getUsuario() : " ");
		sb.append("\nSENHA: ");
		sb.append(getSenha() != null ? getSenha() : " ");

		return sb.toString();
	}

}
