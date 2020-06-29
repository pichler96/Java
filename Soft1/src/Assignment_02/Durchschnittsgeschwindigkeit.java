/**
 * Aufgabe 3: "Durchschnittsgeschwindigkeit" [40 Minuten]
 */
class Durchschnittsgeschwindigkeit {
    public static void main(String[] args) {
        Out.print("Strecke [km]: ");
        double km = In.readDouble();

        Out.println("Benötigte Zeit");
        Out.print("Stunden: ");
        int h = In.readInt();
        Out.print("Minuten: ");
        int min = In.readInt();

        int day = h/24;
        double speed = km/(h+min/60.0);

        //Ausgabe
        Out.print(km + " km in ");

        // Tag(en)
        if (day > 0) {
            h = h % 24;
            if (day > 1) {
                Out.print(day + " Tagen ");  
            } else {
                Out.print(day + " Tag ");   
            }
        }

        // Stunden
        if (h > 0) {
            Out.print(h + " Stunden ");  
        }

        // Minuten
        if (min > 0) {
            Out.print(min + " Minuten ");  
        }

        Out.println("\n entspricht einer Durchschnittsgeschwindigkeit von " + speed + " km/h");

    }  // end main  
} // end


