class Date {
	// Repraesentiert Datum seit 1.1.1900

	// ATTRIBUTES ---
	private int year = 0;		// jedes Datum hat ein Jahr
	private int month = 0;		// jedes Datum hat ein Monat
	private int day = 0;		// jedes Datum hat einen Tag

	// CONSTRUCTORS ---
	
	Date() {
		year = 1900;
		month = 1;
		day = 1;
	} // end Datum
	
	Date(int aYear, int aMonth, int aDay) {
		year = aYear;
		month = aMonth;
		day = aDay;
		if (!isValidDate()) {
			year = 1900;
			month = 1;
			day = 1;
		}
	} // end Datum

	
	// METHODS ---
	
	// int compareTo(Date d)  
	public int compareTo(Date d) {
		if (d == null) return 1;
		return d.nrDaysBetween(this);
	}
	
	// String toString()
	public String toString() {
		return year + "/" + month + "/" + day;
	} // end toString()
		
		
		
		
		
		
		
		
		
		

	// private methods ---
	
	// is ValidDate() -------------------------------------------------------------
	private boolean isValidDate() {		
		boolean isValid = true;		// lokale Variable der Methode 
		if (year < 1900) { isValid = false; }; 							// Jahr gueltig?!
		if ((month < 1) || (month > 12))  { isValid = false; };   		// Monat gueltig?!
		if (day > maxDaysOfMonth()) { isValid = false; }; 	    		// Tag gueltig?!
		return isValid;
	} // end isValidDate()

	// maxDaysOfMonth() -----------------------------------------------------------
	private int maxDaysOfMonth() {
		int maxDaysOfMonth = 0;	// lokale Variable der Methode
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:  		// Months with 31 days
				maxDaysOfMonth = 31; break;
			case 4: case 6: case 9: case 11:								// Months with 30 days
			   maxDaysOfMonth  = 30; break;
			case 2:															// Month of FEBRUARY
				if (isShiftYear()) { maxDaysOfMonth = 29; } else { maxDaysOfMonth = 28;}
				break;
		} // end case
		return maxDaysOfMonth;
	} // end maxDaysOfMonth()

	// isShiftYear() ---------------------------------------------------------------
	private boolean isShiftYear() {
		if ((((year % 4) == 0) && ((year % 100) != 0) ) || ((year % 400) == 0) ) return true;
		else return false;
	} // end isShiftYear()

	// numberOfDaysSince() ---------------------------------------------------------
	private int numberOfDaysSinceYear(int sinceYear) {
	   if (year < sinceYear) return -1; 			// not possible

	   int numberYears = year - sinceYear;
	   int numberShiftYears = (numberYears-1) / 4;
	   int numberShiftYearhundrets = (numberYears-1) / 100;
	   int numberShiftYear4Hundreds = (300+(numberYears-1)) / 400;

	   int numberOfDaysSince = (numberYears*365) 
			+ numberShiftYears 
			- numberShiftYearhundrets 
			+ numberShiftYear4Hundreds 
			+ numberOfDaysInYear();
			
	   return numberOfDaysSince;
	} // end numberOfDaysSince()

	// numberOfDaysSince1900() ---------------------------------------------------------
	private int numberOfDaysSince1900() {
		return numberOfDaysSinceYear(1900);		
	} // end numberOfDaysSince()

	// numberOfDaysInYear() ------------------------------------------------------------
    private int numberOfDaysInYear() {
		int numberOfDaysInYear = 0;
		int switchDay = 0;
		if (isShiftYear()) switchDay = 1;
		switch (month) {							// days of passed full months
			case 12: numberOfDaysInYear = numberOfDaysInYear + 30;  // NOV
			case 11: numberOfDaysInYear = numberOfDaysInYear + 31;  // OCT
			case 10: numberOfDaysInYear = numberOfDaysInYear + 30;  // SEP
			case 9:  numberOfDaysInYear = numberOfDaysInYear + 31;  // AUG
			case 8:  numberOfDaysInYear = numberOfDaysInYear + 31;  // JUL
			case 7:  numberOfDaysInYear = numberOfDaysInYear + 30;  // JUN
			case 6:  numberOfDaysInYear = numberOfDaysInYear + 31;  // MAY
			case 5:  numberOfDaysInYear = numberOfDaysInYear + 30;  // APR
			case 4:  numberOfDaysInYear = numberOfDaysInYear + 31;  // MAR
			case 3:  numberOfDaysInYear = numberOfDaysInYear + 28 + switchDay; // FEB 
			case 2:  numberOfDaysInYear = numberOfDaysInYear + 31;  // JAN
			case 1:  numberOfDaysInYear = numberOfDaysInYear + 0; // im JAN
		} // end case
		numberOfDaysInYear = numberOfDaysInYear + day;
		return numberOfDaysInYear;
    } // end numberOfDaysInYear()
	
	private int nrDaysBetween(Date d) {
		if (d == null) return -1;
		return this.numberOfDaysSince1900()-d.numberOfDaysSince1900();
	} // end nrDaysBetween()
	/*
	private boolean before(Date d) {
		if (d == null) return false;
		return ((this.numberOfDaysSince1900()-d.numberOfDaysSince1900())<0);
	} // end before()
	*/


} // end class Date
