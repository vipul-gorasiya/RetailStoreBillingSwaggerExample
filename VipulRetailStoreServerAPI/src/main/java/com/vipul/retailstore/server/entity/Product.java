package com.vipul.retailstore.server.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vipul.retailstore.server.model.Product.ProductCategoryEnum;

/**
 * Product
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	private String name = null;
	private Double cost = null;
	@Enumerated(EnumType.STRING)
	private ProductCategoryEnum productCategory = null;

	public Product id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product cost(Double cost) {
		this.cost = cost;
		return this;
	}

	/**
	 * Get cost
	 * 
	 * @return cost
	 **/
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Product productCategory(ProductCategoryEnum productCategory) {
		this.productCategory = productCategory;
		return this;
	}

	/**
	 * Category Type
	 * 
	 * @return productCategory
	 **/
	public ProductCategoryEnum getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryEnum productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Product product = (Product) o;
		return Objects.equals(this.id, product.id) 
				&& Objects.equals(this.name, product.name) && Objects.equals(this.cost, product.cost)
				&& Objects.equals(this.productCategory, product.productCategory);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, cost, productCategory);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Product {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
		sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
