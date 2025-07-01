package com.fooddelivery.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.dto.MenuItemDto;
import com.fooddelivery.service.MenuItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("menuItem")
public class MenuItemController {
	
	private final MenuItemService menuItemService;
	
	public MenuItemController(MenuItemService menuItemService) {
		this.menuItemService = menuItemService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<MenuItemDto> add(@RequestBody @Valid MenuItemDto dto) {
		return new ResponseEntity<MenuItemDto>(menuItemService.add(dto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MenuItemDto> getID(@PathVariable int id) {
		return new ResponseEntity<MenuItemDto>(menuItemService.getId(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/update")
	public ResponseEntity<MenuItemDto> udpate(@RequestBody @Valid MenuItemDto dto) {
		return new ResponseEntity<MenuItemDto>(menuItemService.update(dto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MenuItemDto> delete(@PathVariable int id) {
		return new ResponseEntity<MenuItemDto>(menuItemService.delete(id),HttpStatus.OK);
	}
	
	@GetMapping("/restaurantId/{id}")
	public ResponseEntity<List<MenuItemDto>> getMenuByRestaurants(@PathVariable int id) {
		return new ResponseEntity<List<MenuItemDto>>(menuItemService.getMenuByRestaurants(id),HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<MenuItemDto>> getMenu() {
		return new ResponseEntity<List<MenuItemDto>>(menuItemService.getMenu(),HttpStatus.OK);
	}
	
}
