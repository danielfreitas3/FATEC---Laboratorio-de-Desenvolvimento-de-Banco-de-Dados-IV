package edu.fatec.sjc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category", catalog = "fatecsjcdb")
@Getter
@Setter
@NoArgsConstructor
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Category(String categoryName, String categoryDesc) {
		this.categoryDesc = categoryDesc;
		this.categoryName = categoryName;
		this.stocks = new HashSet<Stock>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	private Integer categoryId;
	
	@Column(name = "category_name", nullable = false, length = 10)
	private String categoryName;
	
	@Column(name = "category_desc", nullable = false)
	private String categoryDesc;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Stock> stocks = new HashSet<Stock>(0);
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getCategoryId() != null ? getCategoryId() : "");
		sb.append("-");
		sb.append(getCategoryName() != null ? getCategoryName() : "");
		return sb.toString();
	}
}
