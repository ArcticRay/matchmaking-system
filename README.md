# Matchmaking System

A backend system to simulate and enhance a matchmaking system inspired by League of Legends. Built using **Spring Boot** and **Gradle**, focusing on scalability, fairness, and flexibility.

---

## 🚀 Features

### Core Features

- **MMR Calculation**:

  - Implements the ELO system to evaluate player skill levels.
  - Adjusts MMR based on wins, losses, and in-game performance.

- **Queue Management**:

  - Groups players based on MMR and preferences.
  - Implements timeout rules to accept larger MMR differences after prolonged waiting times.

- **Role-based Matchmaking**:

  - Considers player role preferences (e.g., Top, Mid, Jungle, ADC, Support).

- **Regional Preferences**:
  - Allows players to choose regions (e.g., EUW, NA) and considers ping limits.

### Advanced Features

- **Performance-based Adjustments**:
  - Analyzes individual statistics like KDA, farm, and objective control to refine MMR calculations.

---

## 🛠️ Technologies

### Core Technologies

- **Spring Boot**: Backend framework.
- **Gradle**: Build and dependency management.
- **H2 Database**: For local testing and development.
<!--- **Redis (optional)**: For fast queue data management. -->

### Development Environment

- **IntelliJ IDEA**
- **Java 23**

---

## 🧩 Programming Principles and Best Practices

This project adheres to key programming principles and best practices to ensure high-quality, maintainable, and scalable code. Below are the guiding principles followed in the design and implementation:

- **Encapsulation**:

  - Each class has a single, well-defined responsibility.
  - Data is hidden and accessed through dedicated methods to maintain integrity.

- **Reusability**:

  - Utility classes like `RankManager` centralize logic, making it reusable across the application.
  - Services like `MMRManager` are modular and decoupled, promoting reuse in other contexts.

- **Separation of Concerns (SoC)**:

  - The project separates business logic (`MMRManager`), data models (`Player`), and utility logic (`RankManager`) to improve clarity and reduce dependencies.

- **Scalability**:

  - The code is designed to be easily extendable, allowing new features (e.g., additional ranks, advanced matchmaking criteria) to be added with minimal refactoring.

- **Testability**:

  - The project includes comprehensive unit tests for all critical components, ensuring correctness and making future changes safe and predictable.

- **Clean Code**:
  - Clear naming conventions, modular structure, and concise methods are used to enhance readability and maintainability.

This focus on quality reflects the importance of well-engineered systems, especially in complex domains like matchmaking, where modularity, correctness, and extensibility are key.
