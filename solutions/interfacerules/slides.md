class: inverse, center, middle

# Interfészekkel kapcsolatos szabályok

---

# Szabályok

* Interfész nem példányosítható
* Interfészt implementáló osztálynak implementálnia kell a metódust, vagy absztrakt osztálynak kell lennie
* Interfész előtt az `abstract` kulcsszó kiírása opcionális
* Nem lehet `final`

---

# Interfészekben szereplő attribútumok

* Konstans értékek deklarálhatóak, alapértelmezetten `public`, `static` és `final` kulcsszóval
    * enum megjelenése óta ritkábban használjuk
* Nem lehet példányattribútuma

```java
public interface EmployeeType {
  int FULL_TIME = 0;
  
  int PART_TIME = 1;
}
```

---

# Egy osztály több interfészt implementálhat

* Több tulajdonsággal rendelkezhet

```java
public interface CanWork {
  void doWork();
}
```

```java
public class Trainer implements HasName, CanWork {
  // ...
  
  public void doWork() {
    
  }
}
```

---

# Használata

```java
Trainer trainer = new Trainer("John Doe");
HasName hasName = trainer;
CanWork canWork = trainer;

System.out.println(trainer instanceof HasName); // true
System.out.println(trainer instanceof CanWork); // true
```

---

# Névütközés metódusoknál

* Névütközés: ugyanazon metódusnév két interfészből
* Azonos metódusfej - működik, azonos metódusnak számít
* Eltérő paraméterek - overloading
* Eltérő visszatérési érték - nem fordul le

