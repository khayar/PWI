package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="inventory_id")
	private int inventoryId;

	@Column(name="available_quantity")
	private int availableQuantity;

	@Column(name="in_stock")
	private int inStock;

	@Column(name="in_transit")
	private int inTransit;

	@Column(name="mininum_order_quantity")
	private int mininumOrderQuantity;

	@Column(name="quantity_per_box")
	private int quantityPerBox;

	@Column(name="reoder_point")
	private int reoderPoint;

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	private Warehouse warehouse;

	public Inventory() {
	}

	public int getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int getInStock() {
		return this.inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getInTransit() {
		return this.inTransit;
	}

	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}

	public int getMininumOrderQuantity() {
		return this.mininumOrderQuantity;
	}

	public void setMininumOrderQuantity(int mininumOrderQuantity) {
		this.mininumOrderQuantity = mininumOrderQuantity;
	}

	public int getQuantityPerBox() {
		return this.quantityPerBox;
	}

	public void setQuantityPerBox(int quantityPerBox) {
		this.quantityPerBox = quantityPerBox;
	}

	public int getReoderPoint() {
		return this.reoderPoint;
	}

	public void setReoderPoint(int reoderPoint) {
		this.reoderPoint = reoderPoint;
	}

	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}