
public class ISBN {
    public static void main(String[] args) {
        Out.println("Pruefziffernberechnung");
        Out.println("=====================");

        Out.print("ISBN: ");
        char isbn = In.read();
        int summe = 0;

        // (1) Prüfziffer berechnen
        
        for (int i = 1; i <= 9 && isbn != '\n'; i++) {

            int zahl = isbn  - '0';                // Dezimal Zahl 
            summe = summe + zahl * i;              // ISBN - Summe

            isbn = In.read();                      // Nächste Ziffer einlesen
        }
        int pruefziffer =  isbn  - '0';             // Prüfziffer einlesen und in Dezimal Zahl umwandeln


        // (2) Prüfziffer vergleichen

        if (summe%11 == pruefziffer) {              // Divisionsrest == Prüfziffer
            Out.println("korrekt!");
        }
        else if(summe%11 == pruefziffer-30) {       //  Divisionsrest (10) == Prüfziffer (X) - 30
            Out.println("korrekt!");               //  Prüfziffer (X) Dec: (X = 88) - (0 = 48) = 40
        }
        else {
            Out.println("nicht korrekt!");
        }

    }
}