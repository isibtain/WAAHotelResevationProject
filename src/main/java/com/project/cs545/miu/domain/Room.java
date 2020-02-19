package com.project.cs545.miu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rmid;
	
	private String roomID;
	
	@Valid
	@OneToOne(cascade=CascadeType.MERGE)
    private RoomType type;
	
	@Valid
	@OneToOne(cascade=CascadeType.MERGE)
    private ViewType view;
	
    private Double price;
    
    public Room() {}

	public Room(RoomType type, ViewType view) {
		this.type = type;
		this.view = view;
		this.price = type.getPrice() + view.getPrice();
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public ViewType getView() {
		return view;
	}

	public void setView(ViewType view) {
		this.view = view;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getId() {
		return rmid;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
    
}
