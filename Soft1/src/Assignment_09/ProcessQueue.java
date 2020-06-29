class ProcessQueue {
    // Attributes
    private String name;
    private int size;
    private int curr;
    private Process[] processes;
    private final int DEFAULTSIZE = 3;

    // Constructors
    public ProcessQueue(String name, int size) {
        if (name == null) this.name = "unnamed";
        else this.name = name;

        if(size <= 0) this.size = DEFAULTSIZE;
        else this.size = size;
        
        curr = 0;
        processes = new Process[this.size];
    }

    // Methods
    public boolean schedule (Process p){
        if (p == null) return false;
        if (size - curr < 1) return false;

        processes[curr++] = p;
        return true;
    }

    public Process getProcess(int n) {
        for (int i = 0; i < processes.length; i++) {
            if (processes[i] != null) {
                if(n == processes[i].processNo()) return processes[i];
            }
        }
        return null;
    }

    public Process processNext() {
        curr--;
        if (curr < 0) {
            curr = 0;
            return null;
        }
        if (processes[curr] == null) return null;
        Process processNext =  processes[curr];
        processes[curr] = null;
        return processNext;
    }

    public int nrProcesses() {
        return curr;
    }

    public int duration() {
        int duration = 0;
        for (int i = 0; i < processes.length; i++) {
            if (processes[i] != null) {
                duration = duration + processes[i].duration();
            }
        }
        return duration;
    }

    public void print() {
        Out.print("\n" + toString());						// prints the item
    }

    public String toString() {
		StringBuffer s = new StringBuffer("'" + name + "' --- " +nrProcesses() + " processes --- duration: " + duration()+"\n");
		for (int i = 0; i < curr; i++) {
			if (processes[i] != null) s.append(processes[i]+"\n");
		}
		return s.append("\n").toString();
	}
}

