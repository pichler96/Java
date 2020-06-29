class TimerDemo {
    public static void main(String[] args) {
        Out.print("\nCONSTRUCTORS ---------------------"); 
        Timer t1 = new Timer();
        Out.print("\nt1: " + t1.asText());

        Timer t2 = new Timer(24,0,0); 
        Out.print("\nt2: " + t2.asText());

        Timer t3 = new Timer(-1,0,0); 
        Out.print("\nt3: " + t3.asText());

        Timer t4 = new Timer(2,15,9); 
        Out.print("\nt4: " + t4.asText());

        Out.print("\nDECREMENT sec ---------------------"); 
        boolean b = t4.decrement(15*60+10);
        Out.print("\nt4: " + t4.asText()+ " Rueckgabewert:" +b);

        Out.print("\nDECREMENT min ---------------------"); 
        t4.reset();
        Out.print("\nt4: " + t4.asText());
        b = t4.decrement(16,10);
        Out.print("\nt4: " + t4.asText()+ " Rueckgabewert:" +b);

        Timer t5 = new Timer(1,0,0);
        Out.print("\nt5: " + t5.asText());
        b = t5.decrement(60*60);
        Out.print("\nt5: " + t5.asText()+ " Rueckgabewert:" +b);
        
        Out.print("\nDECREMENT h ---------------------"); 
        t4.reset();
        Out.print("\nt4: " + t4.asText());
        b = t4.decrement(1,16,10);
        Out.print("\nt4: " + t4.asText()+ "Rueckgabewert:" +b);

        t4.reset();
        Out.print("\nt4: " + t4.asText()); 
        b = t4.decrement(1*60*60+16*60+10); 
        Out.print("\nt4: " + t4.asText()+ "Rueckgabewert:" +b);

        Out.print("\nDECREMENT Timer ---------------------"); 
        t4.reset();
        Out.print("\nt2: " + t2.asText());
        b = t2.decrement(t4);
        Out.print("\nt2: " + t2.asText()+ "Rueckgabewert:" +b);

        Out.print("\nDIFF timer ---------------------"); 
        t4.reset();
        Out.print("\nt4: " + t4.asText());
        Timer t6= t2.diff(t4);
        Out.print("\nt6: " + t6.asText());

        Out.print("\nDIFF static ---------------------"); 
        t4.reset();
        Out.print("\nt4: " + t4.asText());
        long time = Timer.diff(t2, t4); 
        Out.print("\ntime in sec: " + time);

        Out.print("\nCompare timer ---------------------"); 
        t4.reset();
        Out.print("\nt4: " + t4.asText());
        int compareTime = t2.compareTo(t4); 
        Out.print("\ntime in sec: " + compareTime);
        
        // compareTo(Timer t), die es ermöglicht, die Zeit des Timers gegenüber dem übergebenen Timer-Objekt t zu vergleichen. 
        // Die Methode liefert einen positiven int-Wert, falls die Zeit des Timers grösser ist als die Zeit des Timers t, 
        // einen negativen Wert, wenn die Zeit des Timers kleiner ist als die Zeit des Timers t oder 0 falls beide Zeiten gleich sind. 
        // Ist t nicht gegeben wird ein positiver Wert zurück gegeben.

    } // end main()
}