public class Appointment {
    // Attributes
    private int ID;
    private static int lastID = 1;
    private ParticipantsNode head;		// start of list

    private String name;
    private Date day;
    private TimeOfDay start;
    private TimeOfDay end;

	private Appointment next;
    private Appointment prev;


    // Constructors
    public Appointment(String name, Date day, TimeOfDay start, TimeOfDay end) {
        if (name == null) return;
        this.name = name;

        this.day = day;
        if (day == null) this.day = new Date(1900, 1, 1);

        this.start = start;
        if (start == null) this.start = new TimeOfDay(0,0);
        
        this.end = end;
        if (end == null) this.end = this.start;

        if(this.start.minBetween(this.end) < 0) {
            this.start = this.end;
            this.end = start;
        }
       
        head = null;

        ID = lastID;
        lastID++;
    }

    // Methods
    public int getID() {
        return ID;
    }

    public Date getDate() {
        return day;
    }

    public TimeOfDay getBegin() {
        return start;
    }

    public TimeOfDay getEnd() {
        return end;
    }

    public String getDescription() {
        return name;
    }

    public int duration() {
        return start.minBetween(end);
    }
    
    public void alterDescription(String description) {
        name = description;
    }

    public boolean addParticipant(String mail) {
        if (mail == null) return false;
        if(mail.indexOf("@") == -1) return false;
        if (content(mail)) return false;

        // Node erzeugen
        ParticipantsNode n = new ParticipantsNode(mail);

        // Node einhängen
        n.setNext(head);
        head = n;

        return true;
    }

    private boolean content(String s) {
        if (s == null) return false;

        ParticipantsNode n = head;

        while (n != null) {
            if(n.hasNote(s)) return true;
            n = n.getNext();
        }
        return false;
    }

    public boolean removeParticipant(String mail) {
        if (mail == null) return false;

        ParticipantsNode c = head;
        ParticipantsNode p = null;

        while (c!= null && !mail.equals(c.getNote())) {
            p = c;
            c = c.getNext();
        }
        if (c == null) return false;

        ParticipantsNode n = c.getNext();
 
        // Von p den nächsten setzen oder head setzen
        if (p != null) p.setNext(n);
        else head = n;

        // c löschen
        c.setNext(null);

        return true;
    }

    public String toString() {
        String Participants = "";
        ParticipantsNode n = head;

        while(n != null) {
            Participants = Participants + n.toString();
            n = n.getNext();
        }
        return day.toString() + " " + start.toString() + "-" + end.toString() + " \"" + name + "\" " + "(" + duration() + " min) :" + Participants;
    }

    public int compareTo(Appointment a) {
        if(day.compareTo(a.getDate()) > 0) return -1;
        if(day.compareTo(a.getDate()) < 0) return 1;
        if(start.minBetween(a.getBegin()) > 0) return -1;
        if(start.minBetween(a.getBegin()) < 0) return 1;
        return 0;
    }

    // List

	public Appointment getNext() {
		return next;
    }

	public void setNext(Appointment n) {
		next = n;
    }  

    public void setPrev(Appointment n) {
		prev = n;
    }  
}