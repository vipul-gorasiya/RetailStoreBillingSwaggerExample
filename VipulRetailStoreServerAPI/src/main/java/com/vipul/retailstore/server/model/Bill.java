package com.vipul.retailstore.server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Bill
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-13T10:52:16.203+05:30")

public class Bill {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("totalCost")
	private Double totalCost = null;

	@JsonProperty("totalSalesTax")
	private Double totalSalesTax = null;

	/**
	 * Bill Status
	 */
	public enum StatusEnum {
		INPROGRESS("inprogress"),

		COMPLETED("completed");

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

	@JsonProperty("billItems")
	@Valid
	private List<BillItem> billItems = null;

	public Bill id(Long id) {
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

	public Bill totalCost(Double totalCost) {
		this.totalCost = totalCost;
		return this;
	}

	/**
	 * Get totalCost
	 * 
	 * @return totalCost
	 **/
	@ApiModelProperty(value = "")

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Bill totalSalesTax(Double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
		return this;
	}

	/**
	 * Get totalSalesTax
	 * 
	 * @return totalSalesTax
	 **/
	@ApiModelProperty(value = "")

	public Double getTotalSalesTax() {
		return totalSalesTax;
	}

	public void setTotalSalesTax(Double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}

	public Bill status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Bill Status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "Bill Status")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Bill billItems(List<BillItem> billItems) {
		this.billItems = billItems;
		return this;
	}

	public Bill addBillItemsItem(BillItem billItemsItem) {
		if (this.billItems == null) {
			this.billItems = new ArrayList<>();
		}
		this.totalCost = this.totalCost + billItemsItem.getItemCost();
		this.totalSalesTax = this.totalSalesTax + billItemsItem.getItemSalesTax();
		this.billItems.add(billItemsItem);
		return this;
	}

	public Bill deleteBillItem(BillItem billItem) {
		this.totalCost = this.totalCost - billItem.getItemCost();
		this.totalSalesTax = this.totalSalesTax - billItem.getItemSalesTax();
		return this;
	}

	/**
	 * Get billItems
	 * 
	 * @return billItems
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Bill bill = (Bill) o;
		return Objects.equals(this.id, bill.id) && Objects.equals(this.totalCost, bill.totalCost)
				&& Objects.equals(this.totalSalesTax, bill.totalSalesTax) && Objects.equals(this.status, bill.status)
				&& Objects.equals(this.billItems, bill.billItems);
	}

	@Override
	public int hashCode() {
		return Objects.hash("Bill", id, totalCost, totalSalesTax, status, billItems);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Bill {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    totalCost: ").append(toIndentedString(totalCost)).append("\n");
		sb.append("    totalSalesTax: ").append(toIndentedString(totalSalesTax)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    billItems: ").append(toIndentedString(billItems)).append("\n");
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
