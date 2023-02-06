public class MainProgramm {
	static class LeererNameException extends Exception {
		public LeererNameException(String s) {
			super(s);
		}
	}

	public static void main(String[] args) {		
		// Daten fuer Studierenden als Strings
		String[] daten = {
				"Anna Alt,70001,Medieninformatik Online",
				"Bob Berg,70002a,Technische Informatik",
				"Carla Castor,siebzig tausend und drei,Druck- und Medientechnik",
				"Daniel Dorf,70004",
				"Florian Fein,,Technische Informatik",
				",70006,Screen Based Media",
				"Greta Graf,7-00-06",
				"Horst Heinz,70008,Medieninformatik Online"
		};
		
		// Setzen Sie bitte hier fort
		for (int i = 0; i < daten.length; i++) {
			System.out.println("idx " + i + "==================================");
			try {
				String[] student = daten[i].split(",");

				if (student[0].equals("") || student[2].equals("")) {
					throw new LeererNameException("empty data entry");
				}

				try {
					Integer.parseInt(student[1]);
				} catch(Exception e) {
					throw new NumberFormatException("wrong matriculation number format");
				}

				Student s = new Student(student[0], Integer.parseInt(student[1]), student[2]);
				System.out.println(s.toString());
			}
			catch (NumberFormatException|LeererNameException|ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
		}
	}
}
