# MiniProject_JAVA

## Project Overview

This project demonstrates the use of Object-Oriented Programming (OOP) principles in Java, including encapsulation, abstraction, polymorphism, and inheritance. It involves managing information about various news programs broadcast by a news channel and displaying the results in a GUI.

## Features

1. **Encapsulation**: Private variables with public getter and setter methods to manage access.
2. **Abstraction**: Use of an abstract class to define a common interface for news programs.
3. **Inheritance**: Extending the abstract class in a concrete class to provide specific implementations.
4. **Polymorphism**: Method overriding to provide specific behavior for different types of news programs.
5. **GUI Interface**: A graphical user interface created using Java Swing to interact with the user.

## Project Structure

- **Channel**: An abstract class that defines common properties and methods for news programs.
- **NewChannel**: A concrete class that extends the `Channel` class, implementing the abstract methods.
- **OopsGUI**: The main class that handles user input through a GUI and performs operations like finding the month with the maximum collection and identifying the busiest anchor.

## How to Run

1. Ensure you have Java installed on your system.
2. Clone the repository.
3. Compile the Java files using the following command:
   ```sh
   javac OopsGUI.java
   ```
4. Run the compiled class using the following command:
   ```sh
   java OopsGUI
   ```

## Example Usage

The GUI will prompt the user to enter details for multiple news programs, including the program name, anchor name, month of broadcasting, TRP rating, and business profit. It will then calculate and display the month with the maximum collection and the busiest anchor.

## Detailed Explanation

### Channel Class

The `Channel` class is an abstract class that encapsulates the properties of a news program such as program name, anchor, month, TRP rating, and business profit. It provides getter and setter methods for these properties and declares an abstract `display` method.

### NewChannel Class

The `NewChannel` class extends the `Channel` class and provides a concrete implementation of the `display` method. This class demonstrates polymorphism through method overriding.

### OopsGUI Class

The `OopsGUI` class contains the main method and sets up the GUI for the application. It includes buttons for adding a program, finding the month with the maximum collection, and identifying the busiest anchor.

- **addProgram**: Prompts the user to enter details for a new program and adds it to the list.
- **findMaxCollectionMonth**: Calculates the total business profit for each month and identifies the month with the highest collection.
- **findBusyAnchor**: Determines which anchor is associated with the most programs and identifies the busiest anchor.

If any queries feel free to contact my linkedIn profile **https://www.linkedin.com/in/abarna-mouli/**
