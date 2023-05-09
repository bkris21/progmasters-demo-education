# Statikus interfész metódusok

## Elmélet

Az interfészben definiálhatunk statikus metódust is, amelyet mindig implementálnunk kell. 
Ez csak publikus lehet, nem látható el a `default` módosítóval, és nem öröklődik. 
Kizárólag az interfész nevével minősítve hívható.

A cél az, hogy az interfészbe helyezzük el azokat a metódusokat, amelyek az interfészt implementáló osztályok
különböző példányain dolgoznak, ne pedig egy különálló osztályba. Ilyen metódus például a `List.of()` mely az 
átadott elemek listájával tér vissza, függetlenül a konkrét lista implementációtól. Ez gyakorlatilag 
kiváltja a régóta meglévő `Arrays.asList()` metódust, mely egy olyan konkrét osztály 
statikus metódusa, amelynek semmi köze nincs a listákhoz.

> A videóban elhangzó `List.of()` metódus a Java 9-es verziójában jelent meg.
> A Java 9 óta megengedett a privát statikus interfész metódus is.

A videóban szereplő példa a statikus interfész metódusra:

```java
public interface Audited {

    LocalDateTime getCreatedAt();

    static Audited findLastCreated(List<Audited> values) {
        Audited last = values.get(0);
        for (Audited actual : values) {
            if (actual.getCreatedAt().isAfter(last.getCreatedAt())) {
                last = actual;
            }
        }
        return last;
    }
}
```

Ezt a következőképpen tudjuk meghívni, az interfész nevével minősítve és paraméterként 
természetesen a megfelelő `List<Audited>` típusú listát átadva: 

```java
Audited.findLastCreated(values)
```
 
## Ellenőrző kérdések
 
* Hogyan definiálhatunk statikus interfész metódust? 
* Hogyan lehet az ilyen metódust meghívni?

## Gyakorlati feladatok

Az `interfacestaticmethods` csomagba dolgozz!

### Gyakorlati feladat - Iskolások

Készíts egy `schoolchild.PrimarySchoolChild` nevű interfészt és osztályokat, amelyek ezt az interfészt implementálják: 
`LowerClassSchoolChild` és `UpperClassSchoolChild`! Ezeknek az osztályoknak a következő attribútumaik legyenek: 
`String name` és `int age`, valamint legyen ezekhez getter és setter metódus! Rendelkezzenek több, különféle paraméterezésű 
konstruktorral is!

Ezután készíts az interfészbe egy `static PrimarySchoolChild of(int age)` metódust, amelynek visszatérési 
értéke:

* egy újonnan példányosított `LowerClassSchoolChild` objektum, ha a paraméterként kapott életkor adat 6 és 10 között van, 
* egy újonnan példányosított `UpperClassSchoolChild` objektum, ha a paraméterként kapott életkor adat 11 és 14 között van,
* minden egyéb esetben pedig dobjon a metódus `IllegalArgumentException` kivételt a megfelelő üzenettel!

### Gyakorlati feladat - Kerekek

Készíts egy `vehicle.Vehicle` nevű interfészt és a következő osztályokat, amelyek ezt az interfészt implementálják:
`Bicycle` és `Car`! A bicikli attribútuma legyen: `int numberOfWheels`, és a konstruktora állítsa be 
ennek értékét! Az autónak attribútumai legyenek: `String brand` és `int numberOfWheels`, és legyen ezekhez 
getter és setter metódus! Legyen több, különféle paraméterezésű konstruktor is az osztályban!

Ezután készíts az interfészbe egy `static Vehicle of(int numberOfWheels)` metódust, amelynek visszatérési
értéke:

* egy újonnan példányosított `Bicycle` objektum, ha a paraméterként kapott szám 2,
* egy újonnan példányosított `Car` objektum, ha a paraméterként kapott szám 4,
* minden egyéb esetben pedig dobjon a metódus `IllegalArgumentException` kivételt a megfelelő üzenettel!