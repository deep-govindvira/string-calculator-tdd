# String Calculator TDD Kata (Java)

This is a **Java** implementation of the **String Calculator Kata** by Roy Osherove using **Test-Driven Development (TDD)** principles with **JUnit 5**.

## ✅ Features Implemented

- `""` → returns `0`
- `"1"` → returns `1`
- `"1,2"` → returns `3`
- Supports newline (`\n`) as a delimiter  
  → `"1\n2,3"` → returns `6`
- Supports **custom single-character delimiter**  
  → `"//;\n1;2"` → returns `3`
- Ignores numbers > `1000`  
  → `"2,1001"` → returns `2`
- Throws exception when negatives are present, listing all of them  
  → `"1,-2,-3"` → `IllegalArgumentException: negatives not allowed: [-2, -3]`
- Tracks number of times `add()` is called
- Supports **custom delimiters of any length**  
  → `"//[***]\n1***2***3"` → returns `6`
- Supports **multiple custom delimiters**  
  → `"//[*][%]\n1*2%3"` → returns `6`
- Supports **multiple delimiters of any length**  
  → `"//[**][%%]\n1**2%%3"` → returns `6`

---

## 🧪 Running the Tests

### Prerequisites
- Java 11+
- Maven

### Run tests
```bash
mvn test
