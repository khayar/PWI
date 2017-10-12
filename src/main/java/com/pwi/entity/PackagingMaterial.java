package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the packaging_material database table.
 * 
 */
@Entity
@Table(name="packaging_material")
@NamedQuery(name="PackagingMaterial.findAll", query="SELECT p FROM PackagingMaterial p")
public class PackagingMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	//bi-directional one-to-one association to Product
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;

	public PackagingMaterial() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}