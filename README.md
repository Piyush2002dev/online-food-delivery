# 🍽️ Menu Service – Online Food Delivery System

Welcome to the **Menu Service** of the **Online Food Delivery Platform** – a modular, scalable, and RESTful backend system for managing restaurant menus with ease. Designed using **Java + Spring Boot**, this service empowers restaurant owners to maintain their food listings, while serving dynamic menus to customers in real time.

---

## 📌 Features

- 🚀 **Add / Update / Delete** menu items
- 🧾 Fetch menus dynamically based on `restaurantId`
- 🖼️ Structured DTO-based responses
- 🛡️ Robust error handling via custom exceptions
- 🔍 Easily extendable for restaurant-specific filtering or categorization

---

## 🔧 Tech Stack

| Layer          | Technology                  |
|----------------|-----------------------------|
| Language       | Java 17                     |
| Framework      | Spring Boot (REST)          |
| Build Tool     | Maven                       |
| Data Access    | Spring Data JPA             |
| Database       | MySQL / PostgreSQL (configurable) |
| API Docs       | Swagger / OpenAPI (Optional) |

---

## 🏗️ Project Structure

---

## 📡 Endpoints Overview

| Method | Endpoint                   | Description                      |
|--------|----------------------------|----------------------------------|
| GET    | `/menuitems`               | Retrieve all menu items          |
| GET    | `/menuitems/{id}`          | Get menu item by ID              |
| GET    | `/menuitems/restaurant/{restaurantId}` | Get menu for a restaurant |
| POST   | `/menuitems`               | Add a new menu item              |
| PUT    | `/menuitems/{id}`          | Update an existing item          |
| DELETE | `/menuitems/{id}`          | Delete a menu item               |

---

## 🧪 Sample JSON – Menu Item

```json
{
  "name": "Classic Cheeseburger",
  "description": "Juicy grilled beef patty with melted cheddar cheese",
  "price": 8.99,
  "restaurantId": 101
}

