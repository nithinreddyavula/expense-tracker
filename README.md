# 💰 Expense Tracker Application

A RESTful backend application to record, categorize, and manage daily expenses.

Built with **Java**, **Spring Boot**, **Spring MVC**, **Spring Data JPA**, and **MySQL**.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming Language |
| Spring Boot 3.2 | Application Framework |
| Spring MVC | REST API Layer |
| Spring Data JPA | Database ORM |
| MySQL | Relational Database |
| Maven | Build Tool |

---

## 📁 Project Structure

```
expense-tracker/
├── src/main/java/com/nithin/expensetracker/
│   ├── controller/        → REST API endpoints
│   ├── service/           → Business logic
│   ├── repository/        → Database operations
│   ├── model/             → Expense entity
│   └── ExpenseTrackerApplication.java
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

---

## 🚀 Features

- ✅ Add new expense
- ✅ View all expenses
- ✅ View expense by ID
- ✅ Update existing expense
- ✅ Delete expense
- ✅ Filter expenses by category
- ✅ Search expenses by keyword

---

## 📡 API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/expenses` | Get all expenses |
| GET | `/api/expenses/{id}` | Get expense by ID |
| POST | `/api/expenses` | Create new expense |
| PUT | `/api/expenses/{id}` | Update expense |
| DELETE | `/api/expenses/{id}` | Delete expense |
| GET | `/api/expenses/category/{category}` | Filter by category |
| GET | `/api/expenses/search?keyword=xyz` | Search by keyword |

---

## ⚙️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/expense-tracker.git
cd expense-tracker
```

### 2. Create MySQL Database
```sql
CREATE DATABASE expense_tracker_db;
```

### 3. Update application.properties
```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### 4. Run the application
```bash
mvn spring-boot:run
```

### 5. Test API
Open browser or Postman → `http://localhost:8080/api/expenses`

---

## 📝 Sample Request (POST)

```json
{
  "title": "Lunch at restaurant",
  "amount": 250.00,
  "category": "Food",
  "date": "2025-03-17",
  "description": "Team lunch"
}
```

---

## 👨‍💻 Author

**Avula Nithin Kumar Reddy**
- GitHub: [@nithinreddyavula](https://github.com/nithinreddy34261-del)
- Email: nithinreddy34261@gmail.com
