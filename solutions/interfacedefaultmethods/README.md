# Default interfész metódusok

## Elmélet

Az interfész utólagos módosításának az a veszélye, hogy az összes őt implementáló osztályt is módosítani kell. 
A Java 8 előtt ezt úgy lehetett megoldani, hogy új interfészt származtattunk a régiből, amely tartalmazta  
az új metódusfejet, és ettől kezdve eldönthettük, hogy ezt vagy a régit implementáljuk egy osztály által. 
A Java 8 bevezette a **default metódust**, amely nem csak a metódus fejét, de az alapértelmezett működését 
is tartalmazza. Ezeket a metódusokat el kell látnunk a **default módosítószóval**, és nem tehetjük mellé a 
`static`, a `final` és az `abstract` módosítók egyikét sem. Természetesen az implementáló osztály dönthet úgy, 
hogy felülírja ezt a működést, de ha nem teszi, akkor sincs probléma. Ezáltal a régebben írt osztályok is 
működőképesek maradnak. Amennyiben az interfészből újabb interfészt származtatunk, akkor az dönthet úgy, hogy:

- az eredeti default metódust meghagyja,
- absztrakttá teszi,
- illetve felül is írhatja másik default implementációval.

```java
public interface HasName {

    default String getName() {
        return "Anonymous";
    }
}

public interface HasUniqueName extends HasName { // absztrakttá teszi a getName metódust

    @Override
    String getName();
}

public interface CanGetNewName extends HasName { // meghagyja az eredeti getName metódust

    void setName(string newName);
}

public interface HasTwoNames extends HasName { // új implementációval látja el a getName metódust

    @Override
    default String getName() {
        return "John Doe";
    }
}
```

## Ellenőrző kérdések

* Miért vezették be a default interfész metódusokat?
* Milyen szabályok vonatkoznak a default interfész metódusokra?
* Leszármazott interfésznek milyen lehetőségei vannak a default interfész metódussal kapcsolatban?
* Milyen problémába futhatunk többszörös öröklődésnél, és hogyan lehet feloldani?

## Gyakorlati feladatok

Az `interfacedefaultmethods` csomagba dolgozz!

### Gyakorlati feladat - Ülések száma

Készíts a `seats` csomagban egy `Seat` interfészt, amelyben egyetlen metódus legyen: `int getNumberOfSeats()`! 
A metódusnak legyen egy alapértelmezett implementációja, adja vissza azt az értéket, hogy `5`! 
Írd meg a következő osztályokat: 

* A `FamilyCar` csak implementálja az interfészt, mást nem kell írni az osztályba.
* A `SportsCar` implementálja az interfészt, és írja felül a metódust oly módon, hogy a metódus itt `2`-t 
  adjon vissza!
* A `Car` osztálynak pedig legyen egy `String brand` és egy `int numberOfSeats` attribútuma, a konstruktora 
  pedig állítsa be ezek értékét! Az osztály implementálja az interfészt és írja felül annak metódusát úgy, hogy 
  az a `numberOfSeats` attribútum értékét adja vissza!
  
Írj tesztet is mindhárom implementáció tesztelésére a `SeatTest` osztályban!

### Gyakorlati feladat - Négyzet alakú terítő

Készíts egy `cloth.Square` nevű interfészt, melyben a következő default metódusok vannak:

* `int getNumberOfSides()`: visszaadja egy négyzet oldalainak számát.
* `double getLengthOfDiagonal()`: az oldal hosszának ismeretében visszaadja a négyzet átlójának hosszát.
* `double getPerimeter()`: az oldal hosszának ismeretében visszaadja a négyzet kerületét.
* `double getArea()`: az oldal hosszának ismeretében visszaadja a négyzet területét.

Legyen az interfészben egy absztrakt `double getSide()` metódus is! A default metódusok ezt a metódust hívják 
meg a visszaadott értékeik kiszámolásához!

Legyen egy `TableCloth` osztály, amely implementálja ezt az interfészt, és van egy `double side` 
attribútuma, melynek értékét konstruktorban állítja be! A `getSide()` metódus ezt adja vissza!

Írj tesztet a `TableClothTest` osztályban a metódusok működésének ellenőrzésére!

### Gyakorlati feladat - Hosszú szó

Hozz létre a `test` ág `resources` könyvtárában egy `longword.txt` nevű fájlt, a következő 
tartalommal (használhatsz más szót is, másmilyen mátrixban megadva):

```text
LONG
ONGW
NGWO
GWOR
WORD
```

Hozz létre egy `longword.FileOperations` interfészt, amely tartalmaz egy default metódust (`default List<String> readFromFile(Path path)`), 
amelyben beolvassa a file tartalmát! Legyen az interfészben egy absztrakt metódus is: `String getLongWord()`!
A `longword.LongWord` osztály implementálja az interfészt, és a `getLongWord()` metódusa adja vissza a mátrixban rejlő 
szót! (A szó többféle módon és irányban is kiolvasható a mátrixból, pl. az első sort és a többi sorok utolsó betűjét 
egymás után olvasva, de  más megoldás is jó lehet.)

A `LongWordTest` osztályban írd is meg a tesztesetet a metódus működésének ellenőrzésére!
