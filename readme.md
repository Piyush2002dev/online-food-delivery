# 💳 Payment Service – Online Food Delivery System

This service handles payment-related functionality within the Online Food Delivery System. It supports multiple payment methods, processes transactions, maintains payment history, and integrates with third-party payment gateways. Designed with modularity and RESTful principles, it operates as an independent microservice.

---

## 🔑 Key Features

- Process customer payments for food orders
- Support for multiple payment methods (e.g., Card, Wallet, UPI)
- REST APIs for creating, retrieving, and updating payment status
- Integration-ready for third-party payment gateways
- Enum-driven status and method handling
- Built using Spring Boot and JPA with relational DB support

---

## 📦 Tech Stack

| Component      | Technology              |
|----------------|--------------------------|
| Language       | Java 17+                |
| Framework      | Spring Boot 3.x         |
| Database       | MySQL                   |
| API Style      | REST (Spring Web)       |
| ORM            | Spring Data JPA         |
| Discovery      | Eureka (optional)       |
| Build Tool     | Maven                   |

---

## 🧩 Module Overview

### 1. Functionalities

- Create and persist payment transactions
- Retrieve payments by ID or order ID
- Update and retry payment status
- Filter payments by status
- Delete payments (admin use)

### 2. Entities

#### `Payment`
- `paymentId`: Unique identifier
- `orderId`: Associated order
- `amount`: Transaction amount
- `method`: Payment method enum
- `status`: Payment status enum

#### Enums
```java
public enum PaymentMethod {
    CARD, WALLET, UPI, NETBANKING
}

public enum PaymentStatus {
    PENDING, SUCCESSFUL, FAILED
}
