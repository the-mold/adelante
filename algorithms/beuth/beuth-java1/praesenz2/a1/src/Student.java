public class Student {
	//-------------------------------------------
	// Attribute
	private String name = "";
	private int matrikelnummer = 0;
	private String studiengang = "";
	
	//-------------------------------------------
	// Konstruktor
	public Student(String name, int matrikelnummer, String studiengang) {
		this.name = name;
		this.matrikelnummer = matrikelnummer;
		this.studiengang = studiengang;
	}
	
	//-------------------------------------------
	// Methoden
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public String getName() {
		return name;
	}
	
	public String getStudiengang() {
		return studiengang;
	}
	
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	public String toString() {
		String returnString = name
				+ " (" + matrikelnummer + "), "
				+ studiengang;
		return returnString;
	}
}
