class FindText {
	public static void main(String [] args) {
		char[][] textField = {{'k','H','j','k','H','U','m','n','H','b'},
							  {'h','h','U','k','l','U','m','n','a','b'},
							  {'o','p','q','k','s','k','G','u'},
							  {'v','w','x','y','O','a','b','O','d'},
							  {'v','w','x','y','z','a','b','O','O'},
							  {},
							  null};
							  
		char[] searchText = {'H','U','G','O'};
		
		Out.print("\nText-Feld:\n--------------------------------\n");
		print(textField);
		Out.print("\n--------------------------------\n");
		print(searchText);
		
		if (findText(textField, searchText)) {
			Out.print("\nkommt vor!");
		} else {
			Out.print("\nkommt nicht vor!");
		}

	} // end main
	
	
	static boolean findText(char[][] texts, char[] searchText) {
	if(texts == null) return false;
	if(searchText == null) return false;
	int searchResult = 0;
	
		for (int i = 0; i < texts.length && i < searchText.length; i++) {
			if (texts[i] != null) {
				
				// Search the fist Char
				for (int j = 0; (j + 1 < texts[i].length) ; j++) {
					if (texts[i][j] == searchText[i]) {
						searchResult = 1 + findChar(texts, searchText, j + 1);
					}	
					if (searchResult == searchText.length){
						return true;
					}
					searchResult = 0;
				}
			}
		}
		return false;

	} // end findText()



	static int findChar(char texts[][], char searchText[], int savepos) {
		int searchResult = 0;

		for (int i = 1; i < searchText.length; i++) {
			if ((savepos < texts[i].length) && (texts[i][savepos] == searchText[i])) {  	
				searchResult++;
				savepos++;
			}	
		}
		return searchResult;

		} // end findText()

	static void print(char[][] texts) {
		if (texts == null) return;
		for (int i = 0; i < texts.length; i++) {	
			if (texts[i] != null) print(texts[i]);
			Out.print("\n");
		}
	} // end  printTexts()

	static void print(char [] text) {
		if (text == null) return;
		for (int i = 0; i < text.length; i++) {	
				Out.print(text[i]);
		}
	} // end printText()
	
} // end class FindText