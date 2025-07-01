package com.fooddelivery.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MenuItem {
	@Id
	private int itemId;
	private String name;
	private String description;
	private double price;
	private int restaurantId;
	
}
