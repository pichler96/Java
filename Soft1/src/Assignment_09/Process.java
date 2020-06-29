class Process {
// Attrbutes
private int number;
private static int lastNumber = 0;
private String name;
private String[] code;

// Constructors
public Process(String name, String[] code) {
    number = lastNumber;
    lastNumber++;
    if (name == null) this.name = "Process #" + number;
    else this.name = name;
    this.code = code;
}

// Methods
public int processNo() {
    return number;
}

public boolean rename(String name){
    if (name != null) {
        this.name = name;
        return true;
    }
    return false;
}

public int duration() {
    return code.length;
}

public void insertLine(int lineNo, String codeLine) {
    if(codeLine == null) codeLine = "NOP";
    
    String[] code2 = new String[code.length + 1];
    if (lineNo <= 0) {
        code2[0] = codeLine;
        copy(1, 0, code2);
    } else if (lineNo > code.length) {
        copy(0, 0, code2);
        code2[code.length] = codeLine;
    } else {
        copy(0, 0, code2);
        code2[lineNo-1] = codeLine;
        copy(lineNo,lineNo-1,code2);
    }
    code = code2;
}

public boolean deleteLine(int lineNo){
    if(0 > lineNo || lineNo >= code.length) return false;
    
    String[] code2 = new String[code.length - 1];
    code[lineNo] = null;
    copy(0, 0, code2);
    code = code2;
    return true;
}

public void copy(int start, int offset, String[] tocopy) {
    for (int i = 0; i + offset < code.length; i++) {
        if (code[i+offset] != null) tocopy[start++] = code[i+offset];
    }
}

public void print() {
    Out.print("\n" + toString());						// prints the item
}

public String toString() {
    StringBuffer s = new StringBuffer("\n    #"+ number + " --- " + "'" + name + "'" +" --- ("+duration()+")");
    for (int i = 0; i < code.length; i++) {
        s.append("\n       "+i+ ". " + code[i]);
    }
    return s.toString();
}

} // end process
