/**
 * Paving
 */
class Paving {
    public static void main(String[] args) {
        int A = length('A');
        int B = length('B');
        int C = length('C');

        Out.print("\nWay: ");
        int way = In.readInt();

        // Berechne wie viele Platten benoetigt werden 
        int noPlates = noPlates(way);
        if (noPlates == -1) {
            Out.println("Weg der Laenge " + way + " mit Platten der Laenge " + A + ", " + B + " bzw. " + C + " nicht genau auslegbar!");
        } else {
            Out.println("Weg der Laenge " + way + " mit " + noPlates + " Platten der Laenge " + A + ", " + B + " bzw. " + C + " genau auslegbar!");
        }
    } // end main


    static int length(char plate) {
 
        if (plate == 'A') return 23;
        if (plate == 'B') return 37;
        if (plate == 'C') return 53;
        return 0;
    } // end length


    static int noPlates(int way){
       
        int A = length('A');
        int B = length('B');
        int C = length('C');

        // keine Belegung möglich
        if (way < min(A,B,C)) return -1;
        
        // genaue Belegung möglich
        if (way == A) return 1;
        if (way == B) return 1;
        if (way == C) return 1; 
        
        // Kombination aus Belegungen
        return 1 + min(noPlates(way-A), noPlates(way-B), noPlates(way-C));
    } // end noPlates

    
    static int min (int x, int y, int z) {        
        if (x == -1 && y == -1 && z == -1) return  -2;   
        
        int minpos = Math.max(x, Math.max(y, z));            // Variable mit dem größtem Wert deklarieren

        if (x != -1) minpos = x;
        if (y != -1) minpos = Math.min(minpos, y);
        if (z != -1) minpos = Math.min(minpos, z);
        return minpos;
    } // end min
}