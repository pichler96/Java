public class Map {
    // Attributes
    private final int DATASPACE = 2;
    private final int ADDDATASPACE = 1;
    private String[] keys = new String[DATASPACE];
    private String[] values = new String[DATASPACE];


    // Methodes

    private int search(String key) {
        for (int i = 0; i < keys.length; i++) {
            if(key.equals(keys[i])) return i;
        }
        return -1;
    }

    private String[] copy(String [] copy) {
        int offset = 0;

        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null) {                                                  // Copy only filled data
                copy[i-offset] = keys [i];
            } else {
                offset++;
            }
        }
        return copy;
    }

    public boolean add(String key, String value) {
        if (key == null) return false;
        if (value == null) return false;
        
        if(search(key) == -1) {                                                   // Check if key is in the map
            for (int i = 0; i < keys.length; i++) {                               // Search empty position in the array
                if(keys[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    return true;
                } 
            }
            String[] keys2 = new String[keys.length + ADDDATASPACE];             // Extending the Array         
            keys = copy(keys2);
            String[] values2 = new String[values.length + ADDDATASPACE];
            values = copy(values2);

            add(key,value);
                                                      
        } else {
            values[search(key)] = value;                                          // Change value from the key
        }
        return true;
    }

    public boolean del(String key) {
        if (key == null) return false;

        int index = search(key);
        if(index == -1) return false;

        keys[index] = null;
        values[index] = null;
        return true;
    }

    public String get(String key) {
        if (key == null) return null;

        int index = search(key);
        if(index == -1) return null;

        return values[index];
    }

    public int size() {
        int size = 0;

        for (int i = 0; i < keys.length; i++) {
            if(keys[i] != null){
                size++;
            }
        }
        return size;
    }

    public String[] keys() {
        String[] newkeys = new String[size()];
        return copy(newkeys);
    }

} // class map