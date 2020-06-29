public class Reihe_c {
    public static void main(String[] args) {

        final long END = 8192;        // max. REIHENWERT Out.print("\nVorgabe: 1 3 5 7 9 11 13 ...");
        
        Out.println("Vorgabe:    1 2 2 4 8 32 256 8192");
        Out.print("Generiert: ");

        long val = 1;                        // REIHENWERT, der jeweils ausgegeben werden soll
        long safeval = 1;
        long preval = 2;

     
        while (val <= END) { 
            Out.print(" " + val);    
            safeval = val;                    // die vorige Zahl wird abgespeichert
            val = val * preval;               // die Zahl wid mit der vorigen Zahl multipliziert

            preval = safeval;        
        } 
        Out.print("\n");              


    } // end main
} // end class