public class StrinX {
    // Attributes
    private char[] text;

    // Constructors    
    public StrinX() {
        text = new char[0];
    }
    public StrinX(char[] c) {
        text = new char[c.length];
        if (c != null) {
            for (int i = 0; i < c.length; i++) {
                text[i] = c[i];
            }
        }
    }
    public StrinX(StrinX s) {
        this(s.text);
    }
    public StrinX(String s) {
        this();
        if (s != null) {
            text = new char[s.length()];
            text = s.toCharArray();
        }
    }


    // Methods
    public int length() {
        return toString().length();
    }

    public String toString() {
        return new String(text);
    }

    public StrinX substring(int beginIndex, int endIndex) {
        if(beginIndex < 0) return null;
        if(beginIndex > length()) return null;
        return new StrinX(toString().substring(beginIndex, endIndex).toCharArray());			
    }

    public boolean endsWith(char[] end) {
        return toString().endsWith(new String(end));
    }

    public static int compareTo(StrinX s1, StrinX s2) {
        if (s1 == null) return 1;
        if (s2 == null) return 1;
        return new String(s1.text).compareTo(new String(s2.text));
    }

}