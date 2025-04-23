package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "product_info")

@Data
@NoArgsConstructor
public class Product {

	@Id

	@Column(name = "pId")

	@GeneratedValue

	private int productId;
	@NotBlank(message="Product Name can't be NULL or BLANK")
	private String productName;

	@Column(name = "price")
	@Min(value=100,message="ProductPrice can't be below 100")
	@Max(value=100000,message="ProductPrice must be below 1 lakh")
	private int productPrice;
	@Size(min=5,max=12,message="Category length must be between (5,12)")
	private String productCategory;

	@Column(name = "quantity")
	@Positive(message="Quantity cannot be zero or negative")
	private int productQuantity;

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {

		super();

		this.productName = productName;

		this.productPrice = productPrice;

		this.productCategory = productCategory;

		this.productQuantity = productQuantity;

	}

}
