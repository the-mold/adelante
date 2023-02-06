2- Geben Sie Zeitkomplexität der Methoden top, pop, push, toString und equals in
asymptotischer Notation an, und begrunden Sie Ihre Antwort.

a) top()
Komplexität: 
O(1), für alle möglichen Listen. Anweisung wird immer nur einmal ausgeführt. 

b) pop()
Komplexität: 
O(1), für alle möglichen Listen. Anweisung wird immer nur einmal ausgeführt. 

c) push()
Komplexität: 
O(1), für alle möglichen Listen. Anweisung wird immer nur einmal ausgeführt. 

d) toString()
Komplexität: 
O(1), wenn eine Liste leer ist oder es nur einen Element in der Liste gibt.
O(n), wenn es mehrere Elemente in der Liste gibt.

e) equals()
Komplexität: 
O(1), wenn die ersten Elemente in der Liste unterscheiden sich
      oder wenn die Liste, die als Parameter angegeben wird, nicht eine Instanz von der Klass VerketteterStapel ist
      oder wenn genau die gleiche Liste als Parameter angegeben wird.            
O(n), wenn jeder Element in den beiden Listen gleich ist
      oder wenn Elemente mit Index 'c'(wo c > 1) unterscheiden sich, was 'early exit' verursacht: O(n - c) ergibt => O(n)
