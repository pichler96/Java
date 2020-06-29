public class Schedule {
    // Attributes
    private String name;
    private Appointment head;		// start of list
    private int anz;

    // Constructors
    public Schedule(String name) {
        if (name == null) name = "Calendar";
        else this.name = name;
        
        head = null;
    }

    // Methods
    public int schedule (Date d, TimeOfDay b, TimeOfDay e, String desc) {
        if (d == null) return -1;
        if (b == null) return -1;
        if (e == null) return -1;
        if (desc == null) return -1;

        // Termin erzeugen 
        
        Appointment n = new Appointment(desc, d, b, e);
        anz++;

        //Termine sollen dabei nach ihrem Beginn (also Datum und Startzeitpunkt) sortiert gehalten werden

		Appointment c = head;
		Appointment p = null;
		while (c != null && c.compareTo(n) < 0) {
			p = c;
			c = c.getNext();
		}
		
		// refer from n
		n.setPrev(p);
		n.setNext(c);
		
		// refer to n
		if (c != null) c.setPrev(n);
        if (p != null) p.setNext(n); else head = n;

        return n.getID();
    }

    public boolean remove (int id) {

        Appointment c = head;
        Appointment p = null;

        while (c!= null && id != c.getID()) {
            p = c;
            c = c.getNext();
        }
        if (c == null) return false;

        Appointment n = c.getNext();
 
        // Von p den nächsten setzen oder head setzen
        if (p != null) p.setNext(n);
        else head = n;

        // c löschen
        c.setNext(null);

        return true;
    }

    public boolean addParticipant(int id, String eMail) {
        Appointment n = head;

        while(n != null && id != n.getID()) {
            n = n.getNext();
        }
        if (n == null) return false;
        if (eMail == null) return false;

        return n.addParticipant(eMail);
    }

    public boolean removeParticipant(int id, String eMail) {
        Appointment n = head;

        while(n != null && id != n.getID()) {
            n = n.getNext();
        }
        if (n == null) return false;
        if (eMail == null) return false;

        return n.removeParticipant(eMail);
    }

    public int noAppointments() {
        return anz;
    }

    public String toString() {
        String AppointmeentStr = "";
        Appointment n = head;

        while(n != null) {
            AppointmeentStr = AppointmeentStr + "\n" + n.toString();
            n = n.getNext();
        }
        
        return name + "\n--------------------------------------" + AppointmeentStr + "\n";
    }
}