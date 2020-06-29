class MapDemo{
	public static void main(String [] args) {

		Out.print("\nConstructors---------------------------------");
		Map map = new Map();
		Out.print("\nmap: " + map.toString());		// empty Map
			
		map.add("1", "A");							// 1,A is no contained
		Out.print("\nmap: " + map.toString());		// (1,A)
		
		map.add("2", "B");							// 2,B is no contained
		Out.print("\nmap: " + map.toString());		// (1,A)(2,B)
		
		map.add("2", "X");							// 2 is changes to X
		Out.print("\nmap: " + map.toString());		// (1,A)(2,X)
		
		map.del("1");
		Out.print("\nmap: " + map.toString());		// (2,X)
		
		map.add("3", "C");							// 3,C is no contained
		Out.print("\nmap: " + map.toString());		// (2,X)(3,C)
		
		Out.print("\nmap size: " + map.size());		// 2
		
		Out.print("\nmap get: " + map.get("2"));	// X
		Out.print("\nmap get: " + map.get("3"));	// C
		Out.print("\nmap get: " + map.get("1"));	// null
		Out.print("\nmap get: " + map.get(null));	// null
		
		String [] keys = map.keys();
		Out.print("\nmap keys: ");					
		for (int i = 0; i < keys.length; i++) {
			Out.print("\n   " + keys[i]);			// (2,X)(3,C)
		}

	} 
} 
