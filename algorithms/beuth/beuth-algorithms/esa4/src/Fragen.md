#### 1- Erstellen Sie eine Klasse namens BinaererBaum <E>.

Lösung: Klasse wurde erstellt.


#### 2- Erstellen Sie eine Klasse namens BinaererSuchBaum <E extends Comparable<? super E>>.

Lösung: Klasse wurde erstellt.


#### 3- Geben Sie Reihenfolgen an. 
Lösung:
a) Reihenfolge von 10 Elementen, die einen Baum der Höhe 9 ergibt
[ 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 ]
```
            10
           9 
          8
         7
        ..
       1  
```
b) Reihenfolge von 10 Elementen, die einen Baum der Höhe 3 ergibt
[ 10, 8, 20, 5, 9, 1, 15, 25, 22, 30]
```
              10
          8        20        
        5  9     15    25
       1             22  30 
```


#### 4- Ergänzen Sie die Klasse BinaererBaum um eine rekursive Methode: height. 

Lösung: Methode wurde eingebaut. Beispiele wurden in `main` getestet.


#### 5- Ergänzen Sie die Klasse BinaererSuchBaum um eine Methoden: maxElement. 

Lösung: Methode `maxElement` wurde eingebaut. Der größte Wert liegt am rechtesten Position im Baum.
        Methode `minElement` wurde eingebaut. Der kleinste Wert liegt an am linkesten Position im Baum.
        
        
#### 6- Geben Sie Zeitkomplexität der Methoden.
 
Lösung:

a) insert
BC O(1): Knoten wird direkt unter dem `root` hinzugefügt.
WC O(h): Höhe des Baums. Algorithmus vergleicht immer nur einen Zweig des Baumes und der Knoten kann im schlechtesten Fall am Ende vom größeren Zweige hinzugefügt werden. Im degenerierten Baum gibt es n Knoten im Zweig.

b) search
BC O(1): wenn gesuchtes Element `root` ist.
WC O(h): Höhe des Baums. Im schlechtesten Fall(wenn Element im Baum nicht vorhanden ist oder am Ende des Baumes liegt) wird der größere von zwei Zweigen bis zum Ende durchgesucht. Im degenerierten Baum werden n Knoten durchgesucht.

c) height
BC O(1): wenn es nur den `root` Knoten gibt.
WC O(ld(n)): nur den größeren Zweig wird durchgeloopt. Im Fall mit degenerierten Baum, alle n Knoten werden durchgeloopt.

d) maxElement  
BC O(1): wenn es kein Element kleiner als `root` ist. `root.right` ist null.
WC O(h): Höhe des Baums. Das max Element ist das Element der am rechtesten im Baum liegt. Im degenerierten Baum gibt es n Knoten im Zweig. 
