
class TextAnalyser {
    public static void main(String[] args) {
        Out.print("\nText-Analyser"); 
        Out.print("\n=============\n");
        
        // Eingabe des Texts
        Out.print("\nBitte zu analysierenden Text eingeben: ");
        char [] text = readTextAsCharArray();
        
        // Eingabe des AnalyseTexts 
        Out.print("\nBitte Analyse Text eingeben: "); 
        char [] analyseChars = readTextAsCharArray();

        // Eingabe ob case Sensitive
        Out.print("\nGross- / Kleinschreibung beachten: "); 
        boolean caseSensitive = In.readBoolean();

        // Ausgabe des Texts (A)
        printText(text, analyseChars, caseSensitive);

        // Analyse des Texts (B)
        int[] analysisResults;
        analysisResults = analyseText(text, analyseChars, caseSensitive);

        // Ausgabe des Analyse-Ergebnisses (C) 
        printAnalysis(analyseChars, analysisResults, caseSensitive);

    } // end main


    static char [] readTextAsCharArray() { 
        String text = In.readString();
        if (text == null) return null;
        if (text.length() <= 0) return null; 
        return text.toCharArray();

    }   // end readtextAsCharArray


    static void printText(char[] text, char[] analyseChars, boolean caseSensitive) {
        if (text == null) return;
        if (text.length <= 0) {
            Out.println("--- keine gueltigen Analyse-Daten ---");
            return;
        }

        if (analyseChars == null) return;
        if (analyseChars.length <= 0) {
            Out.println("--- keine gueltigen Analyse-Daten ---");
            return;
        }

        // Print text
        for (int i = 0; i < text.length; i++) {
            Out.print(text[i]);
        }
    
        // Print analyse
        Out.println("\n    wird bzgl.");
        for (int i = 0; i < analyseChars.length; i++) {
            Out.print(analyseChars[i]);
        }

        //Print sensitive
        Out.print("\n    analysiert (");
        if(caseSensitive){
            Out.println("case sensitive)!"); 
        } else {
            Out.println("case insensitive)!"); 
        }

    } //end printText


    static int[] analyseText(char[] text, char[] analyseChars, boolean caseSensitive){
        if (text == null) return null;
        if (analyseChars == null) return null;
   
        char[] lowerAnalyseChars = new char[analyseChars.length];
    
        // Count the maching charcters
        int[] analyse  = new int[analyseChars.length];
        int z = 0;

        for (int i = 0; i < analyseChars.length; i++) {
            for (int j = 0; j < text.length; j++) { 
                if (caseSensitive == false){
                    text[j] = Character.toLowerCase(text [j]);                       //Convert text to LowerCase
                    lowerAnalyseChars[i] = Character.toLowerCase(analyseChars [i]);  //Convert analyseChars to LowerCase
                    if (lowerAnalyseChars[i] == text[j]) z++;                        //Count the maching charcters caseinsentive
                } else{
                    if (analyseChars[i] == text[j]) z++;                             //Count the maching charcters casesentive
                }
            }
            analyse[i] = z; 
            z = 0;
        }
        return analyse;

    } // end analyseText


    static void printAnalysis(char[] analyseChars, int[] analysisResults, boolean caseSensitive) {
        if (analysisResults == null) {
            Out.println("--- keine gueltigen Analyse-Daten ---");
            return;
        }
        if (analyseChars == null) {
            Out.println("--- keine gueltigen Analyse-Daten ---");
            return;
        }

        // Print sensitive
        Out.print("\n\nAnalyse (");
        if(caseSensitive){
            Out.println("case sensitive)"); 
        } else {
            Out.println("case insensitive)"); 
        }

        // Print Analyse
        Out.println("-------------------------"); 
        for (int i = 0; (i < analyseChars.length) && (i < analysisResults.length); i++) {
            Out.println(analyseChars[i] + ": " + analysisResults[i]);
        }

    } // end printAnalysis


} // end TextAnalyser