package com.vipul.retailstore.server.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * BillItem
 */
@Validated
public class BillItem {
	@JsonProperty("billId")
	private Long billId = null;

	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("itemCost")
	private Double itemCost = null;

	@JsonProperty("itemSalesTax")
	private Double itemSalesTax = null;

	@JsonProperty("quantity")
	private Long quantity = null;

	/**
	 * Bill Item Status
	 */
	public enum StatusEnum {
		ADDED("added"),

		DELETED("deleted");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	@JsonProperty("productId")
	private Long productId = null;

	public BillItem billId(Long billId) {
		this.billId = billId;
		return this;
	}

	/**
	 * Get billId
	 * 
	 * @return billId
	 **/
	@ApiModelProperty(value = "")

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public BillItem id(Long id) {
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

	public BillItem itemCost(Double itemCost) {
		this.itemCost = itemCost;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get itemCost
	 * 
	 * @return itemCost
	 **/
	@ApiModelProperty(value = "")

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public BillItem itemSalesTax(Double itemSalesTax) {
		this.itemSalesTax = itemSalesTax;
		return this;
	}

	/**
	 * Get itemSalesTax
	 * 
	 * @return itemSalesTax
	 **/
	@ApiModelProperty(value = "")

	public Double getItemSalesTax() {
		return itemSalesTax;
	}

	public void setItemSalesTax(Double itemSalesTax) {
		this.itemSalesTax = itemSalesTax;
	}

	public BillItem status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Bill Item Status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Bill Item Status")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public BillItem productId(Long productId) {
		this.productId = productId;
		return this;
	}

	/**
	 * Get productId
	 * 
	 * @return productId
	 **/
	@ApiModelProperty(value = "")

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BillItem billItem = (BillItem) o;
		return Objects.equals(this.billId, billItem.billId) && Objects.equals(this.id, billItem.id)
				&& Objects.equals(this.itemCost, billItem.itemCost) && Objects.equals(this.quantity, billItem.quantity)
				&& Objects.equals(this.itemSalesTax, billItem.itemSalesTax)
				&& Objects.equals(this.status, billItem.status) && Objects.equals(this.productId, billItem.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash("billItem",billId, id, quantity, itemCost, itemSalesTax, status, productId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BillItem {\n");

		sb.append("    billId: ").append(toIndentedString(billId)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    itemCost: ").append(toIndentedString(itemCost)).append("\n");
		sb.append("    itemSalesTax: ").append(toIndentedString(itemSalesTax)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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
