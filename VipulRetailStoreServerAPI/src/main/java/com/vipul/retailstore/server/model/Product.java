package com.vipul.retailstore.server.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-13T10:52:16.203+05:30")

public class Product {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("cost")
	private Double cost = null;

	@JsonProperty("salesTax")
	private Double salesTax = null;

	/**
	 * Category Type
	 */
	public enum ProductCategoryEnum {
		A("A"),

		B("B"),

		C("C");

		private String value;

		ProductCategoryEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ProductCategoryEnum fromValue(String text) {
			for (ProductCategoryEnum b : ProductCategoryEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("productCategory")
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
	@ApiModelProperty(value = "")

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
	@ApiModelProperty(value = "")

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
	@ApiModelProperty(value = "")

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Product salesTax(Double salesTax) {
		this.salesTax = salesTax;
		return this;
	}

	/**
	 * Get salesTax
	 * 
	 * @return salesTax
	 **/
	@ApiModelProperty(value = "")

	public Double getSalesTax() {
		Double salesTax = 0D;
		switch (productCategory) {
		case A:
			salesTax = cost * 0.10;
			break;
		case B:
			salesTax = cost * 0.20;
			break;

		default:
			break;
		}
		return salesTax;
	}

	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
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
	@ApiModelProperty(value = "Category Type")

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
		return Objects.equals(this.id, product.id) && Objects.equals(this.name, product.name)
				&& Objects.equals(this.cost, product.cost) && Objects.equals(this.salesTax, product.salesTax)
				&& Objects.equals(this.productCategory, product.productCategory);
	}

	@Override
	public int hashCode() {
		return Objects.hash("product", id, name, cost, salesTax, productCategory);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Product {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
		sb.append("    salesTax: ").append(toIndentedString(salesTax)).append("\n");
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
