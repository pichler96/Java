/**
 * Aufgabe 4: "Kaffeeautomat" [120 Minuten]
 */
class Kaffeeautomat {
    public static void main(String[] args) {
        Out.println("Kaffeeautomat");
        Out.println("=============");
        Out.println("a ... CAPPUCCINO 1.20 EUR");
        Out.println("b ... MOKKA 0.90 EUR");
        Out.println("c ... VERLAENGERTER 1.10 EUR");
        

        //Auswahl 
        Out.print("Bitte auswaehlen: ");
        char kaffee = In.readChar();
        double betrag = 0;
        
        while (!(kaffee == 'a' || kaffee == 'b' || kaffee == 'c')) {
            Out.println("   Bitte waehlen Sie erneut!");
            Out.print("Bitte auswaehlen: ");
            kaffee = In.readChar();
        }
        if (kaffee == 'a') {
            Out.println("\nGewaehlt CAPPUCCINO !"); 
            betrag = 1.20;
        }
        else if (kaffee == 'b') {
            Out.println("\nGewaehlt MOKKA !"); 
            betrag = 0.90;  
        } 
        else if (kaffee == 'c') {
            Out.println("\nGewaehlt VERLAENGERTER !");   
            betrag = 1.10;
        } 

        // Zahlvorgang
        while (betrag > 0) {
            Out.println("\nOffener Betrag: " + betrag); 
            Out.print("Bitte Betrag einwerfen: "); 
            int cent = In.readInt();
            while (!(cent == 10 || cent == 20 || cent == 50)) {
                Out.println("   Kein gueltiger Betrag!");
                Out.print("Bitte Betrag einwerfen: "); 
                cent = In.readInt();
            }
            betrag = betrag - (cent/100.00);
            // Runden auf zwei Nachkommastellen
            betrag = Math.round(betrag*100)/100.00;
        }

        // Zubereitung
        if (kaffee == 'a') {
            Out.println("\n\nBezahlt! CAPPUCCINO wird zubereitet!"); 
        }
        else if (kaffee == 'b') {
            Out.println("\n\nBezahlt! MOKKA wird zubereitet!"); 
        } 
        else if (kaffee == 'c') {
            Out.println("\n\nBezahlt! VERLAENGERTER wird zubereitet!"); 
        } 

        // Retourgeld
        if (betrag != 0) {
            betrag = betrag * (-1);
            int cent20 = (int) (betrag / 0.20);

            double rest = (betrag % 0.20);
            // Runden auf zwei Nachkommastellen 
            rest = Math.round(rest*100)/100.00;
            int cent10 = (int) (rest / 0.10);

            Out.println("Retourgeldbetrag: " + betrag); 
            Out.println("Retourgeldauswurf:"); 
            
            while (cent20>0) {
                Out.println("0.2"); 
                cent20--;
            }
            while (cent10>0) {
                Out.println("0.1"); 
                cent10--;
            }
        }
    


    }  // end main  
} // end


