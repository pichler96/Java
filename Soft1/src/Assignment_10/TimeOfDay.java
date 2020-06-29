class TimeOfDay {
	// ATTRIBUTES ---
	private int time;					// time in seconds
	
	// CONSTRUCTORS ---
	public TimeOfDay (int h, int m) {
		if (h<0) h = h * -1;		// make positive
		if (h>=24) h = h % 24;		// make it one day
		if (m<0) m = m * -1;		// make positive
		if (m>60) m = m % 60;		// make it an hour
		time = h * 60 + m;			// convert to seconds
	}

	public TimeOfDay(TimeOfDay t) {
		if (t != null) this.time = t.time;
		else this.time = 0;			// make 0:00
	}
	
	public TimeOfDay() {
		this(0,9);
	}
	
	
	// METHODS ---
	public int minBetween(TimeOfDay t) {
		if (t == null) return -1;
		int diff = t.time - this.time;
		return diff;
	}
	
	public String toString() {
		String hour = ""+(time/60);
		if (hour.length() < 2) hour = "0"+hour;
		String min = ""+(time%60);
		if (min.length() < 2) min = "0"+min;
	
		return hour + ":" + min;
	}
	
}
