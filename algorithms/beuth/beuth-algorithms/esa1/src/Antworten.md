### Aufgabe 1.1.

## 1.1.1. Der Algorithmus werde mit TuermeHanoi(3, A, B, C) aufgerufen. Zeigen Sie den Ablaufdes Algorithmus mit einem Rekursionsbaum.

```
                                            ____TH(3, A, B, C)____
                                           /           |          \
                            TH(2, A, C, B)          ZS(A, C)        TH(2, B, A, C)
                           /       |      \                          /       |        \
              TH(1, A, B, C)    ZS(A, B)   TH(1, C, A, B)   TH(1, B, C, A)  ZS(B, C)  TH(1, A, B, C)
            /                                   |                  |                        |
         ZS(A, C)                            ZS(C, B)           ZS(B, A)                 ZS(A, C)
```


## 1.1.2. Implementieren Sie den Algorithmus in einer Klasse namens Rekursion. 
Bitte ausführen
```
javac RekursionTest.java
java RekursionTest
```

## 1.1.3. Wie viele Aufrufe gibt es?
```
n = 3: 7 Aufrufe
n = 4: 15 Aufrufe
n = 5: 31 Aufrufe
```

## 1.1.4 Verallgemeinern Sie Ihr Ergebnis aus Frage 3 für n in N. 
2^n - 1, fuer n ∈ N
Komplexitaet: O(2^n)

------------------------------------------------------------------

### Aufgabe 1.2.

## 1.2.1. Zeigen Sie den Ablauf des Algorithmus mit einer Liste.
```
1===
BinaeresSuchen(A, 9 999,     1, 10 001)
2===
BinaeresSuchen(A, 9 999, 5 002, 10 001)
3===
BinaeresSuchen(A, 9 999, 7 502, 10 001)
4===
BinaeresSuchen(A, 9 999, 8 752, 10 001)
5===
BinaeresSuchen(A, 9 999, 9 377, 10 001)
6===
BinaeresSuchen(A, 9 999, 9 690, 10 001)
7===
BinaeresSuchen(A, 9 999, 9 846, 10 001)
8===
BinaeresSuchen(A, 9 999, 9 924, 10 001)
9===
BinaeresSuchen(A, 9 999, 9 963, 10 001)
10===
BinaeresSuchen(A, 9 999, 9 983, 10 001)
11===
BinaeresSuchen(A, 9 999, 9 993, 10 001)
12===
BinaeresSuchen(A, 9 999, 9 998, 10 001)
13===
BinaeresSuchen(A, 9 999, 9 998, 9999)
```

## 1.2.2. Wie viele Aufrufe haben Sie schreiben müssen?
13

## 1.2.3. Welche Funktion von n, die Länge des Arrays, beschriebt am besten die Anzahl der Aufrufe, die Sie erhalten haben?
Am besten wird die Abhängigkeit durch `ld n` beschrieben. Normalerweise hat Binäre Suche Algorithmus 
die Komplexität von `O(log n)`.