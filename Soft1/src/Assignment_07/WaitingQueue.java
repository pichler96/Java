class WaitingQueue {
    // ATTRIBUTES
    String section;
    int maxNumber;
    int waitingNumber;
    int numberInService;
   

    // COSTRUCTORS
    WaitingQueue(String section){
        this.section = section; 
        this.maxNumber = 99;
        this.numberInService = 1;
    }

    WaitingQueue(String section, int maxnumber){
        this.section = section; 
        this.maxNumber = maxnumber;
        this.numberInService = 1;
        if (maxnumber >= 99) {
            this.maxNumber = 99;
        }
    }

    // METHODS
    int getWaitingNumber() {
        waitingNumber ++;
        if (queueSize() > maxNumber) {
            waitingNumber --;
            return -1;
        }    
        if (waitingNumber > maxNumber) waitingNumber = 1;
        return waitingNumber;
    }

    int queueSize() {
        return waitingNumber - numberInService + 1;
    }

    int call() {
        if(queueSize() > 0) {
            Out.print("\nWartenummer " + numberInService + " ist an der Reihe!");
            return numberInService;
        }
        return -1;
    }

    boolean isTurn(int waitingNumber) {
        return this.numberInService  == waitingNumber;
    }

    boolean service() {
        if(queueSize() > 0) {
            numberInService++;
            return true;
        }
        return false;
    }
}