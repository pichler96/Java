/**
 * Aufgabe 2: "n-te Potenz von x" [30 Minuten]
 */
class Potenz {
    public static void main(String[] args) {
        Out.print("Basiszahl: ");
        int basiszahl = In.readInt();

        Out.print("Potenzzahl: ");
        int potenzzahl = In.readInt();

        int erg = 1;
        int p = potenzzahl;

        // Negative Potenzzahlen postiv machen
        if (potenzzahl < 0) {
            p = potenzzahl * (-1);
        }

        //Potenz berechnen
        while (p > 0) {
            erg = erg * basiszahl;
            p --;
        }

        //Ausgabe 
        Out.print(potenzzahl + "-te Potenz von " + basiszahl + " ist ");

        // Vorzeichen vor den Bruch 
        if (erg < 0){
            Out.print("-");
            erg = erg * (-1);
        }

        // Negative Potenzzahlen im Nenner 
        if (potenzzahl < 0) {
            Out.print("1/");
        }
        Out.println(erg);

    }  // end main  
} // end


