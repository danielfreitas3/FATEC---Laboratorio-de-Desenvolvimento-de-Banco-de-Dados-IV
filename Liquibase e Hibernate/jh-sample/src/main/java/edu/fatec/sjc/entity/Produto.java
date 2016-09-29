package edu.fatec.sjc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "Produto", catalog = "fatecsjcdb")
@Getter
@Setter
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int produto_id;

	@Column(name = "produto_nome", length = 50, nullable = false)
	private String produto_nome;

	@Column(name = "produto_preco", nullable = false, precision = 6, scale = 2)
	private Float produto_preco;

	@Column(name = "produto_categoria")
	private String produto_categoria;

	@Column(name = "produto_quantidade", nullable = false)
	private Integer produto_quantidade;

	@Column(name = "produto_marca", nullable = false)
	private String produto_marca;

	public Produto() {

	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(getProduto_nome() != null ? getProduto_nome() : "");
		stringBuilder.append("-");
		stringBuilder.append(getProduto_preco() != null ? getProduto_preco() : "");
		stringBuilder.append("-");
		stringBuilder.append(getProduto_categoria() != null ? getProduto_preco() : "");
		stringBuilder.append("-");
		stringBuilder.append(getProduto_quantidade() != null ? getProduto_quantidade() : "");
		stringBuilder.append("-");
		stringBuilder.append(getProduto_marca() != null ? getProduto_marca() : "");

		return stringBuilder.toString();
	}
}