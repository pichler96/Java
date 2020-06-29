/**
 * Convert
 */
class Convert {

    public static void main(String[] args) {
        
        Out.print("\nDezimal-Konverter");
        Out.print("\n=================");

        // Eingabe einer positiver Dezimalzahl
        int n = inputDecimal();

        // Eingabe des Zielsystems b=Binaer, o=Oktal, h=Hexadezimal
        char system = inputTargetSystem();

        // Konvertiere in Zielsystem
        String targetRepresentation = convertTo(n, system);
        // targetRepresentation: e.g. "A7BC", "10100", "2147"

        //Gib konvertierte Representation im entsprechenden Zielsystem aus
        Out.print("\n" + n + " im " + printTargetSystem(system) + " ist " + targetRepresentation + "\n");

    } // end main


    static int inputDecimal() {

        // Pruefung ob eine gueltige Zahl eingegeben wird
        Out.print("\nDezimalzahl: ");
        int n = In.readInt();
        while (n<0){
            Out.println("keine gueltige Dezimahlzahl!");
            Out.print("Dezimalzahl: ");
            n = In.readInt();
        }
        return n;
    } // end inputDecimal


    static char inputTargetSystem() {
        
        // Pruefung ob eine gueltige Targetsystem eingegeben wird
        Out.print("Zielsystem [b=Binaer, o=Oktal, h=Hexadezimal]: ");
        char system = In.readChar();
        while (!(system == 'b' || system == 'o' || system == 'h')){
            Out.println("keine gueltige Auswahl!");
            Out.print("Zielsystem [b=Binaer, o=Oktal, h=Hexadezimal]: ");
            system = In.readChar();
        }
        return system;
    } // end inputTargetSystem


    static String convertTo (int n, char system) {
        
        String zahl = "";

        // Bei einer Null wird ein String mit "0" zurückgegeben
        if (n == 0) return "0";
       
        // Umwandlung in das Zielsystem
        while (n > 0) {
           int rest = n % basisTargetSystem(system);  
           n = n/basisTargetSystem(system);
        
           char c = (char) (rest + '0'); // der rest wird in einen Char umgewandelt
           if (c > '9') {                
               c += 7;                   // die Zahlen 10-15 werden in A-F umgewandelt
           }

           zahl = c + zahl;             // String wird zusammengesetzt
        }
        return zahl;
    } //end convertTo


    static int basisTargetSystem (char system) {

        if (system == 'b') {
            return 2;
        }
        else if (system == 'o') {
            return 8;
        }
        else {
            return 16;
        }
    } // end basisTargetSystem


    static String printTargetSystem (char system) {

        if (system == 'b') {
            return "Binaer-System";
        }
        else if (system == 'o') {
            return "Oktal-System";
        }
        else {
            return "Hexadezimal-System";
        }  
    } // end printTargetSystem

}