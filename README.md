# SpringBoot-Expense-tracker


A full-stack **Expense Tracker application** built using **Spring Boot** and **Angular**. The application allows users to manage their expenses through a clean web interface with features for creating, viewing, updating, deleting, filtering, and analyzing expenses.

## 🚀 Live Demo

**GitHub Pages:**
https://rishitha-pasupuleti.github.io/SpringBoot-Expense-tracker/

---

## 📌 Features

* ➕ Add new expenses
* 👀 View all expenses
* ✏️ Edit existing expenses
* 🗑️ Delete expenses
* 🔍 Filter expenses by category
* 📊 Calculate overall expenses
* 📈 Analyze expenses by category
* ✅ Mark expenses as completed/uncompleted
* 🌐 REST API powered by Spring Boot
* 💻 Responsive Angular frontend
* 🔗 Frontend and backend communication through REST APIs

---

## 🏗️ Project Architecture

```text
SpringBoot-Expense-tracker/
│
├── expense-tracker/          # Spring Boot Backend
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── frontend/                 # Angular Frontend
│   ├── src/
│   ├── angular.json
│   ├── package.json
│   └── ...
│
└── README.md
```

The application follows a **frontend-backend architecture**:

```text
┌─────────────────────┐
│      Angular        │
│      Frontend       │
└──────────┬──────────┘
           │
           │ REST API
           ▼
┌─────────────────────┐
│     Spring Boot     │
│       Backend       │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│      Database       │
│   / Data Storage    │
└─────────────────────┘
```

---

## 🛠️ Tech Stack

### Frontend

* Angular
* TypeScript
* HTML5
* CSS3
* JavaScript

### Backend

* Java
* Spring Boot
* Spring Web
* REST APIs
* Maven

### Development Tools

* Git
* GitHub
* Visual Studio Code
* IntelliJ IDEA

---

## 🔌 REST API

The Spring Boot backend exposes REST endpoints for managing expenses.

| Method   | Endpoint         | Description       |
| -------- | ---------------- | ----------------- |
| `GET`    | `/expenses`      | Get all expenses  |
| `POST`   | `/expenses`      | Add a new expense |
| `PUT`    | `/expenses/{id}` | Update an expense |
| `DELETE` | `/expenses/{id}` | Delete an expense |

Additional filtering and analysis endpoints can be used for category-based expense management and totals.

---

## 💻 Running the Project Locally

### 1. Clone the repository

```bash
git clone https://github.com/rishitha-pasupuleti/SpringBoot-Expense-tracker.git
```

```bash
cd SpringBoot-Expense-tracker
```

---

### 2. Start the Spring Boot Backend

Navigate to the backend:

```bash
cd expense-tracker
```

Run the application using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The backend will start on the configured Spring Boot port.

---

### 3. Start the Angular Frontend

Open another terminal and navigate to:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the Angular development server:

```bash
ng serve
```

The frontend will normally be available at:

```text
http://localhost:4200
```

---

## 📊 Application Workflow

```text
User
 │
 ▼
Angular UI
 │
 │ HTTP Requests
 ▼
Spring Boot REST API
 │
 ▼
Expense Service
 │
 ▼
Data Storage
 │
 ▼
Response
 │
 ▼
Angular UI
```

---

## 🎯 Key Learning Outcomes

This project helped me gain practical experience with:

* Building RESTful APIs using Spring Boot
* Developing frontend applications using Angular
* Connecting Angular applications with backend APIs
* Performing CRUD operations
* Handling HTTP requests and responses
* Designing reusable frontend components
* Managing application data
* Structuring a full-stack application
* Using Git and GitHub for version control

---

## 📸 Project Preview

Screenshots of the application can be added here.

```text
screenshots/
├── dashboard.png
├── add-expense.png
├── expense-list.png
└── analytics.png
```

---

## 🔮 Future Improvements

Potential improvements include:

* User authentication and authorization
* Persistent cloud database
* Monthly and yearly expense reports
* Advanced analytics
* Export expenses to CSV/PDF
* Budget tracking
* Recurring expenses
* Cloud deployment
* Improved mobile responsiveness

---

## 👩‍💻 Author

**Rishitha Pasupuleti**

Computer Science Engineering Graduate

Interested in Software Engineering, Full-Stack Development, Cloud, DevOps, and AI/ML.

### Connect

* GitHub: https://github.com/rishitha-pasupuleti
* Portfolio: https://rishitha-pasupuleti.github.io/portfolio.github.io/

---

## ⭐ If you found this project useful

Feel free to explore the repository, try the application, or use the project as a reference for learning Spring Boot and Angular.
