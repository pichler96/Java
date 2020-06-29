/**
 * Aufgabe 1: "Alle geraden Zahlen" [10 Minuten]
 */
class GeradeZahlen {
    public static void main(String[] args) {
        Out.print("Untergrenze: ");
        int untergrenze = In.readInt();

        Out.print("Obergrenze: ");
        int obergrenze = In.readInt();

        while (untergrenze<=obergrenze) {
            untergrenze ++;
            if (untergrenze%2 == 0) {
                Out.println(untergrenze);  
            }
        }
    }  // end main  
} // end


