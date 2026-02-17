# Jack Entertainment Automation Framework

## Overview

This repository contains a **Java UI automation framework** developed to validate core user flows of the **JackEntertainment (PlayJack) web application**.

The framework covers the following end-to-end scenarios:

- **User Registration**
- **User Login**
- **Account Bonus History Verification**

The solution is built using the **Page Object Model (POM)** pattern.

---

## Technology Stack Overview

### Java (JDK 17+)

Java was selected as it is my strongest and most familiar programming language. It allows me to write clean, maintainable, and structured automation code, and integrates seamlessly with Selenium WebDriver and TestNG.

### Selenium WebDriver

Used for browser automation and UI interaction. Selenium allows direct control of Chrome and supports dynamic web applications.

### TestNG

Used as the test framework to provide:

- Clear and structured test execution

- Strong assertion support

- XML-based suite configuration

- Built-in reporting capabilities

- Flexible test selection and grouping 

### Maven

Used as the build and dependency management tool. Maven provides:

- Clean project structure  
- Dependency version control  
- CLI-based execution  
- CI-friendly configuration  

### WebDriverManager

Automatically manages browser driver versions, eliminating manual ChromeDriver setup issues.

---

## Design Patterns Used

### Page Object Model (POM)

Each page or major UI component is represented by a dedicated class inside the `pages` package.

This ensures:

- Separation of concerns  
- Reusable interaction methods  
- Improved maintainability  
- Reduced duplication  
- Cleaner test classes  

### Base Test Layer

A `BaseTest` class centralizes:

- WebDriver setup  
- Browser configuration  
- URL initialization  
- Teardown logic  

This guarantees that all tests are **independent and isolated**.

### Explicit Wait Strategy

The framework uses **explicit waits (WebDriverWait)** to:

- Handle dynamic UI rendering  
- Prevent flaky behavior  
- Ensure element visibility and clickability before interaction  

---

## Project Structure

src  
 ├── main  
 │   └── java  
 │       ├── core  
 │       ├── pages  
 │       └── utils  
 └── test  
     └── java  
         ├── core  
         └── tests  

Folder Responsibilities:

- **core** – WebDriver configuration and base test logic  
- **pages** – Page Object classes  
- **utils** – Configuration and test data  
- **tests** – Test cases for each user flow  

---

## Setup Instructions

### 1. Prerequisites

Ensure the following are installed:

- **Java 17+**  
- **Maven**  
- **Git**  
- **Google Chrome (latest version)**  

Verify installations:

java -version  
mvn -version  
git --version  

---

### 2. Clone the Repository

git clone https://github.com/emilianowachew/GAN-Automation-Task.git
cd GAN-Automation-Task

---

### 3. Install Dependencies

mvn clean install  

---

## Test Execution Guide

### Run All Tests

mvn clean test  

### Run Individual Test Classes

mvn -Dtest=LoginTest test  
mvn -Dtest=RegistrationTest test  
mvn -Dtest=BonusHistoryTest test  

---

## Test Coverage

### Registration Flow

- Click **Sign Up**  
- Accept cookies  
- Enter valid username (6–16 characters)  
- Enter valid email  
- Enter password (minimum 6 characters, at least one letter and one digit)  
- Accept **Terms and Conditions**  
- Verify redirect to `registrationSuccess=true`  
- Validate presence of **"Let's start"** button  

---

### Login Flow

- Accept cookies  
- Enter valid credentials  
- Submit login form  
- Verify successful login via **Social XP Wheel visibility**  

---

### Bonus History Flow

- Login successfully  
- Open Account Menu  
- Navigate to **Account History**  
- Open **BONUS** tab  
- Verify winnings value **5,000**  
- Verify description **Registration - Endless**  

---

## Stability Considerations

The framework includes several stability enhancements:

- Chrome password manager and leak detection popups are disabled via **ChromeOptions**  
- Explicit waits are used for dynamic elements  
- Retry logic implemented for header menu interaction  
- Tests are fully independent  
- No test relies on execution order  

---

## CI Readiness

The project is Maven-based and can be executed in CI environments using:

mvn clean test  

Execution parameters (browser, headless mode, credentials) can be configured via system properties, making the framework flexible for pipeline integration.

---

## Author

Developed as part of an automation task submission.
