class Timer {
    // ATTRIBUTES
    long sec; 
    long secsave;

    // COSTRUCTORS
    Timer() {
        sec = secsave = 0;
    }

    Timer(long h, long min, long sec) {
        if(sec < 0|| sec > 60 || min < 0 || min > 60 || h < 0) {
            this.sec = secsave = 0;
        } else {
            this.sec = secsave = h*60*60 + min*60 + sec;
        }
    }

    // METHODS

    void reset() {
        sec = secsave;
    }

    boolean decrement(long sec) {
        if (this.sec-sec >= 0) {
            this.sec -= sec;
            return true;
        }
        return false;
    }

    boolean decrement(long min, long sec) {
        if(decrement(min*60+sec)) return true;
        return false;
    }


    boolean decrement(long h, long min, long sec) {
        if(decrement(h*3600+min*60+sec)) return true;
        return false;
    }

    boolean decrement(Timer t) {
        if(decrement(t.sec)) return true;
        return false;
    }

    int compareTo(Timer t) {
        return (int) (this.sec - t.sec);
    }

    int compareTo() {
        return (int) (this.sec);
    }

    Timer diff(Timer t) {
        long secdiff = this.sec - t.sec;
        if (secdiff < 0) secdiff = secdiff * -1;

        Timer diff = new Timer((secdiff/3600),(secdiff%3600)/60,(secdiff%3600)%60); 
        return diff;
    }

    static long diff(Timer t1, Timer t2) {
        long secdiff = t1.sec - t2.sec;
        if (secdiff < 0) secdiff = secdiff * -1;
        return secdiff;
    }

    String asText() {
        return "[" + sec/3600 + ":" + (sec%3600)/60 + ":" + (sec%3600)%60 + "]";
    }

}