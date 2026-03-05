# 🧠 Task Tracker CLI


A simple and efficient **Command Line Interface (CLI)** application for managing tasks, built with **Java**.

This project allows users to create, update, delete, and track tasks directly from the terminal.

It was developed to practice **backend development concepts**, **object-oriented programming**, and **clean architecture** while building a real CLI application.

challenge of: https://roadmap.sh/projects/task-tracker
---

# 📌 Features

* ✅ Add new tasks
* ✏️ Update existing tasks
* ❌ Delete tasks
* 🔄 Mark tasks as **in progress**
* ✔️ Mark tasks as **done**
* 📋 List all tasks
* 🔎 Filter tasks by status

---

# 🧱 Project Architecture

The project follows a **layered architecture** to keep responsibilities separated and the code maintainable.

```
task-cli
│
├── cli
│   └── TaskCLI.java
│
├── entities
│   └── Task.java
│
├── repository
│   └── TaskRepository.java
│
├── service
│   └── TaskService.java
│
├── utils
│   └── TaskStatus.java
│
└── Main.java
```

### Layers

| Layer          | Responsibility           |
| -------------- | ------------------------ |
| **CLI**        | Parses terminal commands |
| **Service**    | Contains business rules  |
| **Repository** | Manages data storage     |
| **Entities**   | Domain models            |
| **Utils**      | Enums and helper classes |

---

# ⚙️ Installation

Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/task-cli.git
```

Enter the project directory:

```bash
cd task-cli
```

Compile the project:

```bash
javac -d out src/main/java/**/*.java
```

Run the application:

```bash
java -cp out Main
```

---

# 💻 Usage

## Add a new task

```bash
task-cli add "Buy groceries"
```

Output:

```
Task added successfully (ID: 1)
```

---

## Update a task

```bash
task-cli update 1 "Buy groceries and cook dinner"
```

---

## Delete a task

```bash
task-cli delete 1
```

---

## Mark task as in progress

```bash
task-cli mark-in-progress 1
```

---

## Mark task as done

```bash
task-cli mark-done 1
```

---

## List all tasks

```bash
task-cli list
```

---

## Filter tasks by status

### List completed tasks

```bash
task-cli list done
```

### List todo tasks

```bash
task-cli list todo
```

### List tasks in progress

```bash
task-cli list in-progress
```

---

# 🖥 Example Output

```
----------------------------------------
ID: 1
Description: Buy groceries
Status: TODO
Created At: 05/03/2026 19:30
Updated At: 05/03/2026 19:30
----------------------------------------
```

---

# 🛠 Technologies

* Java
* Object-Oriented Programming
* CLI Architecture
* Java Streams
* LocalDateTime API

---

# 🎯 Learning Goals

This project was created to practice and demonstrate:

* Object-Oriented Design
* Separation of Concerns
* CLI Application Development
* Clean Code Practices
* Java Collections
* Software Architecture Basics

---

# 📦 Example Workflow

Example of a real usage flow:

```
task-cli add "Study Java"
task-cli add "Go to the gym"
task-cli mark-in-progress 1
task-cli mark-done 1
task-cli list done
```

---

# 👨‍💻 Author

**Kayke Simão**

Backend developer  🚀

Interested in:

* Backend development
* Distributed systems
* Software architecture
* CLI tools

GitHub:
https://github.com/kaykeS8/
