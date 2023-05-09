class: inverse, center, middle

# Interfészek - dependency inversion

---

# Dependency inversion

* Nem egy osztályra függünk, hanem egy interfészre
* Implementáció könnyen cserélhető
* Szerződés az interfészt implementáló és a használó között

---

# Dependency inversion UML

![UML diagram](images/interfacedependencyinversion.png)

---

# Dependency inversion interfész és kliens

```java
public interface BonusCalculator {
  int calculateBonus(int salary);
}
```

```java
public class Employee {
  
  private int salary;
  
  private BonusCalculator calculator;

  public Employee(int salary, BonusCalculator calculator) {
    this.salary = salary;
    this.calculator = calculator;
  }
  
  public int getBonus() {
    return calculator.getBonus(salary);
  }    
  
}
```

---

# Implementációk

```java
public class PercentBonusCalculator implements BonusCalculator {
  public int calculateBonus(int salary) {
    return salary * 1.25;
  }
}
```

```java
public class FixBonusCalculator implements BonusCalculator {
  public int calculateBonus(int salary) {
    return salary + 10_000;
  }
}
```