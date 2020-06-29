class ScheduleDemo {
	public static void main(String [] args) {
		Out.print("\n\nSCHEDULE DEMO ***********************************************\n");
		
		Out.print("\n\ncreating new schedule 'Lehre-Termine'");
		Schedule s = new Schedule("Lehre-Termine");
		Out.print("\nafter creeation: \n" + s);
		
		Out.print("\nscheduling appointments");
		int id1 = s.schedule(new Date(2020, 6, 1), new TimeOfDay (8, 00), new TimeOfDay(10, 00), "Einfuehrung in die Philosophie");
		int id2 = s.schedule(new Date(2020, 6, 1), new TimeOfDay (10, 00), new TimeOfDay(11, 30), "Vorlesung ESOFT");
		int id3 = s.schedule(new Date(2020, 6, 3), new TimeOfDay (14, 00), new TimeOfDay(15, 00), "Tutorium ESOFT");
		int id4 = s.schedule(null, new TimeOfDay(14, 00), new TimeOfDay(15, 00), "XXXXXXXXXXXXXXX");
		if (id4 < 0) Out.print("\nappointment could not be inserted due to invalid data for appointment!");
		Out.print("\n\nafter scheduling appoinments: \n" + s);
		
		Out.print("\n\nno appoinments: " + s.noAppointments() + "\n");
		
		Out.print("\ninserting participants");
		s.addParticipant(id1, "sepp@gmax.com");
		s.addParticipant(id2, "hugo@geeemail.com");
		s.addParticipant(id2, "bertha@heissmail.com");
		s.addParticipant(id2, "sepp@gmax.com");
		s.addParticipant(id3, "bertha@heissmail.com");
		s.addParticipant(id3, "sepp@gmax.com");
		if (!s.addParticipant(id3, "sepp@gmax.com")) Out.print("\nalready in list of participants!");
		
		Out.print("\nafter inserting participants: \n" + s);
		
		Out.print("\n\nremoving participants");
		s.removeParticipant(id1, "sepp@gmax.com");
		if (!s.removeParticipant(id1, "sepp@gmax.com")) Out.print("\nno longer in list of participants!");
		Out.print("\nafter removing participants: \n" + s);
		
		Out.print("\n\nremoving appointment");
		s.remove(id1);
		if (!s.remove(id1)) Out.print("\nno longer in list of appointments!");
		Out.print("\nafter removing appointment: \n" + s);
		
		
/* OUTPUT ********************************************************************************************************


SCHEDULE DEMO ***********************************************


creating new schedule 'Lehre-Termine'
after creeation:
Lehre-Termine
-------------------------------

scheduling appointments
appointment could not be inserted due to invalid data for appointment!

after scheduling appoinments:
Lehre-Termine
-------------------------------
2020/6/1 08:00-10:00 "Einfuehrung in die Philosophie" (120 min):
2020/6/1 10:00-11:30 "Vorlesung ESOFT" (90 min):
2020/6/3 14:00-15:00 "Tutorium ESOFT" (60 min):


no appoinments: 3

inserting participants
already in list of participants!
after inserting participants:
Lehre-Termine
-------------------------------
2020/6/1 08:00-10:00 "Einfuehrung in die Philosophie" (120 min): sepp@gmax.com
2020/6/1 10:00-11:30 "Vorlesung ESOFT" (90 min): sepp@gmax.com bertha@heissmail.com hugo@g
eeemail.com
2020/6/3 14:00-15:00 "Tutorium ESOFT" (60 min): sepp@gmax.com bertha@heissmail.com


removing participants
no longer in list of participants!
after removing participants:
Lehre-Termine
-------------------------------
2020/6/1 08:00-10:00 "Einfuehrung in die Philosophie" (120 min):
2020/6/1 10:00-11:30 "Vorlesung ESOFT" (90 min): sepp@gmax.com bertha@heissmail.com hugo@g
eeemail.com
2020/6/3 14:00-15:00 "Tutorium ESOFT" (60 min): sepp@gmax.com bertha@heissmail.com


removing appointment
no longer in list of appointments!
after removing appointment:
Lehre-Termine
-------------------------------
2020/6/1 10:00-11:30 "Vorlesung ESOFT" (90 min): sepp@gmax.com bertha@heissmail.com hugo@g
eeemail.com
2020/6/3 14:00-15:00 "Tutorium ESOFT" (60 min): sepp@gmax.com bertha@heissmail.com


*/
		
	}
}