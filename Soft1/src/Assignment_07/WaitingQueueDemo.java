class WaitingQueueDemo {
    public static void main(String [] args) {
        // Wartenummern-Automat fuer die Feinkost.
        // Hoechste zu vergebende Nummer: 3, dh. max. 3 Wartende moeglich 

        WaitingQueue feinkost = new WaitingQueue("Feinkost", 3);
        Out.print("\nYour waiting number: " + feinkost.getWaitingNumber());         // Wartenummer 1, 1 Wartender
        Out.print("\nYour waiting number: " + feinkost.getWaitingNumber());         // Wartenummer 2, 2 Wartende
        Out.print("\nSize of queue: " + feinkost.queueSize());                      // 2
        Out.print("\nYour waiting number: " + feinkost.getWaitingNumber());         // Wartenummern 3, 3 Wartende
        Out.print("\nSize of queue: " + feinkost.queueSize());                      // 3

        int waitingNo = feinkost.getWaitingNumber();                                // -1, weil kein Platz mehr in Warteschlange
        if (waitingNo == -1 ) Out.print("\nSorry no more slots at the moment");     // true
        Out.print("\nSize of queue: " + feinkost.queueSize());                      // 3
       
        int nextToBeServiced = feinkost.call();                                     // liefert 1
        if (!feinkost.isTurn(2)) Out.print("\nNot your turn: 2");                   // liefert false, Wartende 3
        
        if (feinkost.isTurn(nextToBeServiced)) {                                    // liefert true
            Out.print("\nNow servicing: " + nextToBeServiced);
            feinkost.service();                                                     // Wartende 2
        }                                                       
        Out.print("\nSize of queue: " + feinkost.queueSize());                      // 2

        waitingNo = feinkost.getWaitingNumber();                                    // 1, weil wieder Platz in Warteschlange; auf 3 folgt 1
        Out.print("\nYour waiting number: " + waitingNo);                           // 1

        // Wartenummern-Automat fuer die Feinkost.
        // Hoechste zu vergebende Nummer: 10, dh. max. 10 Wartende moeglich 

        WaitingQueue kaese = new WaitingQueue("Kaese-Theke", 10);
        if (kaese.service()== false) Out.print("\nNo one to service");                  // true

    } // end main()
} // end class WaitingQueueDemo