# Lab 03: Encapsulation and Access Modifiers

**Student Details:**
- **Name:** Anesu B Kahanda
- **Registration Number:** H250407A
- **Department:** Computer Science
- **Course:** Object-Oriented Programming in Java

---

## Overview
This laboratory covers object-oriented encapsulation and data hiding:
1. Securing internal state using `private` fields and controlled getters/setters.
2. Understanding Java's four access levels: `private`, default (package-private), `protected`, and `public`.
3. Enforcing class invariants and business validation rules within setters and constructors.
4. Preventing encapsulation leaks using defensive copies (`Collections.unmodifiableList`).
5. Designing immutable classes (`final` class, `final` fields, no mutators).
6. Decoupling internal data representation from public external APIs.

---

## Files in this Directory

| File Name | Description |
|---|---|
| `BankAccount.java` | Program 3.1: Encapsulates balance and owner name with business checks on deposits and withdrawals. |
| `BankDemo.java` | Demonstrates safe usage of `BankAccount` and confirms that direct field mutations are prevented. |
| `Team.java` | Program 3.2: Demonstrates the defensive copy trap and how unmodifiable collections protect member lists. |
| `StudentGradeDemo.java` | Exercises 1 & 2: Encapsulated `Student` class validating marks (0-100) and dynamically computing letter grade. |
| `BankAccountWithHistory.java` | Exercise 3: Extends `BankAccount` with an audit log returned as an unmodifiable list. |
| `ImmutablePersonDemo.java` | Exercise 4: Immutable class implementation with clear design rationales. |
| `TemperatureKelvinDemo.java` | Exercise 5: Stores temperatures internally in Kelvin while providing Celsius/Fahrenheit interfaces and absolute zero validation. |

---

## How to Compile and Run

To compile all files:
```bash
javac *.java
```

To run individual programs:
```bash
java BankDemo
java Team
java StudentGradeDemo
java BankAccountWithHistory
java ImmutablePersonDemo
java TemperatureKelvinDemo
```

---

## Expected Output Samples

### `BankDemo.java`
```
ACC-001 [Tendai] balance: 750.00
Withdraw 100: true
Withdraw 5000: false
ACC-001 [Tendai] balance: 650.00
Rejected: Deposit must be positive
```

### `StudentGradeDemo.java`
```
Student: Anesu      | Marks:  82.5 | Grade: A
Student: Chenai     | Marks:  68.0 | Grade: B
Student: Farai      | Marks:  54.0 | Grade: C
Student: Tatenda    | Marks:  42.0 | Grade: F

Attempting to set marks to 115:
Validation Caught: Marks must be between 0 and 100. Received: 115.0
```
