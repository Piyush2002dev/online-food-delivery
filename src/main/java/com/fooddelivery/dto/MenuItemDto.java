package com.fooddelivery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemDto {
	@NotNull(message="This cannot be left empty")
	private int itemId;
	@Size(max=15)
	private String name;
	@Size(max=500)
	private String description;
	private double price;
	private int restaurantId;
	
}