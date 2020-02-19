package com.project.cs545.miu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rtid;
	
	@NotEmpty(message="{NotEmpty.validation}")
	private String name;
	
	@NotNull(message = "{NotNull.validation}")
	private Double price;
	
	public RoomType() {}

	public long getId() {
		return rtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double basePrice) {
		this.price = basePrice;
	}
	
}
