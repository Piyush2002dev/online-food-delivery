package com.fooddelivery.service;

import java.util.List;

import com.fooddelivery.dto.MenuItemDto;

public interface MenuItemService {
	public MenuItemDto add(MenuItemDto dto);
	public MenuItemDto getId(int id);
	public MenuItemDto update(MenuItemDto dto);
	public MenuItemDto delete(int id);
	public List<MenuItemDto> getMenuByRestaurants(int id);
	public List<MenuItemDto> getMenu();
}
