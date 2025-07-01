package com.fooddelivery.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.dto.MenuItemDto;
import com.fooddelivery.entity.MenuItem;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.MenuItemRepo;
import com.fooddelivery.service.MenuItemService;

import jakarta.transaction.Transactional;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	private final MenuItemRepo menuItemRepo;

	// Constructor Injection
	public MenuItemServiceImpl(MenuItemRepo menuItemRepo) {
		this.menuItemRepo = menuItemRepo;
	}

	public MenuItem dtoToEntity(MenuItemDto menuItemDto) {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemId(menuItemDto.getItemId());
		menuItem.setName(menuItemDto.getName());
		menuItem.setDescription(menuItemDto.getDescription());
		menuItem.setPrice(menuItemDto.getPrice());
		menuItem.setRestaurantId(menuItemDto.getRestaurantId());
		return menuItem;
	}

	public MenuItemDto entityToDto(MenuItem menuItem) {
		MenuItemDto menuItemDto = new MenuItemDto();
		menuItemDto.setItemId(menuItem.getItemId());
		menuItemDto.setName(menuItem.getName());
		menuItemDto.setDescription(menuItem.getDescription());
		menuItemDto.setPrice(menuItem.getPrice());
		menuItemDto.setRestaurantId(menuItem.getRestaurantId());
		return menuItemDto;
	}

	// Adding an object
	public MenuItemDto add(MenuItemDto dto) {
		if (dto != null && dto.getItemId() > 0) {
			MenuItem menuItem = dtoToEntity(dto);
			menuItemRepo.save(menuItem);
			return dto;
		} else {
			throw new ResourceNotFoundException("Invalid Object");
		}
	}

	// Getting an object by id
	public MenuItemDto getId(int id) {
		if (id > 0) {
			MenuItem menuItem = menuItemRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No Item found on this id :" + id));

			return entityToDto(menuItem);
		} else {
			throw new ResourceNotFoundException("Enter a valid id:- " + id);
		}
	}

	// Update object
	@Transactional
	public MenuItemDto update(MenuItemDto dto) {
		if (dto.getItemId() > 0) {

			MenuItem menuItem = menuItemRepo.findById(dto.getItemId())
					.orElseThrow(() -> new ResourceNotFoundException("Id not found"));
			menuItemRepo.save(dtoToEntity(dto));
			MenuItemDto menuItemDto = entityToDto(menuItem);
			return menuItemDto;

		} else {
			throw new ResourceNotFoundException("Invalid Object");
		}
	}

	// Delete an object by id
	@Transactional
	public MenuItemDto delete(int id) {
		if (id > 0) {

			MenuItem menuItem = menuItemRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Id not found"));
			menuItemRepo.deleteById(id);
			return entityToDto(menuItem);

		} else {
			throw new ResourceNotFoundException("Give Id more than 0");
		}
	}

	// Get Menu by each Restaurants
	public List<MenuItemDto> getMenuByRestaurants(int id) {

		if (id > 0) {

			List<MenuItem> listMenuItem = menuItemRepo.findByRestaurantId(id);
			List<MenuItemDto> listMenuItemDto = new ArrayList<>();

			for (MenuItem menuItem : listMenuItem) {
				listMenuItemDto.add(entityToDto(menuItem));
			}

			return listMenuItemDto;

		} else {
			throw new ResourceNotFoundException("Give Id more than 0");
		}

	}
	
	public List<MenuItemDto> getMenu() {
	    List<MenuItem> menuItems = menuItemRepo.findAll(); 
	    List<MenuItemDto> menuItemDtos = new ArrayList<>();

	    for (MenuItem menuItem : menuItems) {
	        menuItemDtos.add(entityToDto(menuItem)); 
	    }

	    return menuItemDtos;
	}

}
