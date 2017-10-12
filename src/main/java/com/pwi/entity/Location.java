package com.pwi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="location_id")
	private int locationId;

	@Column(name="location_name")
	private String locationName;

	//bi-directional many-to-one association to Warehouse
	@OneToMany(mappedBy="location")
	private List<Warehouse> warehouses;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<Warehouse> getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public Warehouse addWarehous(Warehouse warehous) {
		getWarehouses().add(warehous);
		warehous.setLocation(this);

		return warehous;
	}

	public Warehouse removeWarehous(Warehouse warehous) {
		getWarehouses().remove(warehous);
		warehous.setLocation(null);

		return warehous;
	}

}