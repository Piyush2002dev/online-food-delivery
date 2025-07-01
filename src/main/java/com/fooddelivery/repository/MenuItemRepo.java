package com.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddelivery.entity.MenuItem;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Integer> {
	public List<MenuItem> findByRestaurantId(int id);
}
