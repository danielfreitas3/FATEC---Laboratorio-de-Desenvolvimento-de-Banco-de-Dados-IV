package edu.fatec.sjc.entity;

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

import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente", catalog = "fatecsjcdb")
@Getter
@Setter
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cliente_id;

	@Column(name = "cliente_nome", length = 20, nullable = false)
	private String cliente_nome;

	@Column(name = "cliente_sobrenome", length = 20, nullable = false)
	private String cliente_sobrenome;

	@Column(name = "cliente_dataNascimento")
	@Temporal(TemporalType.DATE)
	private Date cliente_dataNascimento;

	@Column(name = "cliente_celular", length = 15)
	private String cliente_celular;

	@Column(name = "cliente_telefone", length = 14, nullable = false)
	private String cliente_telefone;

	public Cliente() {

	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(getCliente_nome() != null ? getCliente_nome() : "");
		stringBuilder.append("-");
		stringBuilder.append(getCliente_sobrenome() != null ? getCliente_sobrenome() : "");
		stringBuilder.append("-");
		stringBuilder.append(getCliente_dataNascimento() != null ? getCliente_dataNascimento() : "");
		stringBuilder.append("-");
		stringBuilder.append(getCliente_celular() != null ? getCliente_celular() : "");
		stringBuilder.append("-");
		stringBuilder.append(getCliente_telefone() != null ? getCliente_telefone() : "");

		return stringBuilder.toString();
	}

}
