class ProcessController {
    // Attributes
    private ProcessQueue highProcesses;
    private ProcessQueue lowProcesses;
    private final int DEFAULTSIZE = 2;

    // Constrctors
    public ProcessController() {
        highProcesses = new ProcessQueue("highPriority", DEFAULTSIZE);
        lowProcesses = new ProcessQueue("lowPriority", DEFAULTSIZE*2); 
    }

    // Methods
    public boolean schedule(Process p, boolean x) {
        if (x) {
            return highProcesses.schedule(p);
        } else {
            return lowProcesses.schedule(p);
        }
    }

    public int nrProcesses() {
        return highProcesses.nrProcesses() + lowProcesses.nrProcesses();
    }

    public boolean contains(int number) {
        if(highProcesses.getProcess(number) != null) return true;
        if(lowProcesses.getProcess(number) != null) return true;
        return false;
    }

    public boolean insertLow (Process p) {
        return lowProcesses.schedule(p);
    }

    public Process processNext() {
        Process next = highProcesses.processNext();
        if (next == null) {
            next = lowProcesses.processNext();
        }
        return next;
    }

    public boolean insertLine (int number, int lineNo, String codeLine) {
        Process highProcess = highProcesses.getProcess(number);
        Process lowProcess = lowProcesses.getProcess(number);

        if (highProcess != null) {
            highProcess.insertLine(lineNo, codeLine);
            return true;
        }
        if (lowProcess != null) {
            lowProcess.insertLine(lineNo, codeLine); 
            return true;
        }
        return false;
    }

    public boolean deleteLine (int number, int lineNo) {
        Process highProcess = highProcesses.getProcess(number);
        Process lowProcess = lowProcesses.getProcess(number);

        if (highProcess != null) return highProcess.deleteLine(lineNo);
        if (lowProcess != null) return lowProcess.deleteLine(lineNo);
        return false;
    }

    public int duration() {
        return lowProcesses.duration() + highProcesses.duration();
    }

    public void print() {
        Out.print("\n" + toString());						// prints the item
    }

    public String toString()  {
		StringBuffer s = new StringBuffer();
		s.append("PROCESS CONTROLLER " + " --- " +(highProcesses.nrProcesses()+lowProcesses.nrProcesses()) + " processes ");
		s.append("--- duration: " + (highProcesses.duration()+lowProcesses.duration())+"\n");
		s.append(">"+highProcesses);
		s.append(">"+lowProcesses);
		return s.toString();
	}
} 