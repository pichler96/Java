class ProcessControllerDemo {
	public static void main(String  [] args) {
		
		// PROCESS
		Out.print("\n\n\nPROCESS ==================");

		// create
		Out.print("\n\ncreating new processes ...");
		Process p1 = new Process(null, new String[]{"print 'Hello'", "print 'World'"});
		Out.print("\n" + p1);
		Process p2 = new Process("Endlosschleife", new String[]{"while (true) do nothing"});
		Out.print("\n" + p2);
		Process p3 = new Process("99 Bottles of Beer", new String[]{"for (int i = 99; i > 0; i--) do", 
																	"   print i + ' bottles of beer on the wall, '",
																	"   print i + ' bottles of beer.'",
																	"   print 'Take one down and pass it around, '",
																	"   print (i-1) + ' bottles of beer on the wall.'",
																	"end for"});
		Out.print("\n" + p3);
		  
		// duration
		Out.print("\n\ndetermining duration ...");
		Out.print("\n  Duration p1: " + p1.duration());
		Out.print("\n  Duration p2: " + p2.duration());
		Out.print("\n  Duration p3: " + p3.duration());
		
		// rename
		Out.print("\n\nrenaming  ...");
		p1.rename("Hello World");
		Out.print("\n" + p1);
		
		// changing code
		Out.print("\n\nupdating code of a processes ...");
		p1.insertLine(-1, "start");
		Out.print("\n" + p1);
		p1.insertLine(0, "begin");
		Out.print("\n" + p1);
		p1.insertLine(4, "goto (2)");
		Out.print("\n" + p1);
		
		p1.deleteLine(-1);
		Out.print("\n" + p1);
		p1.deleteLine(99);
		Out.print("\n" + p1);
		p1.deleteLine(3);
		Out.print("\n" + p1);
		
		
	
	
		Out.print("\n\n\n\n\n\n\n\n\n");
		
		// PROCESS QUEUE
		Out.print("\n\n\nPROCESS QUEUE ==============");		
		
		// create
		Out.print("\n\ncreating new process queues ...");
		ProcessQueue q1 = new ProcessQueue("ProcessQueue A", -1);
		Out.print("\n" + q1);
		ProcessQueue q2 = new ProcessQueue("ProcessQueue B",3);
		Out.print("\n" + q2);
		
		// schedule
		Out.print("\n\nscheduling processes ...");

		q1.schedule(p1);
		Out.print("\n" + q1);
		q1.schedule(p2);
		q1.schedule(p3);
		Out.print("\n" + q1);
		
		q2.schedule(p1);
		Out.print("\n" + q2);

		
		
		// getProcess
		Out.print("\n\ngetting processes ...");
		Process p4;
		p4 = q1.getProcess(0);
		Out.print("\n process #0 from q1: " + p4);
		p4 = q1.getProcess(1);
		Out.print("\n Process #1 from q1: " + p4);
		p4 = q1.getProcess(999);
		Out.print("\n process #999 from q1: " + p4);
		p4 = q2.getProcess(0);
		Out.print("\n process #0 from q2: " + p4);
		
		
		
		// processNext()
		Out.print("\n\nprocessing processes ...");
		Process p5;
		Out.print("\n" + q1);
		p5 = q1.processNext();
		Out.print("\n processing from q1: " + p5);
		p5 = q1.processNext();
		Out.print("\n processing from q1: " + p5);
		p5 = q1.processNext();
		Out.print("\n processing from q1: " + p5);
		Out.print("\n" + q1);
		
		
		
		Out.print("\n\n\n\n\n\n\n\n\n");
		
		// PROCESS CONTROLLER
		Out.print("\n\n\nPROCESS CONTROLLER ==============");		
		
		// create
		Out.print("\n\ncreating new process controller ...");
		ProcessController c1 = new ProcessController();
		Out.print("\n" + c1);
		ProcessController c2 = new ProcessController();
		Out.print("\n" + c2);
		
		// scheduling
		Out.print("\n\nscheduling processs in process controller ...");
		c1.schedule(p1, true);
		Out.print("\n" + c1);
		c1.schedule(p2, false);
		Out.print("\n" + c1);
		c1.schedule(p3, false);
		Out.print("\n" + c1);
	
		// nrProcesses
		Out.print("\n\nno processes in process controller ...");	
		Out.print("\n no of processes in c1: " + c1.nrProcesses());
		Out.print("\n no of processes in c2: " + c2.nrProcesses());
		
		// contains
		Out.print("\n\ncontains in process controller ...");	
		Out.print("\n c1 contains process #0: " + c1.contains(0));
		Out.print("\n c1 contains process #1: " + c1.contains(1));
		Out.print("\n c1 contains process #2: " + c1.contains(2));
		Out.print("\n c1 contains process #99: " + c1.contains(99));
		Out.print("\n c2 contains process #1: " + c2.contains(1));
	
	
		// insertLine / deleteLine
		Out.print("\n\ninserting / deleting lines of code of scheduled processes ...");	
		if (!c1.insertLine(0, -1, "prepare")) Out.print("->failed!");
		Out.print("\n" + c1);
		c1.deleteLine(0, 3);
		Out.print("\n" + c1);
		
		
		// processNext()
		Out.print("\n\nprocess next in process controller ...");	
		Out.print("\n" + c1);
		
		Process p6 = c1.processNext();
		Out.print("\n processing next from c1: " + p6);
		
		p6 = c1.processNext();
		Out.print("\n processing next from c1: " + p6);
		
		p6 = c1.processNext();
		Out.print("\n processing next from c1: " + p6);
		
		p6 = c1.processNext();
		Out.print("\n processing next from c1: " + p6);
		Out.print("\n" + c1);
		

		
	}
}
	