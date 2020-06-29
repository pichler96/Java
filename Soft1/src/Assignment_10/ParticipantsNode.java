class ParticipantsNode {
	// ATTRIBUTES
	private ParticipantsNode next;
	private String mail;
	
	// CONSTRUCTOR
	public ParticipantsNode (String s) {
		next = null;
		mail = s;
	}
	
	// METHODS
	public ParticipantsNode getNext() {
		return next;
	}

	public void setNext(ParticipantsNode n) {
		next = n;
	}

	public boolean hasNote(String s) {
		if(s == null) return false;
		return s.equals(mail);
	}
	
	public String getNote(){
		return mail;
	}

	public String toString() {
		return " " + mail;
	}
}
