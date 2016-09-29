package edu.fatec.sjc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock", catalog = "fatecsjcdb", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "stock_name"),
		@UniqueConstraint(columnNames = "stock_code") })
@Getter
@Setter
@NoArgsConstructor
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id", unique = true, nullable = false)
	private Integer stockId;
	
	@Column(name = "stock_code", unique = true, nullable = false, length = 10)
	private String stockCode;
	
	@Column(name = "stock_name", unique = true, nullable = false, length = 20)
	private String stockName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "stock_category", catalog = "fatecsjcdb", joinColumns = {
			@JoinColumn(name = "stock_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "category_id",
					nullable = false, updatable = false) })
	private Set<Category> categories = new HashSet<Category>(0);
	
	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.categories = new HashSet<Category>();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getStockId() != null ? getStockId() : "");
		sb.append("-");
		sb.append(getStockName() != null ? getStockName() : "");
		return sb.toString();
	}
}
