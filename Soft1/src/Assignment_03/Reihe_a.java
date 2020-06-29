public class Reihe_a {
    public static void main(String[] args) {

        final long END = 10;        // max. REIHENWERT Out.print("\nVorgabe: 1 3 5 7 9 11 13 ...");
        
        Out.println("Vorgabe:    1 2 0 3 -1 4 -2 5 -3 6 -4");
        Out.print("Generiert: ");

        long val = 1;               // REIHENWERT, der jeweils ausgegeben werden soll
        int z = 0;                  // Zählvarible

        while (val < END) {    
            if (z%2 == 0){          // Gerade Werde werden mit der Reihe subtrahiert    
                val = val - z;
            }
            else {                  // Ungerade Werte werden mit der Reihe addiert    
                val = val + z;
            }
            z++;                                       
            Out.print(" " + val);
        }
        Out.print("\n");


    } // end main
} // end class