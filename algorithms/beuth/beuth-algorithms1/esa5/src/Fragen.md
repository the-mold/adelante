###--------------------------------
1. Ein Verein habe 756 Mitglieder, und auch in der Zukunft werde der Verein nicht mehr als 1000 Mitglieder haben. Eine Mitglieds-Nummer gebe es nicht.
Fur diesen Verein ist eine Mitglieder-Datei anzulegen. Die Mitglieder-Datei ist als eine Hashtabelle mit offener Adressierung und einem initialen Belegungsfaktor 
von 1/2 zu implementieren. Dabei sind die ersten funf Buchstaben des Nachnamens f ¨ ur das Hashing zu verwenden. Ist der Nachname ¨
kurzer, dann ist er durch Anh ¨ ¨angen von Blanks entsprechend zu verlangern. Das zugrunde liegende Alphabet bestehe dabei aus 26 Buchstaben und dem Blank, 
eine Unterscheidung zwischen Groß- und Kleinbuchstaben werde nicht gemacht.

a) Spezifizieren Sie eine Hashfunktion.
```
h(k) = (a * k1 + a^2 * k2 + a^3 * k3 + a^4 * k4 + a^5 * k5) mod m
```
wo a - ein konstanter Wert,
k1, k2, k3 ... kt, ki ∈ Σ einem Alpabet, 1 <= i <= t

Bitte sehen Sie die Klasse `Hashing` an, wo die Methode implementiert wurde.

b) Bestimmen Sie den aktuellen Belegungsfaktor.
n / m = α = 1 / 2
α = 1 / 2
m = 1000 * 2 = 2000
n / m = 1 / 2

c) Welche mittlere Länge hätten die Kollisionsketten, wenn zu Hashing mit geschlossener Adressierung ubergegangen werden wurde? 
α = n / m (laut Skript S.104)


###--------------------------------
2. Was geben in Java die folgenden Anweisungen aus?

a) 
System.out.println("11".hashCode() );
Ergebnis: 1568
Strings werden als Array von ASCII ints dargestellt. Dec ASCII Code für "1" ist 49.
Die Methode "hashCode" loopt durch diese int Array Repräsentation von dem String und überschreibt Ergebnis mit 
```
h = 31 * h + val[i]; 
```
Im Fall von "11":
- erste Schleife: h = 31 * 0 + 49 = 49
- zweite Schleife: h = 31 * 49 + 49 = 1568

b) 
System.out.println(new Integer(1000).hashCode() );
Ergebnis: 1000
Die Methode "hashCode" gibt den gleichen Wert zurück.

c) 
ArrayList<Integer> arl = new ArrayList<Integer>();
System.out.println(arl.hashCode() );
Ergebnis: 1
Methode `hashCode` loopt durch alle Elemente im ArrayList und assigniert Wert zum Ergebnis `hashCode`
```
hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
```
, wo `e.hashCode()` ist ein Hash von einem Element.
Für den leeren ArrayList wird deb standarten `hashCode` Wert = 1 von der Methode `hashCode` zurückgegeben.

d)
arl.add(1);
System.out.println(arl.hashCode() );
Ergebnis: 32
Liste mit einem Element:
hashCode = 31 * 1 + 1 = 32

e)
arl.add(1);
System.out.println(arl.hashCode() );
Ergebnis: 993

Liste mit zwei Elementen:
- erster Element:
hashCode = 31 * 1 + 1 = 32
- zweiter Element:
hashCode = 31*32 + 1 = 993


###--------------------------------
3. Implementieren Sie in java eine Klasse Spieler, die Spieler eines Computerspieles modellieren soll. Ein Spieler-Objekt 
hat einen Namen vom Typ String und eine Anzahl Punkte vom Typ int. Die Klasse soll einen Konstruktor mit zwei Parametern 
haben, um die Attribute zu initialisieren. Überschreiben Sie die Methode hashCode der Klasse Object. Achten Sie die
folgende Bedingung: wenn zwei Objekte im Sinne der Methode equals gleich sind, dann muss die Methode hashCode den gleichen 
Wert zurückgeben, siehe javadoc Kommentar der Methode hashCode. Begründen Sie Ihre Implementierungen. 

In der Klasse Spieler habe ich zwei Methoden implementiert `hashCode` und `equals`. Methode `hashCode` liefert den Hash basierend auf zwei Properties - `name` und `points`.
1. Wenn `hashCode` mehrmals auf das gleiche Objekt ausgeführt wird, ergibt sich den gleichen Hashwert.
2. Wenn zwei Objekte im Sinne von der Methode `equals` gleich sind, liefert die Methode `hashCode` den gleichen Wert für zwei Objekte.
Die beiden Bedingungen habe ich in der Methode `main` getestet.
