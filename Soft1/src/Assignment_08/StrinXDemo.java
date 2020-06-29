class StrinXDemo{
	public static void main(String [] args) {

		Out.print("\nConstructors---------------------------------");
		StrinX s1 = new StrinX();
		Out.print("\ns1: " + s1.toString());		// empty StrinX
			
		char [] hugo = {'H','u','g','o'};
		StrinX s2 = new StrinX(hugo);				// "Hugo"
		Out.print("\ns2: " + s2.toString());
	
		StrinX s3 = new StrinX(s2);					// also "Hugo"
		Out.print("\ns3: " + s3.toString());
		
		String str = null;
		StrinX s4 = new StrinX(str);				// ""
		Out.print("\ns4: " + s4.toString());
		
		str = " Boss";
		StrinX s5 = new StrinX(str);				// " Boss"
		Out.print("\ns4: " + s5.toString());
		
		
		Out.print("\nLENGTH---------------------------------");
		Out.print("\nlength: " + s2.length());		// 4
		
		Out.print("\nSUBSTRING---------------------------------");
		StrinX s6 = s2.substring(2,4);							// "go"
		Out.print("\nsubstring: " + s6 + "\n");
		
		Out.print("\nSUBSTRING---------------------------------");
		s6 = s2.substring(-1,9999);								// null
		Out.print("\nsubstring: " + s6 + "\n");

		Out.print("\nENDSWITH---------------------------------");
		char [] boss = {'B', 'o', 's', 's'};
		boolean found = s2.endsWith(boss);						// true
		Out.print("\nendsWith: " + s2+  " 'B', 'o', 's', 's' -> " + found + "\n");
		
		char [] bosx = {'B', 'o', 's', 'X'};
		found = s2.endsWith(bosx);								// false
		Out.print("\nendsWith: " + s2+  " 'B', 'o', 's', 'X' -> " + found + "\n");

		Out.print("\nCOMPARE---------------------------------");
		StrinX s7 = s2;				
		int comp = StrinX.compareTo(s2, s7);							// 0
		Out.print("\n COMPARE: " + s2 + " with " + s7 + "-> " + comp + "\n");
		
		StrinX a = new StrinX("A");
		StrinX b = new StrinX("B");		
		comp = StrinX.compareTo(a, b);									// -1
		Out.print("\n COMPARE: " + a + " with " + b + "-> " + comp + "\n");
		comp = StrinX.compareTo(b, a);									// 1
		Out.print("\n COMPARE: " + a + " with " + b + "-> " + comp + "\n");
		comp = StrinX.compareTo(b, null);								// 1
		Out.print("\n COMPARE: " + a + " with " + b + "-> " + comp + "\n");
		
		
	} 
} 
