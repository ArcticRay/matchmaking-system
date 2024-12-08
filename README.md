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
- **Redis (optional)**: For fast queue data management.

### Development Environment

- **IntelliJ IDEA**
- **Java 17** (or higher)

---

## 📖 Architecture

1. **MMR Calculation**:

   - Modular service for flexible integration of different rating algorithms.

2. **Queue Management**:

   - Data structures for efficient player grouping.

3. **Match Creation**:
   - Automated system to create teams based on MMR and preferences.

---
