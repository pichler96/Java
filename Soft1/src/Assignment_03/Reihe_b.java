public class Reihe_b {
    public static void main(String[] args) {

        final long END = 100;              
        
        Out.println("Vorgabe:    1 2 3 5 8 13 21 34");
        Out.print("Generiert: ");

        long val = 1;                       // REIHENWERT, der jeweils ausgegeben werden soll
        long safeval = 1;
        long preval = 1;


        while (val <= END) { 
            Out.print(" " + val);    
            safeval = val;                   // die vorige Zahl wird abgespeichert
            val = val + preval;            // die Zahl wid mit der vorigen Zahl addiert

            preval = safeval;               
        } 
        Out.print("\n");     


    } // end main
} // end class