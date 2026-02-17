**Jack Entertainment Automation Framework**

#Overview
##This repository contains a Java-based UI automation framework developed for testing core user flows of the JackEntertainment (PlayJack) web application.

The framework covers the following end-to-end scenarios:
User Registration
User Login
Account Bonus History Verification

The project is structured using the Page Object Model pattern and built with stability, clarity, and maintainability in mind.

Technology Stack Overview
Java (JDK 17+)
Java was chosen for its strong ecosystem in test automation and long-term maintainability. It integrates seamlessly with Selenium and TestNG.

Selenium WebDriver
Used for browser automation. Selenium provides direct control over Chrome and allows interaction with dynamic UI elements.

TestNG
Used as the test framework for:

Test structure and execution control

Assertions

Test configuration via XML

Better reporting capabilities

Maven

Used as the build and dependency management tool. Maven allows:

Clean project structure

Dependency control

CI-friendly execution

Command-line test execution

ChromeDriver + WebDriverManager

WebDriverManager automatically manages browser driver versions, eliminating manual driver setup issues.

Design Patterns Used
Page Object Model (POM)

Each page or major UI component is represented by a dedicated class inside the pages package.

This ensures:

Clear separation of concerns

Reusable UI interaction methods

Improved maintainability

Reduced duplication

Cleaner test classes

Base Test Layer

A BaseTest class handles:

WebDriver setup and teardown

Browser configuration

URL loading

This ensures all tests run independently and cleanly.

Explicit Wait Strategy

The framework uses explicit waits via WebDriverWait to:

Handle dynamic React rendering

Avoid flaky tests

Ensure element visibility and clickability before interaction
