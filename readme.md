# 💳 Payment Microservice – Food Delivery Platform

This microservice handles all payment-related operations within the Food Delivery ecosystem. It supports creating, retrieving, updating, filtering, and deleting payments, with support for multiple payment methods and statuses.

---

## 🚀 Features

- Create a new payment for a food order
- Retrieve payments by ID, status, or order
- Update payment status (e.g. mark as successful or failed)
- Retry failed payments
- Delete payments
- Enum-based support for `PaymentStatus` and `PaymentMethod`
- RESTful APIs with Spring Boot
- Microservice-ready with Eureka and modular database config

---

## 🧱 Tech Stack

| Layer       | Technology                  |
|-------------|-----------------------------|
| Framework   | Spring Boot 3.x             |
| Language    | Java 17+                    |
| Build Tool  | Maven                       |
| Database    | MySQL / PostgreSQL          |
| Registry    | Eureka (Spring Cloud)       |
| API Style   | REST                        |

---

## 📦 Package Structure

