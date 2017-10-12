package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	@Column(name="product_name")
	private String productName;

	//bi-directional one-to-one association to ComponentProduct
	@OneToOne(mappedBy="product")
	private ComponentProduct componentProduct;

	//bi-directional one-to-one association to FinishedProduct
	@OneToOne(mappedBy="product")
	private FinishedProduct finishedProduct;

	//bi-directional one-to-one association to PackagingMaterial
	@OneToOne(mappedBy="product")
	private PackagingMaterial packagingMaterial;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;

	//bi-directional many-to-one association to Size
	@OneToMany(mappedBy="product")
	private List<Size> sizes;

	//bi-directional many-to-many association to Warehouse
	@ManyToMany(mappedBy="products")
	private List<Warehouse> warehouses;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ComponentProduct getComponentProduct() {
		return this.componentProduct;
	}

	public void setComponentProduct(ComponentProduct componentProduct) {
		this.componentProduct = componentProduct;
	}

	public FinishedProduct getFinishedProduct() {
		return this.finishedProduct;
	}

	public void setFinishedProduct(FinishedProduct finishedProduct) {
		this.finishedProduct = finishedProduct;
	}

	public PackagingMaterial getPackagingMaterial() {
		return this.packagingMaterial;
	}

	public void setPackagingMaterial(PackagingMaterial packagingMaterial) {
		this.packagingMaterial = packagingMaterial;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Size> getSizes() {
		return this.sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

	public Size addSize(Size size) {
		getSizes().add(size);
		size.setProduct(this);

		return size;
	}

	public Size removeSize(Size size) {
		getSizes().remove(size);
		size.setProduct(null);

		return size;
	}

	public List<Warehouse> getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

}